package fr.akvaternik.navigationcomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.plusAssign
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.navHost) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myNavigator = MyNavigator()
        navController.navigatorProvider += myNavigator
        val graph = navController.navInflater.inflate(R.navigation.nav_graph)
        navController.graph = graph

        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController, null)

        bottomNavigationView.setupWithNavController(navController)
    }
}
