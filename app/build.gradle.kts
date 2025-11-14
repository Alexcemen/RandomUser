plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.kapt")
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
        kotlinCompilerExtensionVersion = "1.5.11"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    // Compose BOM
    val composeBom = platform("androidx.compose:compose-bom:2024.10.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Compose core
    implementation("androidx.activity:activity-compose")
    implementation("androidx.lifecycle:lifecycle-runtime-compose")
    implementation("androidx.compose.material3:material3")


    // Navigation 3 (если используешь новую модель)
    implementation("androidx.navigation3:navigation3-ui:1.0.0-beta01")
    implementation("androidx.navigation3:navigation3-runtime:1.0.0-beta01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-navigation3:1.0.0-alpha04")

    // Room
    implementation("androidx.room:room-runtime:2.6.1")


    // Lifecycle + ViewModel compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-android-compiler:2.51")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Other
    implementation("androidx.core:core-ktx:1.13.1")
}