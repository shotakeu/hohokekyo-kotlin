package tech.wandering_engineer.hohokekyo.Fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.fragment_main.view.*
import tech.wandering_engineer.hohokekyo.BuildConfig
import tech.wandering_engineer.hohokekyo.R

/**
 * Created by user on 2018/03/13.
 * うぐいすfragment
 */
class HohokekyoFragment : Fragment() {
    /**
     * AdMob Banner AdView
     */
    private lateinit var mAdView: AdView
    private var hokekyoSound: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // AdMob
        MobileAds.initialize(context, BuildConfig.ADMOB_ID)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        // AdMobBanner Request
        mAdView = rootView.findViewById(R.id.adMobBannerView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        // hohokekyoSound
        hokekyoSound = MediaPlayer.create(context, R.raw.hohokekyo)

        rootView.uguisuButton.setOnClickListener {
            hokekyoSound?.start()
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number1"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): Fragment {
            val fragment = HohokekyoFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}