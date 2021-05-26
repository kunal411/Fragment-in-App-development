package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addFragment = findViewById<Button>(R.id.add)
        addFragment.setOnClickListener {
            val fragment = FragmentOne()

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.main_container, fragment, "OneFragment")
            fragmentTransaction.commit()
        }

        val removeFragment = findViewById<Button>(R.id.remove)
        removeFragment.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.main_container)

            fragment?.let {
                supportFragmentManager.beginTransaction().remove(fragment).commit()
            }
        }

        val replaceFragment = findViewById<Button>(R.id.replace)
        replaceFragment.setOnClickListener {
            val fragment = FragmentTwo()

            with(supportFragmentManager.beginTransaction()){
                replace(R.id.main_container, fragment)
                //addToBackStack(null)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }
        }
    }
}