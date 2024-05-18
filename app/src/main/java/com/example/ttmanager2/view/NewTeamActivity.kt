package com.example.ttmanager2.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ttmanager2.ApiService
import com.example.ttmanager2.R
import com.example.ttmanager2.adapter.EventAdapter
import com.example.ttmanager2.adapter.FactionAdapter
import com.example.ttmanager2.databinding.ActivityNewLeagueBinding
import com.example.ttmanager2.databinding.ActivityNewTeamBinding
import com.example.ttmanager2.model.FactionDataResponse
import com.example.ttmanager2.model.FactionItemResponse
import com.example.ttmanager2.model.leaguesList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.CallAdapter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewTeamBinding
    private lateinit var retrofit: Retrofit
    private lateinit var factionAdapter: FactionAdapter

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

        retrofit = getRetrofit()
        initUI()


    }

    private fun initUI() {
        factionAdapter = FactionAdapter { factionItem -> showFactionInfo(factionItem) }
        binding.rvNewTeamFaction.setHasFixedSize(true)
        binding.rvNewTeamFaction.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.rvNewTeamFaction.adapter = factionAdapter
        binding.cvCreateTeam.setOnClickListener { navigateToTeamActivity() }
        loadTeams()
    }

    private fun showFactionInfo(factionItem: FactionItemResponse) {
        binding.tvFactionTitle.text = "Team info: ${factionItem.name}"
        binding.tvFactionRerolls.text = "Reroll: ${factionItem.reroll}k"
        if (factionItem.apothecary == 1){
            binding.tvFactionApothecary.text = "Apothecary: Yes"
        } else {
            binding.tvFactionApothecary.text = "Apothecary: No"
        }
        binding.tvFactionTier.text = "Tier: ${factionItem.tier}"
        /*CoroutineScope(Dispatchers.IO).launch {
             val myResponse: Response<PositionalDataResponse> =
                 retrofit.create(ApiService::class.java).getPositionals(factionId)
             if (myResponse.isSuccessful) {
                 val response: PositionalDataResponse? = myResponse.body()
                 if (response != null) {
                     Log.i("Cuerpo de la consulta", response.toString())
                     runOnUiThread {
                         positionalAdapter.updateList(response.positionals)
                     }
                 }
             }

         }*/
    }

    private fun navigateToTeamActivity() {
        val intent = Intent(this, MyTeamActivity::class.java)
        startActivity(intent)
    }

    private fun loadTeams() {

        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<FactionDataResponse> = retrofit.create(ApiService::class.java).getFactions()
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

    private fun showFactions(factions: List<FactionItemResponse>) {
        factionAdapter = FactionAdapter (factionList = factions){ factionId -> showFactionInfo(factionId) }
        binding.rvNewTeamFaction.setHasFixedSize(true)
        binding.rvNewTeamFaction.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.rvNewTeamFaction.adapter = factionAdapter
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://192.168.1.135/bloodbowl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}



