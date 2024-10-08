package com.example.gastocombustivel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gastocombustivel.databinding.ActivityViewResultBinding
import java.text.Format

class ViewResult : AppCompatActivity() {
    lateinit var binding: ActivityViewResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewResultBinding.inflate(layoutInflater)

        var resultDados = intent.extras
        var total = resultDados?.getDouble("total")
        binding.textResultOrigem.text = resultDados?.getString("origin")
        binding.textResultDestino.text = resultDados?.getString("destination")
        binding.textResulDistance.text= resultDados?.getDouble("distance").toString()
        binding.textResult.text = "R$: %.2f".format(total).toString()

        setContentView(binding.root)
    }
}