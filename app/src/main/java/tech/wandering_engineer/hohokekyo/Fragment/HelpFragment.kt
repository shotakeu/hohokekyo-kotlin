package tech.wandering_engineer.hohokekyo.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.wandering_engineer.hohokekyo.R

/**
 * Created by user on 2018/03/13.
 * Copied from placeholder fragment on MainActivity containing a simple view.
 */
class HelpFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_help, container, false)
        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number2"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): HelpFragment {
            val fragment = HelpFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}