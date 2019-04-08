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

    @Inject internal lateinit var homeNewsFragment: HomeNewsFragment
    @Inject internal lateinit var homeProfileFragment: HomeProfileFragment

    private lateinit var fragmentPagerAdapter: SimpleFragmentPagerAdapter

    companion object {

        enum class TabIndex(val index: Int) {

            NEWS(0),
            PROFILE(1)
        }
    }

    override fun init() {
        fragmentPagerAdapter = SimpleFragmentPagerAdapter(childFragmentManager)
        fragmentPagerAdapter.apply {
            addFragment(homeNewsFragment, getString(R.string.fragment_home_news_tab_title))
            addFragment(homeProfileFragment, getString(R.string.fragment_home_profile_tab_title))
        }

        vHomeViewPager.adapter = fragmentPagerAdapter
        vHomeTab.setupWithViewPager(vHomeViewPager)
        vHomeTab.getTabAt(TabIndex.NEWS.index)?.setIcon(R.drawable.home_tab_news_icon_selector)
        vHomeTab.getTabAt(TabIndex.PROFILE.index)?.setIcon(R.drawable.home_tab_profile_icon_selector)
    }

    override fun layout(): Int = R.layout.fragment_home
}
