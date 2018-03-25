package tech.wandering_engineer.hohokekyo.Fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.view.*
import tech.wandering_engineer.hohokekyo.R

/**
 * Created by user on 2018/03/13.
 * Copied from placeholder fragment on MainActivity containing a simple view.
 */
open class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        //rootView.section_label.text = getString(R.string.section_format, arguments.getInt(ARG_SECTION_NUMBER))
        rootView.uguisuButton.setOnClickListener {
            // action
        }
        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): BaseFragment {
            val fragment = BaseFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}