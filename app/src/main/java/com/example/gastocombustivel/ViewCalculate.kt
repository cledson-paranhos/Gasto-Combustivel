package com.example.gastocombustivel

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gastocombustivel.databinding.ActivityMainBinding
import com.example.gastocombustivel.databinding.ActivityViewCalculateBinding
import com.example.gastocombustivel.entity.Validate
import kotlin.text.toDouble
import kotlin.toString

class ViewCalculate : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityViewCalculateBinding
    var valueTotalCalculate = 0.0
    var distance = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewCalculateBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttonCalculate) {
            calculate()

            var dadosRecuperados = intent.extras

            var origin = dadosRecuperados?.getString("origin")
            var destination = dadosRecuperados?.getString("destination")

            if (binding.checkboxCalcTotal.isChecked){
                distance = binding.edtDistance.text.toString().toDouble() * 2.0
            }else{
                distance = binding.edtDistance.text.toString().toDouble()
            }

            var intent = Intent(this, ViewResult::class.java)

            intent.putExtra("distance", distance)
            intent.putExtra("price", binding.edtPrice.text.toString().toDouble())
            intent.putExtra("autonomy", binding.edtAutonomy.text.toString().toDouble())
            intent.putExtra("origin", origin)
            intent.putExtra("destination", destination)
            intent.putExtra("total", this.valueTotalCalculate)

            startActivity(intent)
        }
    }

    fun calculate() {
        if (Validate.validateCalculationFields(binding)) {
            var distance = binding.edtDistance.text.toString().toDouble()
            var price = binding.edtPrice.text.toString().toDouble()
            var autonomy = binding.edtAutonomy.text.toString().toDouble()

            if (binding.checkboxCalcTotal.isChecked) {
                this.valueTotalCalculate = ((distance * price) / autonomy) * 2.0
            } else {
                this.valueTotalCalculate = (distance * price) / autonomy
            }
        } else {
            Toast.makeText(this, "Valores inseridos inválidos!", Toast.LENGTH_SHORT).show()
        }
    }
}

