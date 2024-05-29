package com.example.ttmanager2.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ttmanager2.R
import com.example.ttmanager2.databinding.ActivityMyTeamBinding
import com.example.ttmanager2.databinding.ActivityNewTeamBinding
import com.example.ttmanager2.model.TeamDataResponse
import com.example.ttmanager2.model.TeamItemResponse
import com.example.ttmanager2.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class MyTeamActivity : AppCompatActivity() {
    private lateinit var intent: Intent
    private lateinit var binding: ActivityMyTeamBinding
    private lateinit var retrofit: RetrofitClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyTeamBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        retrofit = RetrofitClient()
        intent = getIntent()
        var userID = intent.getIntExtra("teamID", 0)
        getTeamInfo(userID)


    }

    private fun getTeamInfo(userID: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<TeamDataResponse> =
                retrofit.apiCall.getTeamInfoByID(userID)
            if (myResponse.isSuccessful) {
                val response: TeamDataResponse? = myResponse.body()
                if (response!!.response == "100") {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        initUI(response.teams[0])
                    }
                } else {
                    runOnUiThread {
                        showMessage("Wrong User / Password, please try again")
                    }

                }
            }
        }
    }

    private fun initUI(team: TeamItemResponse) {
        //binding.tvMyTeamInfo.text = "${team.id}"
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}