package ar.com.wolox.android.example.ui.example.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.example.home.HomeActivity;
import ar.com.wolox.android.example.ui.example.signup.SignUpActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import ar.com.wolox.wolmo.core.util.ToastFactory;
import butterknife.BindView;

/**
 * A simple {@link WolmoFragment} subclass.
 */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements ILoginView {

    @BindView(R.id.vLoginTermsAndConditionsTextView) TextView vLoginTermsAndConditionsTextView;
    @BindView(R.id.vLoginEmailEditText) EditText vLoginEmailEditText;
    @BindView(R.id.vLoginPasswordEditText) EditText vLoginPasswordEditText;
    @BindView(R.id.vLoginLogInButton) Button vLoginLogInButton;
    @BindView(R.id.vLoginSignUpButton) Button vLoginSignUpButton;

    @Inject ToastFactory mToastFactory;

    @Override
    public void init() {
        loadLoginData();
    }

    private void loadLoginData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(
                getString(R.string.shared_preference_login), Context.MODE_PRIVATE);
        vLoginEmailEditText.setText(sharedPreferences.getString(getString(R.string.
                shared_preference_email), ""));
        vLoginPasswordEditText.setText(sharedPreferences.getString(getString(R.string.
                shared_preference_password), ""));
    }

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
                String password = vLoginPasswordEditText.getText().toString();
                getPresenter().onLoginValidation(email, password);
            }
        });

        vLoginSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SignUpActivity.class));
            }
        });

        vLoginTermsAndConditionsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(
                        R.string.fragment_login_termns_and_conditions_uri))));
            }
        });
    }

    @Override
    public void onEmptyEmail() {
        vLoginEmailEditText.setError(getString(R.string.fragment_login_empty_field_error_message));
    }

    @Override
    public void onInvalidEmailFormat() {
        vLoginEmailEditText.setError(getString(R.string.
                fragment_login_invalid_email_error_message));
    }

    @Override
    public void onEmptyPassword() {
        vLoginPasswordEditText.setError(getString(R.string.
                fragment_login_empty_field_error_message));
    }

    @Override
    public void onValidLoginData() {
        saveLoginDataOnSharedPreferences(vLoginEmailEditText.getText().toString(),
                vLoginPasswordEditText.getText().toString());
        Intent intent = new Intent(getContext(), HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void saveLoginDataOnSharedPreferences(String email, String password) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(
                getString(R.string.shared_preference_login), Context.MODE_PRIVATE);
        sharedPreferences.edit()
            .putString(getString(R.string.shared_preference_email), email)
            .putString(getString(R.string.shared_preference_password), password)
            .putBoolean(getString(R.string.shared_preference_login_status), true)
            .apply();
    }

    @Override
    public void onInvalidLoginData() {
        mToastFactory.show(R.string.fragment_login_invalid_email_or_password_toast);
    }

    @Override
    public void onServerError() {
        mToastFactory.show(R.string.fragment_login_server_error_toast);
    }

    @Override
    public void onInvalidCallError() {
        mToastFactory.show(R.string.fragment_login_invalid_call_error_toast);
    }
}
