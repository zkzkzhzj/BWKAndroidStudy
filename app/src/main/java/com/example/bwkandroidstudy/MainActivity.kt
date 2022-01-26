package com.example.bwkandroidstudy

import android.graphics.Typeface
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
 * src 와 background 의 차이이
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

class MainActivity : AppCompatActivity() {
    private lateinit var binding : TestLayoutLinearLayoutVersionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TestLayoutLinearLayoutVersionBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val height: Int

        if (Build.VERSION.SDK_INT >= 30){
            val metrics = windowManager.currentWindowMetrics
            val windowInsets = metrics.windowInsets

            val insets = windowInsets.getInsetsIgnoringVisibility(
                WindowInsets.Type.navigationBars()
                        or WindowInsets.Type.displayCutout()
            )

            val insetsHeight = insets.top + insets.bottom
            val bounds = metrics.bounds

            height = bounds.height() - insetsHeight

            Log.e("############", "api 30 이상")
        } else {
            height = resources.displayMetrics.heightPixels

            Log.e("############", "api 30 미만")
        }

        binding.mainLayout.layoutParams = LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    /*
     * 메뉴 세팅
     * 초기화 한번만 호출됨
     *  - 메뉴 목록 변경시 onPrepareOptionsMenu() 메소드 참
     * 메뉴를 보이려면 true, 안보이려면 false 리턴
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }
}