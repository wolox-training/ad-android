package ar.com.wolox.android.example.ui.example.home

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity

/**
 *
 */
class HomeActivity : WolmoActivity() {

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, HomeFragment())
    }

    override fun layout(): Int {
        return R.layout.activity_base
    }
}
