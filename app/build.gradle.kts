plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("io.github.takahirom.roborazzi")
}

android {
    namespace = "com.example.calculadora"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.calculadora"
        minSdk = 24
        targetSdk = 35
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

    testOptions {
        unitTests {
            isIncludeAndroidResources = true

            all {
                it.systemProperty(
                    "robolectric.pixelCopyRenderMode",
                    "hardware"
                )
            }
        }
    }

}

dependencies {
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)

        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)
        implementation(libs.androidx.ui.test.junit4.android)

        implementation(libs.androidx.compose.foundation.layout)
        implementation(libs.androidx.constraintlayout)

        // tests
        testImplementation(libs.junit)
        testImplementation(kotlin("test"))

        // Robolectric
        testImplementation("org.robolectric:robolectric:4.13")

        // Roborazzi (mesma versão alpha-3 para todos)
        testImplementation("io.github.takahirom.roborazzi:roborazzi:1.8.0-alpha-3")
        testImplementation("io.github.takahirom.roborazzi:roborazzi-compose:1.8.0-alpha-3")

        // Roborazzi JUnit Rule (contém RoborazziRule)
        testImplementation("io.github.takahirom.roborazzi:roborazzi-junit-rule:1.8.0-alpha-3")

        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.11.2")

        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)
}