package com.example.bwkandroidstudy

import android.content.Intent
import android.graphics.Typeface
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Size
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.bwkandroidstudy.databinding.TestLayoutLinearLayoutVersionBinding
import android.view.WindowInsets
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.bwkandroidstudy.databinding.ActivityMainBinding
import com.example.bwkandroidstudy.view.ConstraintActivity
import com.example.bwkandroidstudy.view.LinearActivity
import com.example.bwkandroidstudy.view.RelativeActivity


/*
 * dpi
 * dip
 * dp
 * sp
 * px
 * 나인패치? 점선?
 * res 내부 -> raw, navigation 등
 * layoutInflater?
 * 모듈 apk 로 뽑으면 무슨일이?
 * src 와 background 의 차이
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
 *
 *
 * dpi, dip, dp, sp, px, 나인패치
 * 해상도별 대응을 어떻게 할 것인가
 * adjustViewBounds 비율 맞추기
 * android resource 의 종류
 * layout 배치
 * 다중 모듈, enum class 사용법
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.linearBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, LinearActivity::class.java))
        }

        binding.constraintBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConstraintActivity::class.java))
        }

        binding.relativeBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, RelativeActivity::class.java))
        }
    }
}