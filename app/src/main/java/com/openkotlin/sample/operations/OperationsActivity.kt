package com.openkotlin.sample.operations

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.openkotlin.sample.R
import kotlinx.android.synthetic.main.activity_operations.*
import org.jetbrains.anko.textColor
import org.jetbrains.anko.toast

class OperationsActivity : AppCompatActivity() {

    companion object {
        val TAG = OperationsActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operations)
        initView()
    }

    private fun initView() {
        btnApply.setOnClickListener {
            // apply 方法用于更方便的调用一个对象的内部属性或方法，返回值为其本身
            val result = btnApply.apply {
                text = getString(R.string.i_m_apply)
                textColor = Color.BLUE
                // apply 并不会影响其他方法的调用
                toast(getString(R.string.i_m_apply))
            }
            Log.d(TAG, "result == btnApply ? ${result == btnApply}")
        }

        btnAlso.setOnClickListener {
            val result = btnAlso.also {
                toast(getString(R.string.i_m_also))
                it.text = getString(R.string.i_m_also)
            }
            Log.d(TAG, "result == btnAlso ? ${result == btnAlso}")
        }

        btnLet.setOnClickListener {
            // let 方法用于执行一段逻辑并返回一个结果，返回值为 let 代码块中的最后一行。
            val result = btnLet.let {
                // let 代码块中使用 it 代表此对象
                it.text = getString(R.string.i_m_let)
                toast(getString(R.string.i_m_let))
                "The last line is returned value"
            }
            Log.d(TAG, "result of let: $result")
        }

        btnWith.setOnClickListener {
            val result = with(btnWith) {
                text = getString(R.string.i_m_with)
                toast(getString(R.string.i_m_with))
                "The last line is returned value"
            }
            Log.d(TAG, "result of with: $result")
        }

        btnRun.setOnClickListener {
            val result = btnRun.run {
                text = getString(R.string.i_m_run)
                toast(R.string.i_m_run)
                "The last line is returned value"
            }
            Log.d(TAG, "result of run: $result")
        }

        btnTakeIf.setOnClickListener {
            val resultOfTrue = "If true I'll be token".takeIf {
                // 这里可以放置逻辑，最后一行作为返回值
                true
            }
            val resultOfFalse = "If false I won't be token".takeIf { false }
            Log.d(TAG, "takeIf: resultOfTrue: $resultOfTrue, resultOfFalse: $resultOfFalse")
        }

        btnTakeUnless.setOnClickListener {
            // takeUnless 和 takeIf 相反
            val resultOfTrue = "If true I won't be token".takeUnless {
                // 这里可以放置逻辑，最后一行作为返回值
                true
            }
            val resultOfFalse = "If false I'll be token".takeUnless { false }
            Log.d(TAG, "takeUnless: resultOfTrue: $resultOfTrue, resultOfFalse: $resultOfFalse")
        }

        btnRepeat.setOnClickListener {
            // repeat 用来执行 n 次重复的逻辑，it 代表第几次循环，从 0 开始计
            repeat(3) {
                Log.d(TAG, "repeat: $it")
            }
        }

    }
}
