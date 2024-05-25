package com.example.ttmanager2.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ttmanager2.R
import com.example.ttmanager2.adapter.EventAdapter
import com.example.ttmanager2.databinding.ActivityMainBinding
import com.example.ttmanager2.model.UserDataResponse
import com.example.ttmanager2.model.leaguesList
import com.example.ttmanager2.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var eventAdapter: EventAdapter
    private lateinit var retrofit: RetrofitClient

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        retrofit = RetrofitClient()
        InitUI()
    }

    private fun InitUI() {
        val userId = intent.getStringExtra("idString").toString()
        getUserName(userId)



        binding.searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?) = false

                override fun onQueryTextChange(newText: String?) = false

            }
        )

        eventAdapter = EventAdapter(leaguesList){ eventAdapterId -> navigateToLeagueActivity(eventAdapterId)}
        binding.rvNewEvents.setHasFixedSize(true)
        binding.rvNewEvents.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvNewEvents.adapter = eventAdapter
        binding.btnNewTeam.setOnClickListener {navigateToNewTeamActivity() }


    }

    private fun getUserName(userId: String) {
        val id = userId.toInt()
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<UserDataResponse> =
                retrofit.apiCall.getUserName(id)
            if (myResponse.isSuccessful) {
                val response: UserDataResponse? = myResponse.body()
                if (response!!.response == "100") {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        updateTitle(response.user[0].name)
                    }
                } else {
                    runOnUiThread {
                        showMessage("Wrong User / Password, please try again")
                    }

                }
            }
        }

    }

    private fun updateTitle(name: String) {
        binding.tvWelcome.text = "Welcome back, $name"
    }

    private fun searchEventByName(query: String) {
        // IMPLEMENT SEARCH QUERY ON LEAGUE EVENTS
    }

    private fun navigateToLeagueActivity(id: String) {
        val intent = Intent(this, LeagueActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToNewTeamActivity() {
        val intent = Intent(this, NewTeamActivity::class.java)
        startActivity(intent)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}

