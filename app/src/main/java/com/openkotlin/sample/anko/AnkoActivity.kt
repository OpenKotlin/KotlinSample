package com.openkotlin.sample.anko

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.openkotlin.sample.R
import org.jetbrains.anko.*

class AnkoActivity : AppCompatActivity() {

    companion object {
        val TAG = AnkoActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AnkoLayout().setContentView(this)
        initView()
    }

    private fun initView() {
        find<Button>(R.id.btnGetExtras).setOnClickListener {
            Log.d(TAG, "key = ${intent.extras?.getString("key")}, intKey = ${intent.extras?.getInt("intKey")}")
        }
        find<Button>(R.id.btnBrowse).setOnClickListener {
            browse("https://www.kotlincn.net/docs/reference/")
        }
        find<Button>(R.id.btnPxDpConvert).setOnClickListener {
            val dpValue = 100
            // dp to px
            val px = dip(dpValue)
            // px to dp
            val dp = px2dip(px)
            Log.d(TAG, "px = $px, dp = $dp")
        }
        find<Button>(R.id.btnAttempt).setOnClickListener {
            // attempt 对应 java 中的 try / catch
            // attempt 若正常执行，value 返回代码块中的返回值
            var result = attempt { 3 }
            Log.d(TAG, "value = ${result.value}, error = ${result.error}, isError = ${result.isError}, hasValue = ${result.hasValue}")
            // attempt 若执行出错，error 中携带错误信息
            result = attempt { 1 / 0 }
            Log.d(TAG, "value = ${result.value}, error = ${result.error}, isError = ${result.isError}, hasValue = ${result.hasValue}")
        }
        find<Button>(R.id.btnSdkVersion).setOnClickListener {
            // sdk 大于等于 21 才执行
            doFromSdk(21) {
                Log.d(TAG, "sdk version >= 21")
            }
            // sdk 等于 29 才执行
            doIfSdk(29) {
                Log.d(TAG, "sdk version == 29")
            }
        }
        find<Button>(R.id.btnAlert).setOnClickListener {
            alert("I'm an anko alert.") {
                customTitle {
                    verticalLayout {
                        orientation = LinearLayout.HORIZONTAL
                        padding = dip(8)
                        gravity = Gravity.CENTER_VERTICAL
                        imageView(R.mipmap.ic_launcher)
                        textView("Title"){
                            padding = dip(8)
                        }
                    }
                }
                okButton {
                    toast("OK")
                }
                cancelButton {
                    toast("Cancel")
                }
            }.show()
        }
        find<Button>(R.id.btnSelector).setOnClickListener {
            val ages = listOf("10~20", "20~30", "30~40", ">40")
            selector("How old are you?", ages) { _, i ->
                toast(ages[i])
            }
        }
    }
}
