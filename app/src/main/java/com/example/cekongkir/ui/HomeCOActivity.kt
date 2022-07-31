package com.example.cekongkir.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.example.cekongkir.MainActivity
import com.example.cekongkir.R
import com.example.cekongkir.databinding.ActivityHomeCoactivityBinding
import com.example.cekongkir.helper.ViewModelFactory
import com.example.cekongkir.viewmodel.HomeCOViewModel
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar
import com.maxkeppeler.sheets.core.SheetStyle
import com.maxkeppeler.sheets.input.InputSheet
import com.maxkeppeler.sheets.input.type.InputRadioButtons

class HomeCOActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityHomeCoactivityBinding
    private var berat = 0
    private lateinit var btn : Button
    private lateinit var bntMinus : ImageButton
    private lateinit var btnPlus : ImageButton
    private lateinit var edtBerat : EditText
    private lateinit var txtAsal : TextView
    private lateinit var txtTujuan : TextView
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
        txtAsal = findViewById(R.id.textView)
        txtTujuan = findViewById(R.id.textView2)
        btn.setOnClickListener(this)
        bntMinus.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        txtAsal.setOnClickListener(this)

        viewModel.berat.observe(this, {data->
            edtBerat.setText(data.toString())
        })




    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_cek -> {
//               val snackbar = Snackbar.make(this, "Ini snackbar", LENGTH_SHORT)
//                Toast.makeText(this, "btn doen", Toast.LENGTH_SHORT).show()
                showChoseService()
            }
            R.id.minus -> {
                val data = edtBerat.text.toString().trim()
                viewModel.setBerat(data, isMinus)
            }
            R.id.plus -> {
                val data = edtBerat.text.toString().trim()
                viewModel.setBerat(data, isPlus)
            }
            R.id.textView->{
                val move = Intent(this, MainActivity::class.java)
                startActivity(move)
            }

        }
    }

    private fun showChoseService(){
        InputSheet().show(this){
            title("Jasa pengiriman")
            with(InputRadioButtons(){
                required()
                label("Pilih jasa pengiriman")
                options(
                    mutableListOf("JNE","POS INDONESIA", "TIKI")
                )
                resultListener { result ->
                    when(result){
                        0 ->{
                            Toast.makeText(this@HomeCOActivity, "JNE", Toast.LENGTH_SHORT).show()
                        }
                        1 ->{
                            Toast.makeText(this@HomeCOActivity, "POS INDONESIA", Toast.LENGTH_SHORT).show()
                        }
                        2 ->{
                            Toast.makeText(this@HomeCOActivity, "TIKI", Toast.LENGTH_SHORT).show()
                        }

                    }
                }
            })
            onNegative {
                Toast.makeText(this@HomeCOActivity, "Chose canceled.", Toast.LENGTH_SHORT).show()
            }
            onPositive {

            }
        }
    }

    companion object{
        const val isPlus = "isPlus"
        const val isMinus = "isMinus"
    }

}