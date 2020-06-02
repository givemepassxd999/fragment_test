package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_singer.*

class SingerFragment : Fragment() {

    private lateinit var adapter: SingerPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_singer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SingerPagerAdapter(childFragmentManager)
        singer_viewpager.adapter = adapter
        singer_viewpager.offscreenPageLimit = 2
        singer_tab_layout.setupWithViewPager(singer_viewpager)
    }

    companion object {
        fun newSingerInstance(): SingerFragment {
            return SingerFragment()
        }
    }
}