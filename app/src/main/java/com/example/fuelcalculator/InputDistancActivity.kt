package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_CONSUM = "ConsumeValue.KEY_DADOS"
const val KEY_PRICE = "PriceValue.KEY_DADOS"

class InputDistancActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input_distanc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dadoPrice = intent.getFloatExtra(KEY_PRICE, 0f)
        val dadoConsum = intent.getFloatExtra(KEY_CONSUM,0f)
        println(dadoPrice)
        println(dadoConsum)

        val edtDist = findViewById<TextInputEditText>(R.id.edt_dist)

        val btResult = findViewById<Button>(R.id.bt_Result)

        btResult.setOnClickListener {
            val edtDistStr: String = edtDist.text.toString()

            if (edtDistStr == "") {
                Snackbar
                    .make(
                        edtDist,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {
                val dadoDist: Float = edtDistStr.toFloat()

                val lConsum = dadoDist / dadoConsum
                println(lConsum)
                val priceGaso =  dadoPrice * lConsum
                println(priceGaso)

                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra(KEY_RESULT,priceGaso)
                startActivity(intent)
            }

        }
    }
}