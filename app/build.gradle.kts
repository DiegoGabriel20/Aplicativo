plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") // Plugin do Kotlin
    id("com.google.gms.google-services") // Plugin do Firebase
    id("com.google.devtools.ksp") version "1.9.0-1.0.12" apply true // Plugin KSP adicionado
}

android {
    namespace = "br.edu.up.garagemapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "br.edu.up.garagemapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        jvmTarget = "1.8" // Definindo a versão do JVM
    }

    buildFeatures {
        compose = true // Habilitando o Compose
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.6.0" // Atualize para a versão mais recente do Compose
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Firebase (Firestore e Analytics)
    implementation(platform("com.google.firebase:firebase-bom:34.0.0")) // Firebase BOM
    implementation("com.google.firebase:firebase-firestore-ktx") // Firestore
    implementation("com.google.firebase:firebase-analytics-ktx") // Firebase Analytics (opcional)

    // Dependências do Accompanist e Coil
    implementation("com.google.accompanist:accompanist-permissions:0.36.0") // Atualize o Accompanist
    implementation("io.coil-kt:coil-compose:2.3.0")

    // Dependências do AndroidX
    implementation("androidx.core:core-ktx:1.10.0") // Atualize para a versão mais recente
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0") // Atualize para a versão mais recente
    implementation("androidx.activity:activity-compose:1.7.0") // Atualize para a versão mais recente
    implementation(platform("androidx.compose:compose-bom:2024.1.0")) // Atualize para o Compose BOM mais recente
    implementation("androidx.compose.ui:ui:2024.1.0")
    implementation("androidx.compose.ui:ui-graphics:2024.1.0")
    implementation("androidx.compose.ui:ui-tooling-preview:2024.1.0")
    implementation("androidx.material3:material3:1.1.0") // Atualize para a versão mais recente
    implementation("androidx.navigation:navigation-compose:2.6.0") // Atualize para a versão mais recente
    implementation("androidx.webkit:webkit:1.6.0") // Atualize para a versão mais recente

    // Room Database (se necessário)
    val room_version = "2.7.0" // Atualize para a versão mais recente do Room
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    ksp("androidx.room:room-compiler:$room_version") // Dependência KSP do Room

    // Dependências para testes
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.1.0"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:2024.1.0")

    // Dependências de debugging
    debugImplementation("androidx.compose.ui:ui-tooling:2024.1.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:2024.1.0")
}
