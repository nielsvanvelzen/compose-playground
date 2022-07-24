plugins {
	alias(libs.plugins.android.app)
	alias(libs.plugins.kotlin.android)
}

android {
	namespace = "nl.ndat.compose.playground"
	compileSdk = 32

	defaultConfig {
		minSdk = 21
		targetSdk = 32

		applicationId = "nl.ndat.compose.playground"
		versionCode = 1
		versionName = "1.0.0"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
		}
	}

	buildFeatures {
		compose = true
	}

	composeOptions {
		kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
	}
}

dependencies {
	implementation(libs.androidx.core)

	implementation(libs.bundles.androidx.compose)
}
