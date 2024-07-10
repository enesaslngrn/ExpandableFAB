package com.example.expandablefab

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.expandablefab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val rotateOpen : Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.rotate_open_anim) }
    private val rotateClose : Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.rotate_close_anim) }
    private val fromBottom : Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.from_bottom_anim) }
    private val toBottom : Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.to_bottom_anim) }
    private var isClicked = false
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener {
            onAddButtonClicked()
        }

        binding.fabFavorite.setOnClickListener {
            Toast.makeText(this,"Favorite Clicked",Toast.LENGTH_SHORT).show()
        }
    }
    private fun onAddButtonClicked(){
        setVisibility(isClicked)
        setAnimation(isClicked)
        setClickable(isClicked)
        isClicked = !isClicked
    }

    private fun setVisibility(isClicked : Boolean) {
        if (!isClicked){
            binding.fabFavorite.visibility = View.VISIBLE
            binding.fabCamera.visibility = View.VISIBLE
            binding.fabVideo.visibility = View.VISIBLE
        }else{
            binding.fabFavorite.visibility = View.INVISIBLE
            binding.fabCamera.visibility = View.INVISIBLE
            binding.fabVideo.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(isClicked : Boolean) {
        if (!isClicked){
            binding.fabAdd.startAnimation(rotateOpen)
            binding.fabFavorite.startAnimation(fromBottom)
            binding.fabCamera.startAnimation(fromBottom)
            binding.fabVideo.startAnimation(fromBottom)
        }else{
            binding.fabAdd.startAnimation(rotateClose)
            binding.fabFavorite.startAnimation(toBottom)
            binding.fabCamera.startAnimation(toBottom)
            binding.fabVideo.startAnimation(toBottom)
        }
    }

    private fun setClickable(isClicked: Boolean){
        if (!isClicked){
            binding.fabFavorite.isClickable = true
            binding.fabCamera.isClickable = true
            binding.fabVideo.isClickable = true
        }else{
            binding.fabFavorite.isClickable = false
            binding.fabCamera.isClickable = false
            binding.fabVideo.isClickable = false
        }
    }

}