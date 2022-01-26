package com.example.bwkandroidstudy.view

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.bwkandroidstudy.R
import com.example.bwkandroidstudy.databinding.TestLayoutLinearLayoutVersionBinding

class LinearActivity : AppCompatActivity() {
    private lateinit var binding: TestLayoutLinearLayoutVersionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TestLayoutLinearLayoutVersionBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val height = getPhoneHeight()

        binding.mainLayout.layoutParams = LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        apply {
            binding.circleImageText1.text = getString(R.string.text_first_msg)
            binding.circleImageText2.text = getString(R.string.text_second_msg)
            binding.circleImageText3.text = getString(R.string.text_third_msg)
            binding.circleImageText4.text = getString(R.string.text_four_msg)

            

            setOnClick()
        }

    }

    private fun setOnClick() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.bottomImage1.setOnLongClickListener {
            AlertDialog.Builder(this)
                .setTitle(R.string.dialog_hide_title)
                .setMessage(R.string.dialog_hide_message)
                .setPositiveButton(R.string.dialog_positive) { _, _ ->
                    binding.bottomImage2.visibility = View.GONE
                }
                .setNegativeButton(R.string.dialog_negative) { _, _ ->
                }
                .create()
                .show()
            true
        }

        binding.bottomImage3.setOnLongClickListener {
            AlertDialog.Builder(this)
                .setTitle(R.string.dialog_show_title)
                .setMessage(R.string.dialog_show_message)
                .setPositiveButton(R.string.dialog_positive) { _, _ ->
                    binding.bottomImage2.visibility = View.VISIBLE
                }
                .setNegativeButton(R.string.dialog_negative) { _, _ ->
                }
                .create()
                .show()
            true
        }

        binding.circleImage1.setOnClickListener { showToast(1) }
        binding.circleImage2.setOnClickListener { showToast(2) }
        binding.circleImage3.setOnClickListener { showToast(3) }
        binding.circleImage4.setOnClickListener { showToast(4) }
    }

    private fun showToast(num: Int) {
        Toast.makeText(this, "$num 번째 이미지", Toast.LENGTH_SHORT).show()
    }

    private fun getPhoneHeight(): Int {
        val height: Int

        if (Build.VERSION.SDK_INT >= 30) {
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

        return height
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