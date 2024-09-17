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

class InputPriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input_price)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPrice = findViewById<TextInputEditText>(R.id.edt_price)


        val btNextPC = findViewById<Button>(R.id.bt_Next_PC)

        btNextPC.setOnClickListener {
            val edtPriceStr: String = edtPrice.text.toString()

            if (edtPriceStr == "") {
                Snackbar
                    .make(
                        edtPrice,
                        "Preencha todos os campos!",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {
                val numPrice:Float =edtPriceStr.toFloat()
                println(numPrice)
                val intent = Intent(this, InputConsumActivity::class.java)
                intent.putExtra(KEY_PRICE,numPrice)
                startActivity(intent)

            }
        }
    }
}