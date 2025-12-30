plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("kapt")
}

android {
    namespace = "com.example.safezone"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.safezone"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1" // Use the version compatible with your Kotlin
    }
}

dependencies {


        // Core Android libraries
        implementation("androidx.core:core-ktx:1.17.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.4")

        // --- XML and View System Dependencies ---
        implementation("androidx.appcompat:appcompat:1.7.0") // Needed for AppCompatActivity
        implementation("com.google.android.material:material:1.11.0") // For Material Design components
        implementation("androidx.constraintlayout:constraintlayout:2.1.4") // For building complex layouts

        // --- Navigation Dependencies for Fragments ---
        implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
        implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

        // --- Room Database (Unchanged) ---
        implementation("androidx.room:room-runtime:2.6.1")
        implementation("androidx.room:room-ktx:2.6.1")
        // If you use annotation processing, you will need one of these:
        // kapt("androidx.room:room-compiler:2.6.1")
        // or
        // ksp("androidx.room:room-compiler:2.6.1")


        // --- Testing Dependencies ---
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.2.1")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

        // NOTE: All Jetpack Compose dependencies have been removed to resolve the conflict.
    val composeBom = platform("androidx.compose:compose-bom:2024.02.01")
    implementation(composeBom)

    // Core Compose libraries
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
}