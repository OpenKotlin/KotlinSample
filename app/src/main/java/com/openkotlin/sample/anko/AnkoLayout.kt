package com.openkotlin.sample.anko

import android.view.View
import com.openkotlin.sample.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.button
import org.jetbrains.anko.verticalLayout

/**
 * Anko 在代码中编写布局示例
 */
class AnkoLayout : AnkoComponent<AnkoActivity> {
    override fun createView(ui: AnkoContext<AnkoActivity>): View {
        return with(ui) {
            verticalLayout {
                button {
                    id = R.id.btnGetExtras
                    text = resources.getString(R.string.get_extras)
                }
                button {
                    id = R.id.btnBrowse
                    text = resources.getString(R.string.browse)
                }
                button {
                    id = R.id.btnPxDpConvert
                    text = resources.getString(R.string.px_dp_convert)
                }
                button {
                    id = R.id.btnAttempt
                    text = resources.getString(R.string.attempt)
                }
                button {
                    id = R.id.btnSdkVersion
                    text = resources.getString(R.string.sdk_version)
                }
                button {
                    id = R.id.btnAlert
                    text = resources.getString(R.string.alert)
                }
                button {
                    id = R.id.btnSelector
                    text = resources.getString(R.string.selector)
                }
            }
        }
    }
}