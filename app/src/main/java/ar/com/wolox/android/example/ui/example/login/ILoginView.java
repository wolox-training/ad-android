package ar.com.wolox.android.example.ui.example.login;

/**
 * Login view
 */
interface ILoginView {

    void onEmptyEmail();

    void onInvalidEmailFormat();

    void onEmptyPassword();

    void onValidatedLogin();

    void onServerError();

    void onInvalidCallError();

    void onInvalidLoginData();
}
