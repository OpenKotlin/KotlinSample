package com.openkotlin.sample.collections

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.openkotlin.sample.R
import kotlinx.android.synthetic.main.activity_collections.*

class CollectionsActivity : AppCompatActivity() {

    companion object {
        val TAG = CollectionsActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collections)
        initView()
    }

    private fun initView() {
        btnMap.setOnClickListener {
            val list = (1..3).toList()
            // map 用于将一个对象转换为另一个对象
            val stringList = list.map {
                "item $it"
            }
            stringList.forEach {
                Log.d(TAG, it)
            }
        }

        btnFlatMap.setOnClickListener {
            val list = (1..3).toList()
            // flatMap 用于将列表展开，再把返回的列表拼接成新列表
            val stringList = list.flatMap {
                listOf("item", it)
            }
            for (item in stringList) {
                Log.d(TAG, "$item")
            }
        }
        btnFilter.setOnClickListener {
            val list = (1..5).toList()
            // filter 是过滤出满足条件的 item，而不是过滤掉
            val oddList = list.filter {
                it % 2 == 1
            }
            oddList.forEach {
                Log.d(TAG, "$it")
            }
        }
    }
}


