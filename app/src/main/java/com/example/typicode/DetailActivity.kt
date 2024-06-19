package com.example.typicode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.activity.viewModels
import com.example.typicode.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val url = intent.getStringExtra("url")
        val title = intent.getStringExtra("title")
        val id = intent.getStringExtra("id")

        binding.photoTitle.text = title
        binding.photoDescription.text = url
        Picasso.get().load(url).into(binding.photoImage)

        binding.back.setOnClickListener {
            /*val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)*/
            super.onBackPressed()
        }



    }





}