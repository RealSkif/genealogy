rootProject.name = "genealogy"


include(
        "genealogy-api",
        "genealogy-domain",
        "genealogy-data",
        "genealogy-web"
)

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}