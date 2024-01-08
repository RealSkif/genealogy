import org.jetbrains.kotlin.noarg.gradle.NoArgExtension
import org.springframework.boot.gradle.tasks.run.BootRun

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
    annotation("jakarta.persistence.Entity")
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
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
//    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0-M1")


    implementation("com.querydsl:querydsl-apt:${property("queryDslVersion")}:jakarta")
    implementation("com.querydsl:querydsl-core:${property("queryDslVersion")}")
    implementation("com.querydsl:querydsl-jpa:${property("queryDslVersion")}:jakarta")

    implementation("com.vladmihalcea:hibernate-types-60:${property("hibernateTypesVersion")}")
    implementation("com.github.alexliesenfeld:querydsl-jpa-postgres-json:${property("querydslJpaPostgresJsonVersion")}")
    implementation("org.postgresql:postgresql:${property("postgresVersion")}")
    implementation("org.hibernate:hibernate-core:${property("hibernateCoreVersion")}")
    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:${property("p6spyVersion")}")

    kapt("com.querydsl:querydsl-apt:${property("queryDslVersion")}:jakarta")


    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

val sourcesJar by tasks.registering(Jar::class) {
    dependsOn(JavaPlugin.CLASSES_TASK_NAME)
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}

tasks.named<BootRun>("bootRun") {
    if (project.hasProperty("profiles")) {
        args = listOf("--spring.profiles.active=" + project.property("profiles"))
    }
}

