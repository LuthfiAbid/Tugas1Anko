package com.example.tugas2kotlinankolayout.AnkoLayout

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.tugas2kotlinankolayout.R
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class Main1 : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewAfterLogin().setContentView(this)
        val txt_nama: TextView = findViewById(R.id.txt_nama)
        val ambilData = intent.getStringExtra("nama")
        txt_nama.text = ambilData
    }

    override fun onBackPressed() {
        alert(title = "Warning", message = "Apakah anda ingin keluar?") {
            positiveButton("OK") {
                finish()
            }
            negativeButton("Cancel") {
                it.dismiss()
            }
        }.show()
    }

    class ViewAfterLogin : AnkoComponent<Main1> {
        override fun createView(ui: AnkoContext<Main1>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                }
                verticalLayout {
                    lparams(width = wrapContent, height = wrapContent) {
                    }
                    textView {
                        text = "Hello"
                        textSize = 25.0f
                        textColor = Color.BLACK
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 20
                    }
                    textView {
                        text = " ${txt_nama}"
                        id = R.id.txt_nama
                        textSize = 35.0f
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                }
                verticalLayout {
                    lparams(width = matchParent, height = matchParent) {
                        backgroundColor = Color.WHITE
                    }
                    imageView {
                        imageResource = R.drawable.ic_launcher_background
                        onClick {
                            toast("Ini gambar 1")
                        }
                    }.lparams(width = wrapContent, height = wrapContent) {
                        leftMargin = 40
                        verticalMargin = 50
                    }
                    imageView {
                        imageResource = R.drawable.ic_launcher_background
                        onClick {
                            toast("Ini gambar 2")
                        }
                    }.lparams(width = wrapContent, height = wrapContent) {
                        leftMargin = 40
                        verticalMargin = 50
                    }
                    imageView {
                        imageResource = R.drawable.ic_launcher_background
                        onClick {
                            toast("Ini gambar 3")
                        }
                    }.lparams(width = wrapContent, height = wrapContent) {
                        leftMargin = 40
                        verticalMargin = 50
                    }
                }
            }
        }
    }
}