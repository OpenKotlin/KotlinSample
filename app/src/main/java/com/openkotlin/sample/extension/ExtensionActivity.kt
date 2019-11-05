package com.openkotlin.sample.extension

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.openkotlin.sample.R
import kotlinx.android.synthetic.main.activity_extension.*

class ExtensionActivity : AppCompatActivity() {

    companion object {
        private val TAG = ExtensionActivity::class.simpleName
    }

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension)
        initView()
    }

    private fun initView() {
        btnIncrease.setOnClickListener {
            // 调用扩展方法，就好像此 Int 对象本身就具有此方法一样
            count = count.increase()
            btnIncrease.text = count.toString()
        }

        btnTimeStamp.setOnClickListener {
            Log.d(TAG, "timeStamp:$timeStamp")
        }
    }
}

// Kotlin 可以给任意对象拓展函数，如此例中给 Int 对象扩展了一个自增函数
fun Int.increase(): Int {
    return this + 1
}

// Kotlin 可以给任意对象扩展属性，如此例中给 Context 对象扩展了一个时间戳属性
val Context.timeStamp: Long
    get() = System.currentTimeMillis()