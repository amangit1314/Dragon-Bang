package com.aman.dragonbang

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var scoreMrBlue = 0
    private var scoreMrRed = 0
    private var healthMrBlue = 100
    private var healthMrRed = 100
    private var bangIcon: ImageView? = null
    private var redHitHead: ImageView? = null
    private var redHitAbs: ImageView? = null
    private var redHitChest: ImageView? = null
    private var blueHitHead: ImageView? = null
    private var blueHitAbs: ImageView? = null
    private var blueHitChest: ImageView? = null
    private var blueHead: ImageView? = null
    private var blueAbs: ImageView? = null
    private var blueChest: ImageView? = null
    private var redHead: ImageView? = null
    private var redAbs: ImageView? = null
    private var redChest: ImageView? = null
    private var mrRed: ImageView? = null
    private var mrBlue: ImageView? = null
    private var pulse2: Animation? = null
    private var pulse: Animation? = null
    private var animSlideFromRight: Animation? = null
    private var animSlideFromLeft: Animation? = null
    private var floatingMrBlue: Animation? = null
    private var floatingMrRed: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bangIcon = findViewById<View>(R.id.bangIcon) as ImageView
        mrRed = findViewById<View>(R.id.mrRedView) as ImageView
        mrBlue = findViewById<View>(R.id.mrBlue) as ImageView
        redHitHead = findViewById<View>(R.id.redHitHead) as ImageView
        redHitAbs = findViewById<View>(R.id.redHitAbs) as ImageView
        redHitChest = findViewById<View>(R.id.redHitChest) as ImageView
        blueHitHead = findViewById<View>(R.id.blueHitHead) as ImageView
        blueHitAbs = findViewById<View>(R.id.blueHitAbs) as ImageView
        blueHitChest = findViewById<View>(R.id.blueHitChest) as ImageView
        blueHead = findViewById<View>(R.id.blueHead) as ImageView
        blueAbs = findViewById<View>(R.id.blueabs) as ImageView
        blueChest = findViewById<View>(R.id.bluechest) as ImageView
        redHead = findViewById<View>(R.id.redHead) as ImageView
        redAbs = findViewById<View>(R.id.redabs) as ImageView
        redChest = findViewById<View>(R.id.redchest) as ImageView
        pulse = AnimationUtils.loadAnimation(this, R.anim.pulse)
        pulse2 = AnimationUtils.loadAnimation(this, R.anim.pulse2)
        animSlideFromRight = AnimationUtils.loadAnimation(this, R.anim.animationfromright)
        animSlideFromLeft = AnimationUtils.loadAnimation(this, R.anim.animationfromleft)
        floatingMrBlue = AnimationUtils.loadAnimation(this, R.anim.floatingmrblue)
        floatingMrRed = AnimationUtils.loadAnimation(this, R.anim.floatingmrred)

        //bangIcon.setAnimation(pulse);
        mrRed!!.startAnimation(floatingMrRed)
        mrBlue!!.startAnimation(floatingMrBlue)
    }

    //methods for Mr Blue
    fun displayScoreMrBlue(score: Int) {
        val scoreView = findViewById<View>(R.id.mrblue_score) as TextView
        scoreView.text = score.toString()
    }

    private fun displayHealthMrBlue(health: Int) {
        val healthView = findViewById<View>(R.id.mrblue_health) as TextView
        healthView.text = health.toString()
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    fun mrBlueHitsHead() {
        if (healthMrBlue != 0 && healthMrRed != 0) {
            blueHitHead!!.startAnimation(pulse2)
            redHead!!.visibility = View.VISIBLE
            redHead!!.animate().alpha(1.0f).setDuration(100).withEndAction { redHead!!.visibility = View.GONE }
            if (healthMrRed > 0) {
                scoreMrBlue = scoreMrBlue + 3
                healthMrRed = if (healthMrRed < 25) {
                    0
                } else {
                    healthMrRed - 25
                }
            }
            displayHealthMrRed(healthMrRed)
            displayScoreMrBlue(scoreMrBlue)
            mrBlueWins(healthMrRed)
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    fun mrBlueHitsAbs() {
        if (healthMrBlue != 0 && healthMrRed != 0) {
            blueHitAbs!!.startAnimation(pulse2)
            redAbs!!.visibility = View.VISIBLE
            redAbs!!.animate().alpha(1.0f).setDuration(100).withEndAction { redAbs!!.visibility = View.GONE }
            if (healthMrRed > 0) {
                scoreMrBlue = scoreMrBlue + 2
                healthMrRed = if (healthMrRed < 10) {
                    0
                } else {
                    healthMrRed - 10
                }
            }
            displayHealthMrRed(healthMrRed)
            displayScoreMrBlue(scoreMrBlue)
            mrBlueWins(healthMrRed)
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    fun mrBlueHitsChests(view: View?) {
        if (healthMrBlue != 0 && healthMrRed != 0) {
            blueHitChest!!.startAnimation(pulse2)
            redChest!!.visibility = View.VISIBLE
            redChest!!.animate().alpha(1.0f).setDuration(100).withEndAction { redChest!!.visibility = View.GONE }
            if (healthMrRed > 0) {
                scoreMrBlue = scoreMrBlue + 1
                healthMrRed = if (healthMrRed < 3) {
                    0
                } else {
                    healthMrRed - 3
                }
                displayScoreMrBlue(scoreMrBlue)
                displayHealthMrRed(healthMrRed)
                mrBlueWins(healthMrRed)
            }
        }
    }

    //methods for Mr Red
    fun displayScoreMrRed(score: Int) {
        val scoreView = findViewById<View>(R.id.mrred_score) as TextView
        scoreView.text = score.toString()
    }

    fun displayHealthMrRed(health: Int) {
        val healthView = findViewById<View>(R.id.mrred_health) as TextView
        healthView.text = health.toString()
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    fun mrRedHitsHead(view: View?) {
        if (healthMrBlue != 0 && healthMrRed != 0) {
            redHitHead!!.startAnimation(pulse2)
            blueHead!!.visibility = View.VISIBLE
            blueHead!!.animate().alpha(1.0f).setDuration(100).withEndAction { blueHead!!.visibility = View.GONE }
            if (healthMrBlue > 0) {
                scoreMrRed = scoreMrRed + 3
                healthMrBlue = if (healthMrBlue < 20) {
                    0
                } else {
                    healthMrBlue - 20
                }
            }
            displayHealthMrBlue(healthMrBlue)
            displayScoreMrRed(scoreMrRed)
            mrRedWins(healthMrBlue)
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    fun mrRedHitsAbs(view: View?) {
        if (healthMrBlue != 0 && healthMrRed != 0) {
            redHitAbs!!.startAnimation(pulse2)
            blueAbs!!.visibility = View.VISIBLE
            blueAbs!!.animate().alpha(1.0f).setDuration(100).withEndAction { blueAbs!!.visibility = View.GONE }
            if (healthMrBlue > 0) {
                scoreMrRed = scoreMrRed + 2
                healthMrBlue = if (healthMrBlue < 15) {
                    0
                } else {
                    healthMrBlue - 15
                }
            }
            displayScoreMrRed(scoreMrRed)
            displayHealthMrBlue(healthMrBlue)
            mrRedWins(healthMrBlue)
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    fun mrRedHitsChest(view: View?) {
        if (healthMrBlue != 0 && healthMrRed != 0) {
            redHitChest!!.startAnimation(pulse2)
            blueChest!!.visibility = View.VISIBLE
            blueChest!!.animate().alpha(1.0f).setDuration(100).withEndAction { blueChest!!.visibility = View.GONE }
            scoreMrRed = scoreMrRed + 1
            healthMrBlue = if (healthMrBlue < 5) {
                0
            } else {
                healthMrBlue - 5
            }
            displayScoreMrRed(scoreMrRed)
            displayHealthMrBlue(healthMrBlue)
            this.mrRedWins(this.healthMrBlue)
        }
    }

    fun reSet(v: View?) {
        mrBlue!!.setImageResource(R.drawable.freeza)
        mrRed!!.setImageResource(R.drawable.goku)
        scoreMrBlue = 0
        displayScoreMrBlue(scoreMrBlue)
        scoreMrRed = 0
        displayScoreMrRed(scoreMrRed)
        healthMrBlue = 100
        displayHealthMrBlue(healthMrBlue)
        healthMrRed = 100
        displayHealthMrRed(healthMrRed)
    }

    fun mrBlueWins(healthMrRed: Int) {
        if (healthMrRed <= 0) {
            mrRed!!.setImageResource(R.drawable.goku_hurt)
            val toast = Toast.makeText(this, "OMG! KO! Frieza won! Rematch?", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0, -400)
            toast.show()
        }
    }

    fun mrRedWins(healthMrBlue: Int) {
        if (healthMrBlue <= 0) {
            mrBlue!!.setImageResource(R.drawable.frieza_hurt)
            val toast = Toast.makeText(this, "OMG! KO! Goku won! Rematch?", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0, -400)
            toast.show()
        }
    }
}