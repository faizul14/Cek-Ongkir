package com.example.cekongkir.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.cekongkir.R
import com.example.cekongkir.databinding.ActivityHomeCoactivityBinding
import com.example.cekongkir.helper.ViewModelFactory
import com.example.cekongkir.viewmodel.HomeCOViewModel
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar

class HomeCOActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityHomeCoactivityBinding
    private var berat = 0
    private lateinit var btn : Button
    private lateinit var bntMinus : ImageButton
    private lateinit var btnPlus : ImageButton
    private lateinit var edtBerat : EditText
    private lateinit var viewModel : HomeCOViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeCoactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelFactory(this))[HomeCOViewModel::class.java]

        btn = findViewById(R.id.btn_cek)
        bntMinus = findViewById(R.id.minus)
        btnPlus = findViewById(R.id.plus)
        edtBerat = findViewById(R.id.edt_berat)
        btn.setOnClickListener(this)
        bntMinus.setOnClickListener(this)
        btnPlus.setOnClickListener(this)

        viewModel.berat.observe(this, {data->
            edtBerat.setText(data.toString())
        })




    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_cek -> {
//               val snackbar = Snackbar.make(this, "Ini snackbar", LENGTH_SHORT)
//                Toast.makeText(this, "btn doen", Toast.LENGTH_SHORT).show()
            }
            R.id.minus -> {
                val data = edtBerat.text.toString().trim()
                viewModel.setBerat(data, isMinus)
            }
            R.id.plus -> {
                val data = edtBerat.text.toString().trim()
                viewModel.setBerat(data, isPlus)
            }

        }
    }

    companion object{
        const val isPlus = "isPlus"
        const val isMinus = "isMinus"
    }

}