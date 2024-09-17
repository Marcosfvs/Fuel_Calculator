package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class InputConsumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input_consum)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtConsum = findViewById<TextInputEditText>(R.id.edt_consum)

        val btNextD = findViewById<Button>(R.id.bt_Next_D)

        btNextD.setOnClickListener {
            val edtConsumStr: String = edtConsum.text.toString()

            if (edtConsumStr == "") {
                Snackbar
                    .make(
                        edtConsum,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {
                val numConsum: Float = edtConsumStr.toFloat()
                val intent = Intent(this,InputDistancActivity::class.java)
                intent.putExtra(KEY_CONSUM,numConsum)
                startActivity(intent)
            }
        }
    }
}