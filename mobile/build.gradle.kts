@file:Suppress("SpellCheckingInspection")

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {

    compileSdk = Deps.compileSdkVersion
    buildToolsVersion = Deps.buildToolVersion

    defaultConfig {
        minSdk = Deps.minSdkVersion
        targetSdk = Deps.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFile("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        create("this") {
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions.setSourceCompatibility(JavaVersion.VERSION_1_8)
    compileOptions.setTargetCompatibility(JavaVersion.VERSION_1_8)
    kotlinOptions.jvmTarget = "1.8"
    lint {
        abortOnError = false
    }
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Deps.kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-common:${Deps.kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Deps.kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Deps.kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${Deps.kotlinVersion}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.core:core-ktx:1.7.0")
    api(project(":player"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    implementation("com.google.dagger:hilt-android:2.38.1")
    //implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")
    //kapt("androidx.hilt:hilt-compiler:1.0.0-beta01")

    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")

    implementation("androidx.navigation:navigation-fragment-ktx:2.4.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.1")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation("com.kirich1409.viewbindingpropertydelegate:viewbindingpropertydelegate:1.4.1")

    implementation(project(":common"))
    // MaterialDrawer
    api("com.mikepenz:materialdrawer:8.4.0")
    api("com.mikepenz:materialdrawer-nav:8.4.0")
    api("com.mikepenz:materialdrawer-iconics:8.4.0")
    //FontAwesome
    api("com.mikepenz:fontawesome-typeface:5.9.0.2-kotlin@aar")
    implementation("com.intuit.sdp:sdp-android:1.0.6")

    //debugImplementation("com.squareup.leakcanary:leakcanary-android:2.7")
    implementation("com.mikepenz:aboutlibraries:8.8.5")

    // Yodo1
    implementation ("com.yodo1.mas:full:4.8.9") {
        exclude (group= "com.google.android.exoplayer", module= "exoplayer")
       // exclude (group= "com.yandex.android")
    }
    //In-app update
    // This dependency is downloaded from the Google’s Maven repository.
    // So, make sure you also include that repository in your project's build.gradle file.
    implementation ("com.google.android.play:app-update:2.0.1")

    // For Kotlin users also add the Kotlin extensions library for Play In-App Update:
    implementation ("com.google.android.play:app-update-ktx:2.0.1")

    implementation("com.android.billingclient:billing:6.0.0")

  //  implementation ("com.yandex.android:mobileads:5.1.1")
  //  implementation ("com.yandex.android:mobmetricalib:5.0.0")
  //  implementation ("com.yandex.android:mobmetricalib-identifiers:5.0.0")


}
//(plugin = "com.mikepenz.aboutlibraries.plugin")