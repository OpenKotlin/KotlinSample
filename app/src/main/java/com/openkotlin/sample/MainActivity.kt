package com.openkotlin.sample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.openkotlin.sample.anko.AnkoActivity
import com.openkotlin.sample.collections.CollectionsActivity
import com.openkotlin.sample.extension.ExtensionActivity
import com.openkotlin.sample.getStarted.GetStartedActivity
import com.openkotlin.sample.recyclerView.RecyclerViewActivity
import com.openkotlin.sample.operations.OperationsActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btnGetStarted.setOnClickListener {
            jumpActivity(GetStartedActivity::class)
        }
        btnOperations.setOnClickListener {
            jumpActivity(OperationsActivity::class)
        }
        btnExtension.setOnClickListener {
            jumpActivity(ExtensionActivity::class)
        }
        btnRecyclerView.setOnClickListener {
            jumpActivity(RecyclerViewActivity::class)
        }
        btnCollections.setOnClickListener {
            jumpActivity(CollectionsActivity::class)
        }
        btnAnko.setOnClickListener {
            // anko 句法：带有参数的启动 Activity
            // 注意头文件中需要 import org.jetbrains.anko.startActivity，否则会默认调用 Activity 的 startActivity 方法
            startActivity<AnkoActivity>("key" to "value", "intKey" to 666)
        }
    }
}

// kotlin 扩展函数
fun Context.jumpActivity(kClass: KClass<out Activity>) {
    startActivity(Intent(this, kClass.java))
}
