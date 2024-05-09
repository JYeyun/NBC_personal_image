package com.example.nbc_personal_image

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.nbc_personal_image.databinding.ActivityMainBinding
import com.example.nbc_personal_image.viewmodel.MainViewModel
import com.example.nbc_personal_image.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_view, SearchFragment())
            .commit()
        binding.btnSaveImage.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_view, SaveImageFragment())
                .commit()
        }
        binding.btnSearchPage.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_view, SearchFragment())
                .commit()
        }
    }
}