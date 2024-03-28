package com.example.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.annotation.SuppressLint

class MainActivity : AppCompatActivity() {
    //var percentual:Double = 0.7
    lateinit var txtPrecoAlcool: EditText
    lateinit var txtPrecoGasolina: EditText
    lateinit var calcularBotao: Button
    lateinit var txtMsg: TextView
    var switchPercentual: Int = 70

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Log.i("PDM24.1","No onCreate, $percentual")

        percentual=0.7
        val btCalc: Button = findViewById(R.id.btCalcular)
        val textMsg:TextView= findViewById(R.id.textMsg)
        //btCalc.setBackgroundColor(Color.CYAN)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            percentual=0.75
            textMsg.text="Já tenho o percentual"
            Log.d("PDM24","No btCalcular, $percentual")
        })*/
        if (savedInstanceState != null) {
            switchPercentual=savedInstanceState.getInt("switchPercentual")
        }

        txtPrecoAlcool = findViewById(R.id.edAlcool)
        txtPrecoGasolina = findViewById(R.id.edGasolina)
        calcularBotao = findViewById(R.id.btCalcular)
        txtMsg = findViewById(R.id.textMsg)
        val switch = findViewById<Switch>(R.id.swPercentual)

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            switchPercentual = if (isChecked){
                75
            } else {
                70
            }
        }

        calcularBotao.setOnClickListener{
            val precoAlcoolText = txtPrecoAlcool.text.toString()
            val precoGasolinaText = txtPrecoGasolina.text.toString()

            if (precoAlcoolText.isNotEmpty() and precoGasolinaText.isNotEmpty()){
                val precoAlcool = precoAlcoolText.toDouble()
                val precoGasolina = precoGasolinaText.toDouble()
                val percentual = precoAlcool / precoGasolina * 100

                if (percentual <= switchPercentual){
                    txtMsg.text = "Álcool é mais vantajoso."
                }
                else {
                    txtMsg.text = "Gasolina é mais vantajoso."
                }

                Log.d("PDM24", "No calcularBotao, $percentual")
            } else { txtMsg.text = "Insira o preço do álcool e da gasolina." }
        }
    }
    override fun onResume(){
        super.onResume()
        Log.d("PDM24","No onResume") //, $percentual")
    }
    override fun onStart(){
        super.onStart()
        Log.v("PDM24","No onStart")
    }
    override fun onPause(){
        super.onPause()
        Log.e("PDM24","No onPause")
    }
    override fun onStop(){
        super.onStop()
        Log.w("PDM24","No onStop")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.wtf("PDM24","No Destroy")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("switchPercentual",switchPercentual)
        super.onSaveInstanceState(outState)
    }
}