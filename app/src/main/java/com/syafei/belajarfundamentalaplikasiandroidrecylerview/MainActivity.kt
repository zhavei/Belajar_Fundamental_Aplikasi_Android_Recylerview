package com.syafei.belajarfundamentalaplikasiandroidrecylerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.adapter.RvAdapters
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.data.Hewan
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var hewanData: ArrayList<Hewan>
    private lateinit var animalAdapter: RvAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hewanData = ArrayList<Hewan>()
        animalAdapter = RvAdapters(this, hewanData)
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = animalAdapter

        listAnimalAdd()


    }

     private fun listAnimalAdd() {
        hewanData.add(
            Hewan(R.drawable.ic_baseline_1x_mobiledata_24, "bebek", 9, "dedek"),
        )
        hewanData.add(Hewan(R.drawable.ic_baseline_3d_rotation_24, "guguk", 5, "daging"))
        hewanData.add(Hewan(R.drawable.ic_baseline_accessibility_new_24, "emeng", 3, "ikan"))
    }
}