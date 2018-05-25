package tech.wandering_engineer.hohokekyo.Fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.view.*
import tech.wandering_engineer.hohokekyo.R

/**
 * Created by user on 2018/03/13.
 * うぐいすfragment
 */
class HohokekyoFragment : Fragment() {

    var hokekyoSound : MediaPlayer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        hokekyoSound = MediaPlayer.create(context, R.raw.hohokekyo)
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        rootView.uguisuButton.setOnClickListener {
            Log.d("shotakeu", "uguisuButton")
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