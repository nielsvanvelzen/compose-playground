package nl.ndat.compose.playground.ui.normal

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import nl.ndat.compose.playground.R
import nl.ndat.compose.playground.ui.shared.AppContentComposable

@Composable
fun DefaultAppComposable() {
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
		drawerContent = { AppContentComposable(navController) },
		content = { AppContentComposable(navController) }
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
