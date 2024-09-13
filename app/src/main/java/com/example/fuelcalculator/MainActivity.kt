package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fuelcalculator.ui.theme.FuelCalculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btStart = findViewById<Button>(R.id.bt_start)

        btStart.setOnClickListener {
            val intent = Intent(this,InputPriceActivity::class.java)
            startActivity(intent)
        }
    }
}

/* -Criar 5 páginas para o aplicativo
     -Input Consumo do Carro
        -Image
        -Text
        -Text
        -input
        -Button
      -Distancia até o destino
        -Image
        -Text
        -Text
        -input
        -Button
   -Criar 1 páginas para resultado
        - caixa branca com texto do resultado
        -tela azul
            - com os dados dos inputs
            -button
   -Criar lógica para o calculo
*/