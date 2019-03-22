package ar.com.wolox.android.example.ui.example.home;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 *
 */
public class HomeFragment extends WolmoFragment<HomePresenter> implements IHomeView {

    @Override
    public void init() {}

    @Override
    public int layout() {
        return R.layout.fragment_home;
    }
}
