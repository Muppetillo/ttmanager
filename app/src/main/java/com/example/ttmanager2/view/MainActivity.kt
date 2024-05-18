package com.example.ttmanager2.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ttmanager2.R
import com.example.ttmanager2.adapter.EventAdapter
import com.example.ttmanager2.databinding.ActivityMainBinding
import com.example.ttmanager2.model.leaguesList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "extra_id"
    }


    private lateinit var binding: ActivityMainBinding
    private lateinit var eventAdapter: EventAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        InitUI()
    }

    private fun InitUI() {
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

    private fun searchEventByName(query: String) {
        // IMPLEMENT SEARCH QUERY ON LEAGUE EVENTS
    }

    private fun navigateToLeagueActivity(id: String) {
        val intent = Intent(this, LeagueActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }

    private fun navigateToNewTeamActivity() {
        val intent = Intent(this, NewTeamActivity::class.java)
        startActivity(intent)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://192.168.1.135/bloodbowl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

