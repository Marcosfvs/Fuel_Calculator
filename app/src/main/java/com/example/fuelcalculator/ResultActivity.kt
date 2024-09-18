package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
    const val KEY_DIST = "DistValue.KEY_DADOS"
    const val KEY_CONSUM = "ConsumeValue.KEY_DADOS"
    const val KEY_PRICE = "PriceValue.KEY_DADOS"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dadoDist= intent.getFloatExtra(KEY_DIST,0f)
        val dadoPrice = intent.getFloatExtra(KEY_PRICE, 0f)
        val dadoConsum = intent.getFloatExtra(KEY_CONSUM,0f)
        println(dadoPrice)
        println(dadoConsum)
        println(dadoDist)

        val lConsum = dadoDist / dadoConsum
        println(lConsum)
        val result =  dadoPrice * lConsum
        println(result)


        val tvResult = findViewById<TextView>(R.id.tv_result)
        tvResult.text = "$" + result.toString()
        val btReturn = findViewById<Button>(R.id.bt_Return)

        val tvPrice = findViewById<TextView>(R.id.tv_price)
        val tvConsume = findViewById<TextView>(R.id.tv_consume)
        val tvDist = findViewById<TextView>(R.id.tv_dist)

        tvPrice.text = dadoPrice.toString()
        tvConsume.text =dadoConsum.toString()
        tvDist.text =dadoDist.toString()


        btReturn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}