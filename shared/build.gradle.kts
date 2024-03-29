plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")

}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.yazan.librarykmm"
    compileSdk = 34
    defaultConfig {
        minSdk = 30
    }
}

group = "com.example"
version = "1.0"

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://github.com/Mbarek-Yz/LibraryKmm.git")
            credentials {
                username = "Mbarek-Yz"
                password = System.getenv("GITHUB_TOKEN")
            }
        }

    }
}
