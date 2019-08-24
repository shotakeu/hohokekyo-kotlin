package tech.wandering_engineer.hohokekyo.Activity

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import tech.wandering_engineer.hohokekyo.Fragment.HelpFragment
import tech.wandering_engineer.hohokekyo.Fragment.HohokekyoFragment
import tech.wandering_engineer.hohokekyo.R

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {


    companion object {
        const val TAB_NUM = 2
    }

    /**
     * The [androidx.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [androidx.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val tabLayout: TabLayout = findViewById(R.id.tabs)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        mViewPager = findViewById(R.id.container)
        mViewPager!!.adapter = mSectionsPagerAdapter
        mViewPager!!.addOnPageChangeListener(this)
        tabLayout.setupWithViewPager(mViewPager)
        mViewPager!!.offscreenPageLimit = TAB_NUM

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        /**
         * このへんは言われたからやっただけ
         * @see https://developer.android.com/studio/write/app-link-indexing
         **/
        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        val appLinkAction = intent.action
        val appLinkData: Uri? = intent.data
        if (Intent.ACTION_VIEW == appLinkAction) {
            appLinkData?.lastPathSegment?.also { recipeId ->
                Uri.parse("content://wandering-engineer.tech/my-apps/")
                        .buildUpon()
                        .appendPath(recipeId)
                        .build().also { appData ->
                            //showRecipe(appData)
                        }
            }
        }
    }


//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }

    //    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        val id = item.itemId
//
//        if (id == R.id.action_settings) {
//            return true
//        }
//
//        return super.onOptionsItemSelected(item)
//    }
    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> { //なにもしない

            }
            1 -> { //特に何もしない
            }
        }
    }

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            when (position) {
                0 -> {
                    Log.d("shotakeu", "this position is " + position)
                    return HohokekyoFragment.newInstance(position)
                }
                1 -> {
                    Log.d("shotakeu", "this position is " + position)

                    return HelpFragment.newInstance(position)
                }
                else -> {
                    Log.d("shotakeu", "this position is " + position)
                    return HohokekyoFragment.newInstance(position)
                }
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> {
                    return getString(R.string.sound)
                }
                1 -> {
                    return getString(R.string.help)
                }
            }
            return null
        }

        override fun getCount(): Int {
            return TAB_NUM
        }
    }
}
