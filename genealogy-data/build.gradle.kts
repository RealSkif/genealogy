import org.jetbrains.kotlin.noarg.gradle.NoArgExtension
group = "genealogy"

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    kotlin("plugin.allopen")
//    kotlin("kapt")
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

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("javax.persistence:javax.persistence-api:2.2")

    implementation("com.querydsl:querydsl-apt:${property("queryDslVersion")}:jpa")
    implementation("com.querydsl:querydsl-core:${property("queryDslVersion")}")
    implementation("com.querydsl:querydsl-jpa:${property("queryDslVersion")}")



    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

