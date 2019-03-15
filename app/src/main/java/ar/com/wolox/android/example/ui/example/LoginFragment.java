package ar.com.wolox.android.example.ui.example;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * A simple {@link WolmoFragment} subclass.
 */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements ILoginView {

    @Override
    public void init() {

    }

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void onUsernameSaved() {

    }
}
