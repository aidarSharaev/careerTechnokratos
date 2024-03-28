package ru.aidar.apa_feature_api.utils

import ru.aidar.apa_feature_api.remote.ApaLocal
import ru.aidar.apa_feature_api.remote.Mass
import ru.aidar.apa_feature_api.remote.Moon
import ru.aidar.apa_feature_api.remote.Vol

object Constants {
    val Earth =
        ApaLocal(
            id = "terre",
            name = "Earth",
            isPlanet = true,
            moons =
                listOf(
                    Moon(
                        moon = "La Lune",
                        rel = "https://api.le-systeme-solaire.net/rest/bodies/lune",
                    ),
                ),
            mass = Mass(massValue = 5.97237, massExponent = 24),
            vol = Vol(volValue = 1.08321, volExponent = 12),
            discoveredBy = null,
            discoveryDate = null,
        )

    val Venus =
        ApaLocal(
            id = "venus",
            name = "Venus",
            isPlanet = true,
            moons = null,
            mass = Mass(massValue = 4.86747, massExponent = 24),
            vol = Vol(volValue = 9.28430, volExponent = 11),
            discoveredBy = null,
            discoveryDate = null,
        )

    val Mars =
        ApaLocal(
            id = "mars",
            name = "Mars",
            isPlanet = true,
            moons =
                listOf(
                    Moon(
                        moon = "Phobos",
                        rel = "https://api.le-systeme-solaire.net/rest/bodies/phobos",
                    ),
                    Moon(
                        moon = "Deïmos",
                        rel = "https://api.le-systeme-solaire.net/rest/bodies/deimos",
                    ),
                ),
            mass = Mass(massValue = 6.41712, massExponent = 23),
            vol = Vol(volValue = 1.63180, volExponent = 11),
            discoveredBy = null,
            discoveryDate = null,
        )
}
