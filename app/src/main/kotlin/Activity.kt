package nl.ndat.compose.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

class Activity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent { AppView() }
	}
}

@Preview
@Composable
fun AppView() = MaterialTheme {
	val navController = rememberNavController()
	val scaffoldState = rememberScaffoldState()
	val scope = rememberCoroutineScope()

	Scaffold(
		scaffoldState = scaffoldState,
		topBar = {
			TopAppBar {
				IconButton(onClick = { scope.launch { scaffoldState.drawerState.apply { if (isClosed) open() else close() } } }) {
					Icon(Icons.Filled.Menu, null)
				}
				Text(stringResource(R.string.app_name))
			}
		},
		bottomBar = { AppBottomNavigationView(navController) },
		drawerContent = { AppContentView(navController) },
		content = { AppContentView(navController) }
	)
}

@Composable
fun AppBottomNavigationView(navController: NavHostController) {
	BottomNavigation {
		BottomNavigationItem(
			icon = { Icon(Icons.Filled.Favorite, null) },
			selected = navController.currentDestination?.route == "favorites",
			onClick = { navController.navigate("favorites") }
		)

		BottomNavigationItem(
			icon = { Icon(Icons.Filled.Home, null) },
			selected = navController.currentDestination?.route == "home",
			onClick = { navController.navigate("home") }
		)
	}
}

@Composable
fun AppContentView(navController: NavHostController) {
	NavHost(navController, "home") {
		composable("home") { Text("Home") }
		composable("favorites") { Text("FAVORITES") }
	}
}
