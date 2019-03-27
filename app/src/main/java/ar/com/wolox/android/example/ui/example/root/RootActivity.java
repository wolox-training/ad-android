package ar.com.wolox.android.example.ui.example.root;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import ar.com.wolox.android.R;
import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.network.UserService;
import ar.com.wolox.android.example.ui.example.home.HomeActivity;
import ar.com.wolox.android.example.ui.example.login.LoginActivity;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 *
 */
public class RootActivity extends WolmoActivity {

    @Override
    protected void init() {
        validateLoginSharedPreferences();
    }

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    private void validateLoginSharedPreferences() {
        Retrofit retrofit = new Retrofit.Builder()
                // TODO: to strings.xml
                .baseUrl("https://android-training.herokuapp.com")
                .build();
        UserService userService = retrofit.create(UserService.class);
        // TODO: get str from shPr
        Call<User> userCall = userService.getUserByEmail("susanstevens");
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Intent intent;

                if (response.isSuccessful() && validateLoginData(response.body())) {
                    intent = new Intent(getApplicationContext(), HomeActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
                }

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private boolean validateLoginData(User user) {
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                getString(R.string.shared_preference_login), Context.MODE_PRIVATE);
        String password = sharedPreferences.getString(getString(
                R.string.shared_preference_password), "");
        boolean loginStatus = sharedPreferences.getBoolean(getString(
                R.string.shared_preference_login_status), false);

        if (user.getPassword().equals(password) && loginStatus) {
            return true;
        }

        return false;
    }
}
