package com.example.bwkandroidstudy

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 코드 내부에서 View 생성(초기화)
        val name = TextView(this).apply {
            // 글씨 타입(기본_굵게)
            typeface = Typeface.DEFAULT_BOLD
            // 텍스트 세팅
            text = "Lake Louise"
        }

        // apply 는 초기화에만 사용한다면 also 는 초기화 뿐만아니라 추가적인 작업(이미지 세팅)을 한 후 반환할 때 사용
        val image = ImageView(this).also {
            it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background))
        }

        val address = TextView(this).apply {
            typeface = Typeface.DEFAULT_BOLD
            text = "Lake Louise, AB, 캐나다"
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER

            addView(name, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            addView(image, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            addView(address, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        setContentView(layout)
        //setContentView(R.layout.activity_main)
    }
}