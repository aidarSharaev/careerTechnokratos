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
include(":login_feature_api")
include(":login_feature_impl")
include(":menu_feature_api")
include(":menu_feature_impl")
include(":apods_feature_api")
include(":apods_feature_impl")
include(":apa_feature_impl")
include(":apa_feature_api")
include(":educationMenu_feature_impl")
include(":spaceOverflow_feature_api")
include(":horoscope_feature_impl")
include(":horoscope_feature_api")
include(":signin_feature_impl")
include(":signin_feature_api")
include(":chart_feature_impl")
include(":chart_feature_api")
include(":educationMenu_feature_api")
include(":common")
include(":educationMenu_feature_impl")
include(":spaceOverflow_feature_impl")
