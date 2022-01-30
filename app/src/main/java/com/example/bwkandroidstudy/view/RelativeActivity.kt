package com.example.bwkandroidstudy.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ConcatAdapter
import com.example.bwkandroidstudy.R
import com.example.bwkandroidstudy.adpater.CustomAdapter
import com.example.bwkandroidstudy.adpater.HeaderAdapter
import com.example.bwkandroidstudy.data.CustomRecyclerItem
import com.example.bwkandroidstudy.databinding.ActivityRelativeBinding

class RelativeActivity : AppCompatActivity() {
    lateinit var binding : ActivityRelativeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRelativeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        apply {
            binding.circleImageText1.text = getString(R.string.text_first_msg)
            binding.circleImageText2.text = getString(R.string.text_second_msg)
            binding.circleImageText3.text = getString(R.string.text_third_msg)
            binding.circleImageText4.text = getString(R.string.text_four_msg)

            val adapter = ConcatAdapter(HeaderAdapter(), CustomAdapter(setDataList()))
            //binding.recycler.adapter = adapter
            binding.recycler.adapter = adapter

            binding.edit1.setOnFocusChangeListener { v, hasFocus ->
                if(!hasFocus) hideKeyboard(v)
            }
            binding.edit2.setOnFocusChangeListener { v, hasFocus ->
                if(!hasFocus) hideKeyboard(v)
            }
            binding.edit3.setOnFocusChangeListener { v, hasFocus ->
                if(!hasFocus) hideKeyboard(v)
            }

            setOnClick()
        }
    }

    private fun hideKeyboard(view: View){
        val inputService = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputService.hideSoftInputFromWindow(view.windowToken, 0)
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

    private fun setDataList(): MutableList<CustomRecyclerItem>{
        val mutableList = mutableListOf<CustomRecyclerItem>()
        mutableList.add(
            CustomRecyclerItem(
                "https://w.namu.la/s/48a178fbd427b8dddc275cf878725e03d8499105f13e57c7ff889ef1cba3895d813b88696242cebb4f56d28ae2c93fbdef1f61731db76fc27f9070a8fceef4652016fbd8c0a144273d70a69c7dfff6d9",
                "구글 이미지입니다",
                0
            )
        )
        mutableList.add(
            CustomRecyclerItem(
                "https://t1.daumcdn.net/cfile/tistory/24283C3858F778CA2E",
                "강아지 이미지 입니",
                1
            )
        )
        mutableList.add(
            CustomRecyclerItem(
                "http://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg",
                "라이언 이미지입니다",
                1
            )
        )
        mutableList.add(
            CustomRecyclerItem(
                "https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg",
                "오렌지 이미지입니다",
                1
            )
        )
        mutableList.add(
            CustomRecyclerItem(
                "https://www.codingfactory.net/wp-content/uploads/abc.jpg",
                "꽃 이미지입니다",
                1
            )
        )
        mutableList.add(
            CustomRecyclerItem(
                "https://www.urbanbrush.net/web/wp-content/uploads/edd/2020/02/urbanbrush-20200227023608426223.jpg",
                "달걀 이미지입니",
                1
            )
        )

        return mutableList
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