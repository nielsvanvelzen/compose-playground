package nl.ndat.compose.playground.ui.shared

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppContentComposable(navHostController: NavHostController) = NavHost(navHostController, "home") {
	composable("home") { Text("Home") }
	composable("favorites") { Text("FAVORITES") }
}
