package com.example.ttmanager2.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ttmanager2.retrofit.ApiService
import com.example.ttmanager2.R
import com.example.ttmanager2.databinding.ActivityLoginBinding
import com.example.ttmanager2.model.UserDataResponse
import com.example.ttmanager2.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var retrofit: RetrofitClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        retrofit = RetrofitClient()
        initUI()
    }

    private fun initUI() {
        initBtnLogin()
        initBtnRegister()
    }

    private fun initBtnRegister() {
        binding.btnRegister.setOnClickListener {
            navigateToRegisterActivity()
        }
    }

    private fun initBtnLogin() {
        binding.btnLogin.setOnClickListener {
            val userName: String = binding.etLoginName.getText().toString()
            val pwd: String = binding.etLoginPass.getText().toString()
            if (userName == "" || pwd == "") {
                showMessage("Please, fill the formulary with your credentials")
            } else {
                callRetrofit(userName, pwd)
            }
        }
    }

    private fun callRetrofit(userName: String, pwd: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<UserDataResponse> =
                retrofit.apiCall.getUserID(userName, pwd)
            if (myResponse.isSuccessful) {
                val response: UserDataResponse? = myResponse.body()
                if (response!!.response == "100") {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        navigateToMainActivity(response.user[0].id)
                    }
                } else {
                    runOnUiThread {
                        showMessage("Wrong User / Password, please try again")
                    }

                }
            }
        }

    }

    private fun navigateToMainActivity(id: Int) {
        val idString = id.toString()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("idString",idString)
        startActivity(intent)
    }

    private fun navigateToRegisterActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}

