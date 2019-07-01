package com.app.nikhil.coroutinesessentials.utils

import android.animation.ValueAnimator
import androidx.appcompat.widget.AppCompatImageView

fun AppCompatImageView.animateFadeIn() {
  val animator = ValueAnimator.ofFloat(0F, 1F)
  animator.apply {
    duration = 2000
    addUpdateListener {
      this@animateFadeIn.alpha = it.animatedValue as Float
    }
  }
  animator.start()
}