package ar.com.wolox.android.example.ui.example.login;

import javax.inject.Inject;

import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 *
 */
class LoginPresenter extends BasePresenter<ILoginView> {

    @Inject
    LoginPresenter() {

    }
//    @Inject
//    private UserSession mUserSession;
//
//    void storeUsername(String text) {
//        mUserSession.setUsername(text);
//        this.getView().onUsernameSaved();
//    }
}