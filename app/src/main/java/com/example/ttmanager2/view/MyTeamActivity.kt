package com.example.ttmanager2.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ttmanager2.R
import com.example.ttmanager2.databinding.ActivityMyTeamBinding
import com.example.ttmanager2.databinding.ActivityNewTeamBinding

class MyTeamActivity : AppCompatActivity() {
    private lateinit var intent: Intent
    private lateinit var bundle: Bundle
    private lateinit var binding: ActivityMyTeamBinding

    
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
        intent = getIntent()
        bundle = intent.getBundleExtra("bundle")!!
        val teamName = bundle.getString("teamName")
        val faction = bundle.getString("faction")

        binding.tvMyTeamInfo.text = "Team name: "+teamName+Char(10)+"Faction: "+faction


    }
}