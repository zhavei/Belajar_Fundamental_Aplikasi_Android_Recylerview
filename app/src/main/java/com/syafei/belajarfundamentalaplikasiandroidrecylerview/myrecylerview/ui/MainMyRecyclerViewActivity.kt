package com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.R
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.databinding.ActivityMyrecyclerviewMainBinding
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.data.Hero
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.ui.adapter.ListHeroAdapter
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.ui.adapter.OnItemClickCallback

class MainMyRecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyrecyclerviewMainBinding
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyrecyclerviewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvHeroes = findViewById(R.id.rv_mymain_rv)
        rvHeroes.setHasFixedSize(true)

        list.addAll(listHeroes)

        showRecyclerList()

    }

    private fun showRecyclerList() {

        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallBack(object : OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })

    }

    private val listHeroes: ArrayList<Hero>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val description = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listHero = ArrayList<Hero>()
            for (i in dataName.indices) {
                val hero = Hero(dataName[i], description[i], dataPhoto.getResourceId(i, -1))
                listHero.add(hero)
            }
            return listHero
        }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "kamu ngeclick ${hero.name}", Toast.LENGTH_SHORT).show()
    }
}