package com.example.myapplication

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_singer_detail.*

class SingerDetailItem1Fragment : Fragment() {
    private lateinit var adapter: SingerItemDetailAdapter
    private var scrollState: Parcelable? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_singer_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SingerItemDetailAdapter()
        recycler_view.adapter = adapter
        val manager = GridLayoutManager(context, 4)
        recycler_view.layoutManager = manager
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("item","onSaveInstanceState")
        outState.putParcelable("pos_data", recycler_view.layoutManager?.onSaveInstanceState())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e("item","onViewStateRestored")
        scrollState = savedInstanceState?.getParcelable("pos_data")
        if(scrollState != null){
            recycler_view.layoutManager?.onRestoreInstanceState(scrollState)
            scrollState = null
        }
    }

    companion object {
        fun newSingerInstance(): SingerDetailItem1Fragment {
            return SingerDetailItem1Fragment()
        }
    }
}