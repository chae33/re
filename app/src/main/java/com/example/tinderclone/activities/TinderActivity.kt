package com.example.tinderclone.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.tinderclone.R
import com.example.tinderclone.fragments.MatchesFragment
import com.example.tinderclone.fragments.ProfileFragment
import com.example.tinderclone.fragments.SwipeFragment
import com.google.android.material.tabs.TabLayout
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import kotlinx.android.synthetic.main.activity_main.*

class TinderActivity : AppCompatActivity() {

    private var profileFragment: ProfileFragment?=null
    private var swipeFragment: SwipeFragment?=null
    private var matchesFragment: MatchesFragment?=null


    private var profileTab: TabLayout.Tab?=null
    private var swipeTab: TabLayout.Tab?=null
    private var matchesTab: TabLayout.Tab?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileTab = navigationTabs.newTab()
        swipeTab = navigationTabs.newTab()
        matchesTab = navigationTabs.newTab()

        profileTab?.icon = ContextCompat.getDrawable(this,R.drawable.tab_profile)
        swipeTab?.icon = ContextCompat.getDrawable(this,R.drawable.tab_swipe)
        matchesTab?.icon = ContextCompat.getDrawable(this,R.drawable.tab_matches)

        navigationTabs.addTab(profileTab!!)
        navigationTabs.addTab(swipeTab!!)
        navigationTabs.addTab(matchesTab!!)

        navigationTabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab){
                    profileTab ->{
                        if(profileFragment == null){
                            profileFragment = ProfileFragment()
                        }
                        replaceFragment(profileFragment!!)
                    }
                    swipeTab ->{
                        if(swipeFragment == null){
                            swipeFragment = SwipeFragment()
                        }
                        replaceFragment(swipeFragment!!)

                    }
                    matchesTab ->{
                        if(matchesFragment == null){
                            matchesFragment = MatchesFragment()
                        }
                        replaceFragment(matchesFragment!!)

                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                onTabSelected(tab)
            }

        })

        profileTab?.select()
    }


    fun replaceFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()

    }
    companion object{
        fun newIntent(context: Context?)= Intent(context,TinderActivity::class.java)
    }



}