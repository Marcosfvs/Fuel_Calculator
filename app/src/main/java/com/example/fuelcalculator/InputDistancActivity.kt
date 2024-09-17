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
                //pegar as informações das outras activity

                val lConsum = edtDist / edtConsum
                val priceGaso = lConsum * edtPrice

                val intent = Intent(this,ResultActivity::class.java)
                startActivity(intent)
            }

        }
    }
}