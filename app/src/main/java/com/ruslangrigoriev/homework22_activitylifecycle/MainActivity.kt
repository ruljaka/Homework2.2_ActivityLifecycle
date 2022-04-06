package com.ruslangrigoriev.homework22_activitylifecycle

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_COUNT = "extra.COUNT"
    }

    private var count = 0
    private var tvCountShow: TextView? = null
    private var btnCount: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCount = findViewById(R.id.btn_count)
        tvCountShow = findViewById(R.id.tv_count_show)

        btnCount?.setOnClickListener {
            count++
            tvCountShow?.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(EXTRA_COUNT, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(EXTRA_COUNT)
        tvCountShow?.text = count.toString()
    }
}