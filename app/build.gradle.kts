plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.kapt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.randomuser.app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.randomuser.app"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = "21"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(libs.kotlin.serialization.core)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.gson)

    // Compose BOM
    implementation(platform(libs.compose.bom))
    implementation(libs.ui.tooling.preview)
    implementation(libs.foundation)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.material3)
    androidTestImplementation(platform(libs.compose.bom))

    // Compose base
    implementation(libs.activity.compose)
    implementation(libs.lifecycle.runtime.compose)

    // Navigation 3
    implementation(libs.navigation3.ui)
    implementation(libs.navigation3.runtime)
    implementation(libs.lifecycle.viewmodel.navigation3)

    // Room
    implementation(libs.room.runtime)

    // Lifecycle + ViewModel compose
    implementation(libs.lifecycle.viewmodel.compose)

    // Hilt
    implementation(libs.hilt.android)
    debugImplementation(libs.ui.tooling)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    // Core KTX
    implementation(libs.core.ktx)
}