package ar.com.wolox.android.example.ui.example.login;

import android.text.TextUtils;
import android.util.Patterns;
import javax.inject.Inject;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 *
 */
class LoginPresenter extends BasePresenter<ILoginView> {

    @Inject
    LoginPresenter() {}

    void onLoginValidation(String email, String password) {
        boolean isValidEmail = validateEmail(email);
        boolean isValidPassword = validatePassword(password);

        if (isValidEmail && isValidPassword) {
            getView().onValidatedLogin();
        }
    }

    private boolean validateEmail(String email) {
        boolean isValidEmail = false;

        if (TextUtils.isEmpty(email)) {
            getView().onEmptyEmail();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            getView().onInvalidEmailFormat();
        } else {
            isValidEmail = true;
        }

        return isValidEmail;
    }

    private boolean validatePassword(String password) {
        boolean isValidPassword = false;

        if (TextUtils.isEmpty(password)) {
            getView().onEmptyPassword();
        } else {
            isValidPassword = true;
        }

        return isValidPassword;
    }
}
