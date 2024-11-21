plugins {
    // Plugins principais
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    // Plugin do Google Services para Firebase
    id("com.google.gms.google-services") version "4.4.2" apply false
}

android {
    compileSdkVersion(33)  // Certifique-se de estar usando a versão correta do SDK

    defaultConfig {
        applicationId = "com.example.seuapp"
        minSdkVersion(21)  // Defina conforme sua necessidade
        targetSdkVersion(33)  // Defina conforme sua necessidade
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    // Dependência do Firestore
    implementation("com.google.firebase:firebase-firestore:24.7.0")
    implementation("com.google.firebase:firebase-auth:21.0.5")      // Para autenticação, se necessário
    implementation("com.google.firebase:firebase-storage:20.1.1")    // Caso precise de Firebase Storage

    // Outras dependências do Firebase que você estiver usando
    implementation("com.google.firebase:firebase-analytics:21.0.0") // Caso precise de Analytics
}

// Aplica o plugin do Google Services no final
apply(plugin = "com.google.gms.google-services")
