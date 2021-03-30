package com.example.appfilmes.ui.Popular_movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfilmes.R
import com.example.appfilmes.ui.Single_movie_details.SingleMovie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_movie)

        btn.setOnClickListener{
            val intent = Intent(this,SingleMovie::class.java)
            intent.putExtra("id", 299534)
            this.startActivity(intent)
        }
    }
}