package com.example.ttmanager2.view

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.view.adapter.HirePlayersAdapter
import com.example.ttmanager2.view.adapter.RosterPrimaryAdapter
import com.example.ttmanager2.view.adapter.RosterSecondaryAdapter
import com.example.ttmanager2.view.adapter.TeamMatchAdapter
import com.example.ttmanager2.view.adapter.TeamResultAdapter
import com.example.ttmanager2.databinding.ActivityMyTeamBinding
import com.example.ttmanager2.model.PlayerDataResponse
import com.example.ttmanager2.model.PositionalDataResponse
import com.example.ttmanager2.model.PositionalItemResponse
import com.example.ttmanager2.model.TeamDataResponse
import com.example.ttmanager2.model.TeamItemResponse
import com.example.ttmanager2.model.matchList
import com.example.ttmanager2.model.resultList
import com.example.ttmanager2.retrofit.RetrofitClient
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MyTeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyTeamBinding
    private lateinit var retrofit: RetrofitClient
    private lateinit var rosterPrimaryAdapter: RosterPrimaryAdapter
    private lateinit var rosterSecondaryAdapter: RosterSecondaryAdapter
    private lateinit var teamMatchAdapter: TeamMatchAdapter
    private lateinit var teamResultAdapter: TeamResultAdapter
    private lateinit var hirePlayersAdapter: HirePlayersAdapter
    private var userID: Int = 0
    private lateinit var positionals: List<PositionalItemResponse>
    private lateinit var team: TeamItemResponse

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
        initUI()
    }

    private fun initUI() {
        userID = intent.getStringExtra("userIDString")!!.toInt()
        var teamIDString = intent.getStringExtra("teamIDString")
        val teamID = teamIDString!!.toInt()
        Log.i("Cuerpo de la consulta","Antes de la consulta "+ teamID.toString())
        getTeamInfo(teamID)
        initAdapters()
        initBtnBackHome()
        initBtnEditRoster()
    }

    private fun getTeamInfo(teamID: Int) {
        Log.i("Corutinas","getTeamInfo")
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<TeamDataResponse> =
                retrofit.apiCall.getTeamInfoByID(teamID)
            if (myResponse.isSuccessful) {
                val response: TeamDataResponse? = myResponse.body()
                if (response!!.response == "100") {
                    runOnUiThread {
                        LoadData(response.teams[0])
                    }
                } else {
                    runOnUiThread {
                        showMessage("Load data failed")
                    }

                }
            }
        }
    }

    private fun initAdapters() {
        initRosterPrimaryAdapter()
        initRosterSecondaryAdapter()
        initLatestMatchesAdapter()
        initNextMatchesAdapter()
    }

    private fun initRosterPrimaryAdapter() {
        rosterPrimaryAdapter = RosterPrimaryAdapter()
        binding.rvTeamPlayersMain.setHasFixedSize(true)
        binding.rvTeamPlayersMain.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        binding.rvTeamPlayersMain.adapter = rosterPrimaryAdapter
    }

    private fun initRosterSecondaryAdapter() {
        rosterSecondaryAdapter = RosterSecondaryAdapter()
        binding.rvTeamPlayersSecondary.setHasFixedSize(true)
        binding.rvTeamPlayersSecondary.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        binding.rvTeamPlayersSecondary.adapter = rosterSecondaryAdapter
    }

    private fun initNextMatchesAdapter() {
        teamResultAdapter = TeamResultAdapter(resultList)
        binding.rvLatetsResults.setHasFixedSize(true)
        binding.rvLatetsResults.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        binding.rvLatetsResults.adapter = teamResultAdapter
    }

    private fun initLatestMatchesAdapter() {
        teamMatchAdapter = TeamMatchAdapter(matchList)
        binding.rvNextMatches.setHasFixedSize(true)
        binding.rvNextMatches.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        binding.rvNextMatches.adapter = teamMatchAdapter
    }

    private fun initBtnBackHome() {
        binding.btnBackHome.setOnClickListener{
            navigateToMainActivity()
        }
    }

    private fun initBtnEditRoster() {
        binding.ivEditRoster.setOnClickListener{
            openHirePlayerDialog()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun LoadData(team: TeamItemResponse) {
        this.team = team
        LoadHeaderInfo()
        LoadRoster()
        LoadPositionalsInfo()
        LoadTechStaffInfo()
        //LoadLatestResults(team.id)
        //LoadNextMatchs(team.id)
        //LoadTechStaf()

    }

    private fun LoadHeaderInfo() {
        binding.tvMyTeamName.text = team.name
        binding.tvMyTeamFaction.text = team.faction
        binding.tvMyTeamValue.text = "${team.teamValue}"
        when(team.factionId){
            "AZ"-> setIcon(R.drawable.amazon)
            "BO"-> setIcon(R.drawable.black_orc)
            "CC"-> setIcon(R.drawable.chaos_chosen)
            "CD"-> setIcon(R.drawable.chaos_dwarf)
            "CR"-> setIcon(R.drawable.chaos_renegade)
            "DE"-> setIcon(R.drawable.dark_elf)
            "DW"-> setIcon(R.drawable.dwarf)
            "EU"-> setIcon(R.drawable.elven_union)
            "GN"-> setIcon(R.drawable.gnome)
            "GO"-> setIcon(R.drawable.goblin)
            "HA"-> setIcon(R.drawable.halfling)
            "HE"-> setIcon(R.drawable.high_elf)
            "HU"-> setIcon(R.drawable.human)
            "IN"-> setIcon(R.drawable.imperial_nobility)
            "KH"-> setIcon(R.drawable.khorne)
            "LI"-> setIcon(R.drawable.lizardmen)
            "NH"-> setIcon(R.drawable.necromantic_horror)
            "NO"-> setIcon(R.drawable.norse)
            "NU"-> setIcon(R.drawable.nurgle)
            "OG"-> setIcon(R.drawable.ogre)
            "OR"-> setIcon(R.drawable.orc)
            "OW"-> setIcon(R.drawable.old_world_alliance)
            "SK"-> setIcon(R.drawable.skaven)
            "SL"-> setIcon(R.drawable.bloodbowl_logo)
            "SN"-> setIcon(R.drawable.snotling)
            "SU"-> setIcon(R.drawable.shambling_undead)
            "TK"-> setIcon(R.drawable.tomb_king)
            "UD"-> setIcon(R.drawable.underworld_denizen)
            "VA"-> setIcon(R.drawable.vampire)
            "WE"-> setIcon(R.drawable.wood_elf)
        }
    }

    private fun LoadRoster() {
        Log.i("Corutinas","initRoster ${team.id}")
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<PlayerDataResponse> =
                retrofit.apiCall.getPlayersByTeamID(team.id)
            if (myResponse.isSuccessful) {
                val response: PlayerDataResponse? = myResponse.body()
                if (response!!.response == "Success") {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        rosterPrimaryAdapter.updateList(response.players)
                        rosterSecondaryAdapter.updateList(response.players)
                    }
                }
            }
        }
    }

    private fun LoadPositionalsInfo() {
        Log.i("Corutinas","initPositionalsInfo")
        Log.i("Corutinas",team.factionId)
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<PositionalDataResponse> =
                retrofit.apiCall.getPositionalInfo(team.factionId)
            if (myResponse.isSuccessful) {
                val response: PositionalDataResponse? = myResponse.body()
                if (response != null) {
                    runOnUiThread {
                        setPositionals(response.positionals)
                    }
                } else {
                    runOnUiThread {
                        showMessage("Load data failed")
                    }
                }
            }
        }
    }

    private fun LoadTechStaffInfo() {
        binding.tvTreasury.text = "${team.treasury}k"
        binding.tvRerolls.text ="${team.rerolls}"
        binding.tvDedicatedFans.text ="${team.dedicatedFans}"
        binding.tvAssistantCoaches.text ="${team.assistanCoaches}"
        binding.tvCheerleaders.text ="${team.cheerleaders}"
        binding.tvApothecary.text = "${team.hasApothecary}"
        binding.tvSpecialRules.text = "Pending..."
    }

    private fun openHirePlayerDialog() {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_buy_player)

        val tvMyTreasury: TextView = dialog.findViewById(R.id.tvTeamTreasury)
        val rvPositionals: RecyclerView = dialog.findViewById(R.id.rvHirePlayers)
        val btnBack: MaterialButton = dialog.findViewById(R.id.btnBackDialog)

        tvMyTreasury.text = team.treasury.toString() + "k"
        btnBack.setOnClickListener{
            dialog.hide()
        }
        hirePlayersAdapter = HirePlayersAdapter{positionalItem -> updateRoster(positionalItem)}
        rvPositionals.setHasFixedSize(true)
        rvPositionals.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        rvPositionals.adapter = hirePlayersAdapter
        hirePlayersAdapter.updateList(positionals)


        dialog.show()

    }

    private fun updateRoster(positionalItem: PositionalItemResponse) {
        updateTeam(positionalItem.price)
        insertNewPlayer(positionalItem.name)
    }

    private fun updateTeam(price: Int) {
        Log.i("Corutinas","updateTeam")
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<TeamDataResponse> =
                retrofit.apiCall.updateTeam(team.id,price)
            if (myResponse.isSuccessful) {
                val response: TeamDataResponse? = myResponse.body()
                if (response!!.response == "100") {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        showMessage("Player succesfully hired!")
                    }
                } else {
                    runOnUiThread{
                        showMessage("Something went wrong :(")
                    }
                }
            }
        }
    }

    private fun insertNewPlayer(name: String) {
        Log.i("Corutinas","InsertNewPlayer")
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<PlayerDataResponse> =
                retrofit.apiCall.insertNewPlayer(name,team.id,team.factionId)
            if (myResponse.isSuccessful) {
                val response: PlayerDataResponse? = myResponse.body()
                if (response!!.response == "100") {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        showMessage("Player succesfully hired!")

                    }
                } else {
                    runOnUiThread{
                        showMessage("Something went wrong :(")
                    }
                }
            }
        }
    }

    private fun setPositionals(positionals: List<PositionalItemResponse>) {
        this.positionals = positionals
    }

    private fun navigateToMainActivity() {
        val idString = userID.toString()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("idString",idString)
        startActivity(intent)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun setIcon(icon: Int) {
        binding.ivTeamLogo.setImageResource(icon)
    }

}