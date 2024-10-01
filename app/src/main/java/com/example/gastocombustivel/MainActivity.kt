package com.example.gastocombustivel

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gastocombustivel.databinding.ActivityMainBinding
import com.example.gastocombustivel.entity.Validate

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNext.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_next) {
            if (Validate.fieldOriginDetinationFilled(
                    binding.textOrigin.text.toString(),
                    binding.textDetination.text.toString()
                )
            ) {
                val intent: Intent = Intent(this, ViewCalculate::class.java)
                intent.putExtra("origin", binding.textOrigin.text.toString())
                intent.putExtra("destination", binding.textDetination.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencha todos os dados!", Toast.LENGTH_LONG).show()
            }
        }
    }

}