import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.noarg.gradle.NoArgExtension
import org.springframework.boot.gradle.tasks.run.BootRun
import java.io.PrintWriter

base.archivesBaseName = "genealogy"
group = "genealogy"

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    kotlin("kapt")

}

configure<NoArgExtension> {
    annotation("javax.persistence.Entity")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
}
dependencies {
    implementation(project(":genealogy-domain"))
    implementation(project(":genealogy-data"))
    implementation(project(":genealogy-web"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

//val sourcesJar by tasks.registering(Jar::class) {
//    dependsOn(JavaPlugin.CLASSES_TASK_NAME)
//    archiveClassifier.set("sources")
//    from(sourceSets["main"].allSource)
//}
//
//artifacts {
//    add("archives", sourcesJar)
//}
tasks.named<BootRun>("bootRun") {
    if (project.hasProperty("profiles")) {
        args = listOf("--spring.profiles.active=" + project.property("profiles"))
    }
}

tasks.withType<ProcessResources> {
    doLast {
        val file = File("$buildDir/resources/main/build.properties")
        file.createNewFile()
        file.printWriter()
            .use { out: PrintWriter ->
                out.println("group=${project.group}")
                out.println("name=${project.name}")
                out.println("version=${project.version}")
            }
    }
}

