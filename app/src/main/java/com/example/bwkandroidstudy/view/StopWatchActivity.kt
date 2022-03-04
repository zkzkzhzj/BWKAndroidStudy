package com.example.bwkandroidstudy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import com.example.bwkandroidstudy.databinding.ActivityStopWatchBinding
import java.util.prefs.Preferences

class StopWatchActivity : AppCompatActivity() {
    lateinit var binding : ActivityStopWatchBinding

    // 뒤로가기 버튼을 누른 시각 저장
    var initTime = 0L
    // 멈춘 시각을 저장하는 속성
    var pauseTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStopWatchBinding.inflate(layoutInflater)

        Log.e("MainActivity", "왔슘당")
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            Log.e("켜지고 나서 흐른 시간", SystemClock.elapsedRealtime().toString() + "ㅎㅎ")
            Log.e("stop 을 누르고 저장된 시간", pauseTime.toString() + "ㅎㅎ")
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()
            // 버튼 표시 여부 조정
            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = false
        }

        binding.stopButton.setOnClickListener {
            Log.e("켜지고 나서 흐른 시간", SystemClock.elapsedRealtime().toString() + "ㅎㅎ")
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            Log.e("stop 을 누르고 저장된 시간", pauseTime.toString() + "ㅎㅎ")
            binding.chronometer.stop()
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = true
        }

        binding.resetButton.setOnClickListener {
            pauseTime = 0L
            Log.e("켜지고 나서 흐른 시간", SystemClock.elapsedRealtime().toString() + "ㅎㅎ")
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = false
            binding.startButton.isEnabled = true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // 뒤로가기 버튼을 눌렀을 때 처리
        if(keyCode == KeyEvent.KEYCODE_BACK){
            // 뒤로가기 버튼을 처음 눌렀거나 누른지가 3초가 지났을 때 처리
            if(System.currentTimeMillis() - initTime > 3000){
                Toast.makeText(this, "종료하려면 한 번 더 누르세요!!",
                Toast.LENGTH_SHORT).show()

                initTime = System.currentTimeMillis()
                return true
            }
        }

        return super.onKeyDown(keyCode, event)
    }
}