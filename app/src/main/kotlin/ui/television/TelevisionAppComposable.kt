package nl.ndat.compose.playground.ui.television

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import nl.ndat.compose.playground.ui.shared.AppContentComposable

@Composable
fun TelevisionAppComposable() = Scaffold {
	AppContentComposable(rememberNavController())
}
