package com.example.gastocombustivel.entity

import com.example.gastocombustivel.databinding.ActivityViewCalculateBinding
import kotlin.concurrent.fixedRateTimer

class Validate {
    companion object {
        fun fieldOriginDetinationFilled(origin: String, destination: String): Boolean {
            return (origin != "") && (destination != "")
        }

        fun validateCalculationFields(field: ActivityViewCalculateBinding): Boolean {
            return (field.edtDistance.text.toString() != "") && (field.edtPrice.text.toString() != "") && (field.edtAutonomy.text.toString() != "" && field.edtAutonomy.text.toString()
                .toDouble() > 0.0)
        }
    }
}