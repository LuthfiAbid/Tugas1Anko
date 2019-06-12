package com.example.tugas2kotlinankolayout.AnkoLayout

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import com.example.tugas2kotlinankolayout.R
import org.jetbrains.anko.*

class Main2 : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewLogin().setContentView(this)
        val unama: TextView = findViewById(R.id.et_nama)
        val btn: Button = findViewById(R.id.btn_login)

        btn.setOnClickListener {
            val nama = unama.text.toString().trim()
            handlingForLogin(nama)
        }
    }

    class ViewLogin : AnkoComponent<Main2> {
        override fun createView(ui: AnkoContext<Main2>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                    verticalGravity = Gravity.CENTER
                    backgroundColor = Color.GRAY
                }
                verticalLayout {
                    lparams(width = matchParent, height = wrapContent) {
                        backgroundColor = Color.WHITE
                        margin = 15
                        padding = 10
                    }
                    textView {
                        text = "Input Form"
                        textSize = 25.0f
                        textColor = Color.CYAN
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                    editText {
                        hint = "input namamu"
                        id = R.id.et_nama
                        inputType = InputType.TYPE_CLASS_TEXT
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                    button("Submit") {
                        id = R.id.btn_login
                    }.lparams(width = wrapContent, height = wrapContent) {
                        margin = 15
                        gravity = Gravity.CENTER
                    }
                }
            }
        }
    }

    private fun handlingForLogin(unama: String) {
        info { "username = $unama" }
        if (!unama.equals("")) {
            toast("Welcome $unama!")
            startActivity(intentFor<Main1>("nama" to unama))
            finish()
        } else {
            alert(title = "Warning", message = "Nama harus diisi!") {
                positiveButton(buttonText = "OK") {
                    it.dismiss()
                }
                isCancelable = false
            }.show()
        }
    }
}