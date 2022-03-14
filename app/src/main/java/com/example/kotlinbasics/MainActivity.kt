package com.example.kotlinbasics

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.kotlinbasics.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    val constante: String = "Una constante"

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        val a: Int = 1
        //a = 5
        /*
        *
        * comentario de varias líneas
        * NO ES NECESARIO PONER ;
        * */
        var b: Int = 2
        b = 3
        // buscar esta cosa: Log.i()
        Log.i("Basics","valor de b= $b" )
        Log.i("Basics", constante )

        ejecutar()

    }

    fun ejecutar(){
        val x = 1
        when(x){
            1 -> Log.i("Basics","es un uno")
            2 -> {
                var algo = "asdas"
                var otro = "qweqw"
                Log.i("Basics",algo+otro)
            }
            else -> Log.i("Basics","tas mal mijo")
        }
    }


    fun ejemplo(a: Int): Boolean{
        return true
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}