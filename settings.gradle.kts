pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CareerTechnokratos"
include(":app")
include(":menu_feature_api")
include(":menu_feature_impl")
include(":apods_feature_api")
include(":apods_feature_impl")
include(":apa_feature_impl")
include(":apa_feature_api")
include(":so_feature_api")
include(":cc_feature_impl")
include(":cc_feature_api")
include(":auth_feature_impl")
include(":auth_feature_api")
include(":common")
include(":so_feature_impl")
