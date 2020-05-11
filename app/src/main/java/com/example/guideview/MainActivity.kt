package com.example.guideview

import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.guideview.ContextUtils.getContext

class MainActivity : AppCompatActivity() {

    private var rectF: RectF? = null
    private var guide1: GuideView? = null
    private var guide2: GuideView? = null
    private var guide3: GuideView? = null
    private var guide4: GuideView? = null
    private var guide5: GuideView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ContextUtils.init(this)
        setContentView(R.layout.activity_main)
        guide1 = findViewById<GuideView>(R.id.guide1)
        guide2 = findViewById<GuideView>(R.id.guide2)
        guide3 = findViewById<GuideView>(R.id.guide3)
        guide4 = findViewById<GuideView>(R.id.guide4)
        guide5 = findViewById<GuideView>(R.id.guide5)

        initGuide(15)
    }

    fun initGuide(index: Int) {

        rectF = RectF()
        rectF?.set(
            ConvertUtils.dp2px(32f),
            ConvertUtils.dp2px(160f) + ConvertUtils.getStatusHeight(getContext()),
            ConvertUtils.dp2px(80f),
            ConvertUtils.dp2px(240f) + ConvertUtils.getStatusHeight(getContext())
        )
        guide1?.let {
            it.visibility = View.VISIBLE
            it.isFocusable = true
            it.isEnabled = true
            it.isClickable = true
            it.setRectF(rectF)
        }
        //guide1
        findViewById<ImageView>(R.id.base_guide1_close)
            .setOnClickListener {
                Log.e("ceshi", "1")
                initGoneGuide()
            }
        findViewById<TextView>(R.id.base_guide1_next)
            .setOnClickListener {
                Log.e("ceshi", "2")
                initGoneGuide()
                rectF?.set(
                    ConvertUtils.dp2px(80f),
                    ConvertUtils.dp2px(160f) + ConvertUtils.getStatusHeight(getContext()),
                    ConvertUtils.dp2px(215f),
                    ConvertUtils.dp2px(245f) + ConvertUtils.getStatusHeight(getContext())
                )

                guide2?.let {
                    Log.e("ceshi", "3")
                    it.visibility = View.VISIBLE
                    it.isFocusable = true
                    it.isEnabled = true
                    it.isClickable = true
                    it.setRectF(rectF)
                }
            }
        //guide2
        findViewById<ImageView>(R.id.base_guide2_close)
            .setOnClickListener { initGoneGuide() }
        findViewById<TextView>(R.id.base_guide2_next).setOnClickListener {
            initGoneGuide()
            rectF?.set(
                ConvertUtils.dp2px(32f),
                ConvertUtils.dp2px(255f) + ConvertUtils.getStatusHeight(getContext()),
                ConvertUtils.dp2px(80f),
                ConvertUtils.dp2px(330f) + ConvertUtils.getStatusHeight(getContext())
            )
            guide3?.let {
                it.visibility = View.VISIBLE
                it.isFocusable = true
                it.isEnabled = true
                it.isClickable = true
                it.setRectF(rectF)
            }
        }

        //guide3
        findViewById<ImageView>(R.id.base_guide3_close)
            .setOnClickListener { initGoneGuide() }
        findViewById<TextView>(R.id.base_guide3_next).setOnClickListener {
            initGoneGuide()
            guide4?.let {
                it.setValue(index)
                it.visibility = View.VISIBLE
                it.isFocusable = true
                it.isEnabled = true
                it.isClickable = true
                it.setRectF(rectF)
                it.setMore(true)
            }
        }

        //guide4
        findViewById<ImageView>(R.id.base_guide4_close)
            .setOnClickListener { initGoneGuide() }
        findViewById<TextView>(R.id.base_guide4_next).setOnClickListener {
            initGoneGuide()
            guide5?.let {
                it.visibility = View.VISIBLE
                it.isFocusable = true
                it.isEnabled = true
                it.isClickable = true
                it.setCircle(true)
            }
        }

        //guide5
        findViewById<ImageView>(R.id.base_guide5_close)
            .setOnClickListener { initGoneGuide() }
        findViewById<TextView>(R.id.base_guide5_next)
            .setOnClickListener { initGoneGuide() }

    }

    private fun initGoneGuide() {
        guide1?.visibility = View.GONE
        guide2?.visibility = View.GONE
        guide3?.visibility = View.GONE
        guide4?.visibility = View.GONE
        guide5?.visibility = View.GONE
    }
}
