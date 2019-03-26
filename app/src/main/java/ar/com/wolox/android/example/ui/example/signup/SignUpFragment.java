package ar.com.wolox.android.example.ui.example.signup;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 *
 */
public class SignUpFragment extends WolmoFragment<SignUpPresenter> implements ISignUpView {

    @Override
    public void init() {}

    @Override
    public int layout() {
        return R.layout.fragment_sign_up;
    }
}
