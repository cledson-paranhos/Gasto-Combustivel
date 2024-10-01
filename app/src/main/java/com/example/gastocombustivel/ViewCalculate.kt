package com.example.gastocombustivel

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttonCalculate) {
            calculate()
        }
    }

    fun calculate() {
        if (Validate.validateCalculationFields(binding)) {
            var distance = binding.edtDistance.text.toString().toDouble()
            var price = binding.edtPrice.text.toString().toDouble()
            var autonomy = binding.edtAutonomy.text.toString().toDouble()

            this.valueTotalCalculate = (distance * price) / autonomy
        } else {
            Toast.makeText(this, "Valores inseridos inválidos!", Toast.LENGTH_SHORT).show()
        }
    }
}

