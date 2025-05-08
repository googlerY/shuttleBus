package com.example.shuttlebus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.shuttlebus.databinding.ActivityMainBinding
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        title = "School Shuttle Driver"



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
//            val fragmentManager:FragmentManager = supportFragmentManager
//            val transaction:FragmentTransaction = fragmentManager.beginTransaction()
            when (item.itemId) {
                R.id.menu_first-> {
                    // 홈 화면으로 전환
                    setTitle("School Shuttle Driver")
                    val fragment = MainFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_second -> {
                    setTitle("운행 경로")
                    val fragment = PathFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view,fragment).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_third -> {
                    setTitle("운행 기록")
                    val fragment = HistoryFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view,fragment).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_fourth -> {
                    setTitle("탑승자 관리")
                    val fragment = ManageBoardingFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view,fragment).commit()
                    return@setOnItemSelectedListener true
                }
                else -> {return@setOnItemSelectedListener true}
            }

        }
    }
}