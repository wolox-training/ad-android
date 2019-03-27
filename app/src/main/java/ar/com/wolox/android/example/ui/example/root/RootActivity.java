package ar.com.wolox.android.example.ui.example.root;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.example.home.HomeActivity;
import ar.com.wolox.android.example.ui.example.login.LoginActivity;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 *
 */
public class RootActivity extends WolmoActivity {

    @Override
    protected void init() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                getString(R.string.shared_preference_login), Context.MODE_PRIVATE);
        boolean loginStatus = sharedPreferences.getBoolean(getString(
                R.string.shared_preference_login_status), false);

        Intent intent;

        if (loginStatus) {
            intent = new Intent(this, HomeActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }
}
