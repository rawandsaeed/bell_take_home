package com.eos_gnss.bellapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eos_gnss.bellapp.R
import com.eos_gnss.bellapp.base.BaseActivity
import com.eos_gnss.bellapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val binding: ActivityMainBinding
        get() = ActivityMainBinding.inflate(layoutInflater)

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragment()
    }

    private fun initFragment() {
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .commit()
    }



}