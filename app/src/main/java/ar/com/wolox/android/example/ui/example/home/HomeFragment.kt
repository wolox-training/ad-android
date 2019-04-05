package ar.com.wolox.android.example.ui.example.home

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 *
 */
class HomeFragment : WolmoFragment<HomePresenter>(), IHomeView {

    @Inject internal lateinit var mHomeNewsFragment: HomeNewsFragment
    @Inject internal lateinit var mHomeProfileFragment: HomeProfileFragment
    private lateinit var fragmentPagerAdapter: SimpleFragmentPagerAdapter
    private val sNewsTabIndex: Int = 0
    private val sProfileTabIndex: Int = 1

    override fun init() {
        fragmentPagerAdapter = SimpleFragmentPagerAdapter(childFragmentManager)
        fragmentPagerAdapter.apply {
            addFragment(mHomeNewsFragment, getString(R.string.fragment_home_news_tab_title))
            addFragment(mHomeProfileFragment, getString(R.string.fragment_home_profile_tab_title))
        }

        vHomeViewPager.adapter = fragmentPagerAdapter
        vHomeTab.setupWithViewPager(vHomeViewPager)
        vHomeTab.getTabAt(sNewsTabIndex)?.setIcon(R.drawable.home_tab_news_icon_selector)
        vHomeTab.getTabAt(sProfileTabIndex)?.setIcon(R.drawable.home_tab_profile_icon_selector)
    }

    override fun layout(): Int {
        return R.layout.fragment_home
    }
}
