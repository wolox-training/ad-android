package ar.com.wolox.android.example.ui.example.login;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Patterns;
import java.util.List;
import javax.inject.Inject;
import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.network.UserService;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import ar.com.wolox.wolmo.networking.retrofit.callback.NetworkCallback;
import okhttp3.ResponseBody;

/**
 *
 */
public class LoginPresenter extends BasePresenter<ILoginView> {

    @Inject RetrofitServices mRetrofitService;

    @Inject LoginPresenter() {}

    void onLoginValidation(@NonNull String email, @NonNull String password) {
        boolean isValidEmailFormat = validateEmailFormat(email);
        boolean isValidPasswordFormat = validatePasswordFormat(password);

        if (isValidEmailFormat && isValidPasswordFormat) {
            mRetrofitService.getService(UserService.class).getUserByEmail(email).enqueue(
                    new NetworkCallback<List<User>>() {

                @Override
                public void onResponseSuccessful(@Nullable List<User> users) {
                    if (users != null && !users.isEmpty() && users.get(0).getPassword().
                            equals(password)) {
                        getView().onValidLoginData();
                    } else {
                        getView().onInvalidLoginData();
                    }
                }

                @Override
                public void onResponseFailed(@Nullable ResponseBody responseBody, int i) {
                    getView().onServerError();
                }

                @Override
                public void onCallFailure(Throwable throwable) {
                    getView().onInvalidCallError();
                }
            });
        }
    }

    private boolean validateEmailFormat(@NonNull String email) {
        boolean isValidEmailFormat = false;

        if (TextUtils.isEmpty(email)) {
            getView().onEmptyEmail();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            getView().onInvalidEmailFormat();
        } else {
            isValidEmailFormat = true;
        }

        return isValidEmailFormat;
    }

    private boolean validatePasswordFormat(@NonNull String password) {
        boolean isValidPasswordFormat = false;

        if (TextUtils.isEmpty(password)) {
            getView().onEmptyPassword();
        } else {
            isValidPasswordFormat = true;
        }

        return isValidPasswordFormat;
    }
}
