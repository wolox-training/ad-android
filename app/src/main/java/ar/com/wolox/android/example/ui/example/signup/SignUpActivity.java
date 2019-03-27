package ar.com.wolox.android.example.ui.example.signup;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 *
 */
public class SignUpActivity extends WolmoActivity {

    @Override
    protected void init() {
        replaceFragment(R.id.vActivityBaseContent, new SignUpFragment());
    }

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }
}
