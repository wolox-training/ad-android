package ar.com.wolox.android.example.ui.example.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.example.login.LoginActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;

/**
 *
 */
public class HomeFragment extends WolmoFragment<HomePresenter> implements IHomeView {

    @BindView(R.id.vHomeLogoutButton) Button vHomeLogoutButton;

    @Override
    public void init() {}

    @Override
    public void setListeners() {
        vHomeLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
                startActivity(new Intent(getContext(), LoginActivity.class).addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
            }
        });
    }

    @Override
    public int layout() {
        return R.layout.fragment_home;
    }

    private void logout() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(getString(
                R.string.shared_preference_login), Context.MODE_PRIVATE);
        sharedPreferences.edit()
                .putBoolean(getString(R.string.shared_preference_login_status), false)
                .apply();
    }
}
