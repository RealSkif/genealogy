group = "genealogy"
plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":genealogy-domain"))

    implementation("org.springdoc:springdoc-openapi-ui:${property("openapiVersion")}")
    implementation("org.springdoc:springdoc-openapi-kotlin:${property("openapiVersion")}")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}