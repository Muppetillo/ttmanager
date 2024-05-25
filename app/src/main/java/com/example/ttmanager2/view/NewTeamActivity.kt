package com.example.ttmanager2.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ttmanager2.R
import com.example.ttmanager2.adapter.FactionAdapter
import com.example.ttmanager2.adapter.PositionalMainAdapter
import com.example.ttmanager2.adapter.PositionalSecondaryAdapter
import com.example.ttmanager2.databinding.ActivityNewTeamBinding
import com.example.ttmanager2.model.FactionDataResponse
import com.example.ttmanager2.model.FactionItemResponse
import com.example.ttmanager2.model.PositionalDataResponse
import com.example.ttmanager2.model.TeamDataResponse
import com.example.ttmanager2.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class NewTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewTeamBinding
    private lateinit var retrofit: RetrofitClient
    private lateinit var factionAdapter: FactionAdapter
    private lateinit var positionalMainAdapter: PositionalMainAdapter
    private lateinit var positionalSecondaryAdapter: PositionalSecondaryAdapter
    private var selectedFaction: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewTeamBinding.inflate(layoutInflater)
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

        initFactionAdapter()
        initPositionalMainAdapter()
        initPositionalSecondaryAdapter()
        initCreateTeamBtn()
        loadTeams()
    }

    private fun initCreateTeamBtn() {
        //cvCreateTeam
        binding.cvCreateTeam.setOnClickListener {

            if(binding.etNewTeamName.getText().toString() == ""){
                showMessage("Please insert a name for your team")

            } else if (selectedFaction == null) {
                showMessage("Please select a faction for your team")
            } else {
                val teamName: String = binding.etNewTeamName.getText().toString()
                insertTeam(selectedFaction!!,teamName)
            }
        }
    }

    private fun initPositionalSecondaryAdapter() {
        positionalSecondaryAdapter = PositionalSecondaryAdapter()
        binding.rvTeamPlayersSecondary.setHasFixedSize(true)
        binding.rvTeamPlayersSecondary.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvTeamPlayersSecondary.adapter = positionalSecondaryAdapter
    }

    private fun initPositionalMainAdapter() {
        //rvTeamPlayersMain
        positionalMainAdapter = PositionalMainAdapter()
        binding.rvTeamPlayersMain.setHasFixedSize(true)
        binding.rvTeamPlayersMain.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvTeamPlayersMain.adapter = positionalMainAdapter
    }

    private fun initFactionAdapter() {
        factionAdapter = FactionAdapter { factionItem -> showFactionInfo(factionItem) }
        binding.rvNewTeamFaction.setHasFixedSize(true)
        binding.rvNewTeamFaction.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        binding.rvNewTeamFaction.adapter = factionAdapter
    }

    private fun showMessage(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    private fun showFactionInfo(factionItem: FactionItemResponse) {
        selectedFaction = factionItem.id
        binding.tvFactionTitle.text = "Team info: ${factionItem.name}"
        binding.tvFactionRerolls.text = "Reroll: ${factionItem.reroll}k"
        if (factionItem.apothecary == 1) {
            binding.tvFactionApothecary.text = "Apothecary: Yes"
        } else {
            binding.tvFactionApothecary.text = "Apothecary: No"
        }
        binding.tvFactionTier.text = "Tier: ${factionItem.tier}"
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<PositionalDataResponse> =
                retrofit.apiCall.getPositionalInfo(factionItem.id)
            if (myResponse.isSuccessful) {
                val response: PositionalDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        positionalMainAdapter.updateList(response.positionals)
                        positionalSecondaryAdapter.updateList(response.positionals)
                    }
                }
            }

        }
    }

    private fun navigateToTeamActivity(id: Int) {

        val intent = Intent(this, MyTeamActivity::class.java)

        intent.putExtra("teamID",id )
        startActivity(intent)
    }

    private fun insertTeam(selectedFaction: String, teamName: String) {
        val userId = intent.getStringExtra("userId").toString().toInt()
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<TeamDataResponse> =
                retrofit.apiCall.insertNewTeam(teamName, selectedFaction,userId)
            if (myResponse.isSuccessful) {
                val response: TeamDataResponse? = myResponse.body()
                if (response!!.response == "100") {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        getTeam(selectedFaction, teamName, userId)
                    }
                } else {
                    runOnUiThread {
                        showMessage("Wrong User / Password, please try again")
                    }

                }
            }
        }

    }

    private fun getTeam(selectedFaction: String, teamName: String, userId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<TeamDataResponse> =
                retrofit.apiCall.getTeamInfo(teamName, selectedFaction,userId)
            if (myResponse.isSuccessful) {
                val response: TeamDataResponse? = myResponse.body()
                if (response!!.response == "100") {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        navigateToTeamActivity(response.teams[0].id)
                    }
                } else {
                    runOnUiThread {
                        showMessage("Wrong User / Password, please try again")
                    }

                }
            }
        }
    }

    private fun loadTeams() {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<FactionDataResponse> =
                retrofit.apiCall.getFactions()
            if (myResponse.isSuccessful) {
                val response: FactionDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        factionAdapter.updateList(response.factions)
                    }
                }

            }

        }
    }

}



