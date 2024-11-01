plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services) // Google Services plugin applied through alias
}

android {
    namespace = "com.example.expenseTracker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.expenseTracker"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Core Android libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Firebase BoM for managing Firebase dependencies
    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))

    // Firebase Authentication library using BoM
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-database") // Keep if firebase-database is not defined in libs.versions.toml

    // Google Play Services Auth library (with explicit version)
    implementation("com.google.android.gms:play-services-auth:21.2.0")

    implementation("com.google.firebase:firebase-auth-ktx")
    // Optional, but recommended: Firebase BoM for versioning consistency
    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}