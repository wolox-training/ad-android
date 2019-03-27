package ar.com.wolox.android.example.ui.example.root;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import ar.com.wolox.android.R;
import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.network.UserService;
import ar.com.wolox.android.example.ui.example.home.HomeActivity;
import ar.com.wolox.android.example.ui.example.login.LoginActivity;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;
import ar.com.wolox.wolmo.networking.retrofit.callback.NetworkCallback;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class RootActivity extends WolmoActivity {

    @Override
    protected void init() {
        validateLogin();
    }

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    private void validateLogin() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                getString(R.string.shared_preference_login), Context.MODE_PRIVATE);
        String email = sharedPreferences.getString(getString(R.string.shared_preference_email),
                "");
        String password = sharedPreferences.getString(getString(
                R.string.shared_preference_password), "");
        boolean wasLoggedIn = sharedPreferences.getBoolean(
                getString(R.string.shared_preference_login_status), false);

        /* This check is to optimize avoiding the request to the REST API */
        if (!wasLoggedIn || TextUtils.isEmpty(email)) {
            launchLoginActivity();
        } else {
           validateLoginWithDatabase(email, password);
        }
    }

    private void validateLoginWithDatabase(String email, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.rest_api_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService userService = retrofit.create(UserService.class);
        Call<List<User>> userCall = userService.getUserByEmail(email);
        userCall.enqueue(new NetworkCallback<List<User>>() {
            @Override
            public void onResponseSuccessful(@Nullable List<User> users) {
                Intent intent;

                if (users != null && !users.isEmpty() && users.get(0).getPassword().
                        equals(password)) {
                    intent = new Intent(getApplicationContext(), HomeActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
                }

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            @Override
            public void onResponseFailed(@Nullable ResponseBody responseBody, int i) {
                launchLoginActivity();
            }

            @Override
            public void onCallFailure(Throwable throwable) {
                launchLoginActivity();
            }
        });
    }

    private void launchLoginActivity() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
