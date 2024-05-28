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
import com.example.ttmanager2.adapter.MatchAdapter
import com.example.ttmanager2.adapter.ResultAdapter
import com.example.ttmanager2.adapter.TeamAdapter
import com.example.ttmanager2.databinding.ActivityMainBinding
import com.example.ttmanager2.model.TeamDataResponse
import com.example.ttmanager2.model.UserDataResponse
import com.example.ttmanager2.model.leaguesList
import com.example.ttmanager2.model.matchList
import com.example.ttmanager2.model.resultList
import com.example.ttmanager2.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var eventAdapter: EventAdapter
    private lateinit var matchAdapter: MatchAdapter
    private lateinit var resultAdapter: ResultAdapter
    private lateinit var teamsAdapter: TeamAdapter
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
        val userID = intent.getStringExtra("idString").toString()
        getUserName(userID)



        binding.searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?) = false

                override fun onQueryTextChange(newText: String?) = false

            }
        )
        initEventAdapter()
        initMatchAdapter()
        initResultsAdapter()
        initTeamAdapter()
        loadData(userID)

        binding.btnNewTeam.setOnClickListener {navigateToNewTeamActivity(userID) }


    }

    private fun loadData(userID: String) {
        //loadResults()
        //loadMatches()
        loadTeams(userID.toInt())
    }

    private fun loadTeams(userID: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<TeamDataResponse> =
                retrofit.apiCall.getTeamsByUserID(userID)
            if (myResponse.isSuccessful) {
                val response: TeamDataResponse? = myResponse.body()
                if (response!!.response == "100") {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        teamsAdapter.updateList(response.teams)
                    }
                }
            }
        }
    }

    private fun initTeamAdapter() {
        teamsAdapter = TeamAdapter{teamID -> navigateToTeamActivity(teamID)}
        binding.rvMyTeams.setHasFixedSize(true)
        binding.rvMyTeams.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rvMyTeams.adapter = teamsAdapter
    }


    private fun initResultsAdapter() {
        resultAdapter = ResultAdapter(resultList) {matchID -> navigateToMatchActivity(matchID)}
        binding.rvLatetsResults.setHasFixedSize(true)
        binding.rvLatetsResults.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvLatetsResults.adapter = resultAdapter
    }

    private fun initMatchAdapter() {
        matchAdapter = MatchAdapter(matchList) {matchID -> navigateToMatchActivity(matchID)}
        binding.rvNextMatches.setHasFixedSize(true)
        binding.rvNextMatches.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvNextMatches.adapter = matchAdapter
    }

    private fun navigateToMatchActivity(matchID: String) {
        val intent = Intent(this, MatchActivity::class.java)
        intent.putExtra("matchID",matchID )
        startActivity(intent)
    }

    private fun initEventAdapter() {

        eventAdapter = EventAdapter(leaguesList){ eventId -> navigateToLeagueActivity(eventId)}
        binding.rvNewEvents.setHasFixedSize(true)
        binding.rvNewEvents.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvNewEvents.adapter = eventAdapter

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

    private fun navigateToNewTeamActivity(userId: String) {
        val intent = Intent(this, NewTeamActivity::class.java)
        intent.putExtra("userId",userId )
        startActivity(intent)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToTeamActivity(teamID: String) {
        val id = teamID.toInt()
        val intent = Intent(this, MyTeamActivity::class.java)
        intent.putExtra("teamID",id )
        startActivity(intent)
    }
}

