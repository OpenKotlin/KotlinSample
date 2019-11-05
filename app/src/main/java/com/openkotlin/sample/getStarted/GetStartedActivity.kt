package com.openkotlin.sample.getStarted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.openkotlin.sample.R
import kotlinx.android.synthetic.main.activity_get_started.*
import org.jetbrains.anko.toast
import java.util.*

class GetStartedActivity : AppCompatActivity() {

    companion object {
        // kotlin 的伴生对象对应 java 中的静态变量和静态方法
        val TAG = GetStartedActivity::class.simpleName
    }

    // kotlin 使用 by lazy 实现懒加载，变量将在被使用时初始化。需要注意 by lazy 只能对不可变的 val 变量使用
    // 使用 by lazy 需要注意的一点：有的变量其实并没有使用，但在 onDestroy 中调用了 release 释放。使用 by lazy 的话
    // 会先在调用 release 的时候将这个变量先初始化，再 release。引起不必要的逻辑。对于这种情况推荐使用 lateinit
    private val lazyValue by lazy { "I'll be initialed while be used." }

    // 使用 lateinit 关键字表示稍后再初始化，这在定义非空类型的变量时非常有用。
    // 因为如果一个变量初始化成 null，容易造成大量的 ? 判空操作
    private lateinit var lateInitValue: Date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)
        initView()
    }

    private fun initView() {
        // kotlin 中不再需要 findViewById，直接使用布局中的 id 使用控件即可。所以使用 kotlin 时，推荐 id 直接使用驼峰法命名
        btnFindView.setOnClickListener {
            // 这里看起来就像是在使用 button 的 text 属性，但其实它是调用的 setText() 方法，kotlin 中没有显式的 get、set 方法，
            // get、 set 方法调用起来类似属性。但本质上还是调用的 get、 set 方法
            btnFindView.text = getString(R.string.goodbye_find_view_by_id)
        }

        btnToast.setOnClickListener {
            // 调用 anko 语法糖中的 toast
            toast("I'm a simple toast.")
        }

        btnIsInitialed.setOnClickListener {
            // 判断 lateinit 的变量是否已被初始化
            Log.d(TAG, "isInitialed: ${::lateInitValue.isInitialized}")
        }
    }
}
