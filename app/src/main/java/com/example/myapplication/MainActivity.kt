package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var isDeer = false
        var isDog = false
        var isCat = false

        var imageView = binding.animalImage
        var deerUrl =
            "https://media.npr.org/assets/img/2021/11/10/white-tailed-deer-1-ac07593f0b38e66ffac9178fb0c787ca75baea3d-s1100-c50.jpg"
        var dogUrl =
            "https://kb.rspca.org.au/wp-content/uploads/2018/11/golder-retriever-puppy.jpeg"
        var catUrl =
            "https://www.wfla.com/wp-content/uploads/sites/71/2023/05/GettyImages-1389862392.jpg?w=2560&h=1440&crop=1"



        val imageUrl = arrayOf(
            catUrl, deerUrl, dogUrl
        )


        var randomIndex = (imageUrl.indices).random()
        var randomImageUrl = imageUrl[randomIndex]
        

        Picasso.get().load(randomImageUrl).into(imageView)





        binding.deerBt.setOnClickListener {
            Glide.with(this).load(deerUrl)
                .centerCrop()
                .into(imageView)

            isDeer = true
            isDog = false
            isCat = false

        }

        binding.dogBt.setOnClickListener {
            Glide.with(this).load(dogUrl)
                .centerCrop()
                .into(imageView)
            isDeer = false
            isDog = true
            isCat = false

        }

        binding.catBt.setOnClickListener {
            Glide.with(this).load(catUrl)
                .centerCrop()
                .into(imageView)
            isDeer = false
            isDog = false
            isCat = true

        }

        binding.deerAnswerBtn.setOnClickListener {
            if (isDeer) {
                Toast.makeText(this, "молодец", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "подумай дурак", Toast.LENGTH_SHORT).show()
            }
        }

        binding.dogAnswerBtn.setOnClickListener {
            if (isDog) {
                Toast.makeText(this, "молодец", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "подумай дурак", Toast.LENGTH_SHORT).show()
            }
        }

        binding.catAnswerBtn.setOnClickListener {
            if (isCat) {
                Toast.makeText(this, "молодец", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "подумай дурак", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

// ДЗ
// 1.Добавить кнопку которая ставит случайную картинку.
// 2.При запуске приложения установить случайную картинку
// 3.Все должно также корректно работать по кнопкам ответа
// Дэдлайн 17 го 23 59

// Доп дз
// Придумать другую логику работы приложения
