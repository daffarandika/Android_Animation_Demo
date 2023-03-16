package com.example.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation.AnimationListener

class CrossFadeActivity : Activity() {
    private lateinit var cView: View
    private lateinit var loadingView: View
    private var shortAnimationDuration: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cross_fade)
        cView = findViewById(R.id.content)
        loadingView = findViewById(R.id.loading_spinner)

        cView.visibility = View.GONE

        shortAnimationDuration = resources.getInteger(android.R.integer.config_longAnimTime)

        crossFade()
    }

    private fun crossFade() {
        cView.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(null)
        }
        loadingView.animate()
            .alpha(0f)
            .setDuration(shortAnimationDuration.toLong())
            .setListener(object: AnimatorListenerAdapter(){
                override fun onAnimationEnd(animation: Animator) {
                    loadingView.visibility = View.GONE
                }
            })
    }
}