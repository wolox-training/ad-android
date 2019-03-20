package ar.com.wolox.android.example.ui.example.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;

/**
 * A simple {@link WolmoFragment} subclass.
 */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements ILoginView {
    @BindView(R.id.vLoginEmailEditText)
    EditText vLoginEmailEditText;

    @BindView(R.id.vLoginPasswordEditText)
    EditText vLoginPasswordEditText;

    @BindView(R.id.vLoginLogInButton)
    Button vLoginLogInButton;

    @Override
    public void init() {}

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void setListeners() {
        vLoginLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = vLoginEmailEditText.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    vLoginEmailEditText.setError(getString(R.string.
                            fragment_login_empty_field_error_message));
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    vLoginEmailEditText.setError(getString(R.string.
                            fragment_login_invalid_email_error_message));
                } else {
                    SharedPreferences sharedPreferences = getActivity().getPreferences(Context.
                            MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(getString(R.string.shared_preference_email), email);
                    editor.apply();
                }
            }
        });
    }

    @Override
    public void onUsernameSaved() {
        //TODO: launch next activity
    }
}
