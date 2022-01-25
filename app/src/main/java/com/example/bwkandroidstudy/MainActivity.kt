package com.example.bwkandroidstudy

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)
//
//        val text = findViewById<TextView>(R.id.text)
//        val image = findViewById<ImageView>(R.id.image)
//
//        text.text = "비밀번호 확인"
//        image.setImageResource(R.drawable.ic_launcher_background)
        // 이미지버튼이란걸로 확인해보라
        setContentView(R.layout.activity_main2)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "비밀번호 확인"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setBackgroundDrawable(getDrawable(R.drawable.ic_launcher_background))
        /*
         * dpi
         * dip
         * dp
         * sp
         * px
         * 나인패치? 점선?
         * res 내부 -> raw, navigation 등
         * layoutInflater?
         *
         * 모듈 apk 로 뽑으면 무슨일이?
         *
         * 8-3 이미지
         * 총 4개의 방식으로 만들기
         * Linear
         * Relative
         * Constraint
         * 내마음대로(최적의 앱)
         * (제일 하단 첫번째 네모(다이얼로그로 물어보기) -> 꾹 누르면 두번째 사라지게, 세번째 네모 -> (다이얼로그)꾹누르면 다시 보이게)
         * (중간 동그라미 그냥 클릭 하면 토스트 메시지)
         * (상단 백버튼 누르면 화면 이동)
         * (그리고 중간위쯤 회색 네모 3개 EditText 인데 클릭하면 키보드 올라오게 딴 View 클릭하면 키보드 내려가게)
         * (제일 하단 View 에 리사이클러 View 추가 : 아이템 열 개 정도 - 클릭하면 아이템이 몇번째 포지션을 가지고있는지 토스트 띄어주기)
         * (리사이클러 뷰 헤더에는 이미지)
         */
    }
}