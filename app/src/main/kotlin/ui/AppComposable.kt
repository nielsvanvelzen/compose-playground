package nl.ndat.compose.playground.ui

import android.app.UiModeManager
import android.content.res.Configuration
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.getSystemService
import nl.ndat.compose.playground.ui.normal.DefaultAppComposable
import nl.ndat.compose.playground.ui.television.TelevisionAppComposable

enum class InterfaceType {
	DEFAULT,
	TELEVISION;

	companion object {
		fun fromConfigurationModeType(modeType: Int) = when (modeType) {
			Configuration.UI_MODE_TYPE_TELEVISION -> TELEVISION
			else -> DEFAULT
		}
	}
}

@Composable
fun AppComposable() {
	val uiModeManager = LocalContext.current.getSystemService<UiModeManager>()
	val uiModeType = uiModeManager?.currentModeType ?: Configuration.UI_MODE_TYPE_NORMAL
	val interfaceType = InterfaceType.fromConfigurationModeType(uiModeType)

	MaterialTheme {
		when (interfaceType) {
			InterfaceType.DEFAULT -> DefaultAppComposable()
			InterfaceType.TELEVISION -> TelevisionAppComposable()
		}
	}
}
