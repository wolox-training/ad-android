package ar.com.wolox.android.example.ui.example.root;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 *
 */
public class RootActivity extends WolmoActivity {

    @Override
    protected void init() {
        //TODO: see Shared Preferences, then choose to launch Home or Login activity
    }

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }
}
