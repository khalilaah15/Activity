package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val inputLength: String = edtLength.getText().toString().trim()
        val inputWidth: String = edtWidth.getText().toString().trim()
        val inputHeight: String = edtHeight.getText().toString().trim()
            var isEmptyField: Boolean = false
            var isInvalidDouble: Boolean = false
            if(TextUtils.isEmpty(inputLength)) {
                isEmptyField = true
                edtLength.setError("Field ini tidak boleh kosong")
            } else if(TextUtils.isEmpty(inputWidth)){
                isEmptyField = true
                edtWidth.setError("Field ini tidak boleh kosong")
            } else if(TextUtils.isEmpty(inputHeight)){
                isEmptyField = true
                edtHeight.setError("Field ini tidak boleh kosong")
            }

        val length: Double = toDouble(inputLength)!!
        val width: Double = toDouble(inputWidth)!!
        val height: Double = toDouble(inputHeight)!!

        if(height == 0.0){
            isInvalidDouble = true
            edtHeight.setError("Field ini harus berupa angka")
        } else if(width == 0.0){
            isInvalidDouble = true
            edtWidth.setError("Field ini harus berupa angka")
        } else if(length == 0.0){
            isInvalidDouble = true
            edtLength.setError("Field ini harus berupa angka")
        }

        //hitung
        if(!isEmptyField && !isInvalidDouble) {
            var volume: Double = length * width * height
            tvResult.setText(volume.toString())
        }
    }

    private fun toDouble(str: String): Double? {
        return try{
            str.toDouble()
        } catch (e: NumberFormatException){
            var nothing = 0.0
            nothing
        }
    }


}