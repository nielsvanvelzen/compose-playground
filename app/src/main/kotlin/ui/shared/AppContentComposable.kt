package nl.ndat.compose.playground.ui.shared

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppContentComposable(navHostController: NavHostController) = NavHost(navHostController, "home") {
	composable("home") {
		Box(modifier = Modifier.background(Color.Black)) {

			LazyVerticalGrid(
				cells = GridCells.Adaptive(minSize = 128.dp),
			) {
				items((0..1000).map { it }) { item ->
					Button(
						modifier = Modifier
							.width(128.dp)
							.height(128.dp)
							.padding(28.dp),
						onClick = {}
					) {
						Text("Card $item")
					}
				}
			}
		}
	}
	composable("favorites") { Text("FAVORITES") }
}
