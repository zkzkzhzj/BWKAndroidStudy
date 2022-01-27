package com.example.bwkandroidstudy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.bwkandroidstudy.R
import com.example.bwkandroidstudy.databinding.ActivityConstraintBinding

class ConstraintActivity : AppCompatActivity() {
    private lateinit var binding : ActivityConstraintBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConstraintBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        setOnClick()
    }

    private fun setOnClick(){
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
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