import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.gradle.api.tasks.wrapper.Wrapper

plugins {
    base
    id("org.springframework.boot") version "3.2.0" apply false
    id("io.spring.dependency-management") version "1.1.4" apply false
    kotlin("jvm") version "1.9.20" apply false
    kotlin("plugin.spring") version "1.9.20" apply false
    kotlin("plugin.jpa") version "1.9.20" apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "io.spring.dependency-management")

    the<DependencyManagementExtension>()
        .apply {
            imports {
                mavenBom(SpringBootPlugin.BOM_COORDINATES)
            }
        }
//    val implementation by configurations
//
//    dependencies {
//        implementation(subprojects)
//    }
//    tasks.withType<KotlinCompile> {
//        kotlinOptions {
//            jvmTarget = "1.8" // Adjust to your desired JVM version
//            freeCompilerArgs = listOf("-Xjsr305=strict")
//        }
//    }
    tasks.withType<KotlinCompile>()
        .configureEach {
            kotlinOptions {
                jvmTarget = "21"
                freeCompilerArgs = listOf("-Xjsr305=strict")
            }
        }

}



tasks.withType<Wrapper> {
    gradleVersion = "8.5"
}