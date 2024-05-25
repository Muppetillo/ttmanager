package com.example.ttmanager2.view

import android.content.Intent
import android.os.Bundle
import android.text.LoginFilter.UsernameFilterGMail
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ttmanager2.R
import com.example.ttmanager2.databinding.ActivityLoginBinding
import com.example.ttmanager2.databinding.ActivityRegisterBinding
import com.example.ttmanager2.model.UserDataResponse
import com.example.ttmanager2.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var retrofit: RetrofitClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
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
        binding.btnLogin.setOnClickListener {
            val userName: String = binding.etLoginName.getText().toString()
            val email: String = binding.etLoginEmail.getText().toString()
            val pwd: String = binding.etLoginPass.getText().toString()

            insertNewUser(userName, pwd, email)

        }
    }

    private fun insertNewUser(userName: String, pwd: String, email: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<UserDataResponse> =
                retrofit.apiCall.insertNewUser(userName, pwd, email)
            if (myResponse.isSuccessful) {
                val response: UserDataResponse? = myResponse.body()
                if (response!!.response == "100") {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        navigateToLoginActivity()
                    }
                } else {
                    runOnUiThread {
                        showMessage("Wrong User / Password, please try again")
                    }

                }
            }

        }
    }

    private fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}