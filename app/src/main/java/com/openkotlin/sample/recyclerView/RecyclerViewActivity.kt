package com.openkotlin.sample.recyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.openkotlin.sample.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initView()
    }

    private fun initView() {
        rv.layoutManager = LinearLayoutManager(this)
        val items = (1..100).toList().map {
            it.toString()
        }
        val adapter = MyRecyclerViewAdapter(items)
        rv.adapter = adapter
    }
}
