package ru.github.onotoliy.geojson

/**
 * Feature Object.
 *
 * @property geometry Geometry.
 * @author Anatoliy Pokhresnyi
 */
expect class Feature constructor(geometry: Geometry) : GeoJsonObject<Geometry> {

    /**
     * Geometry.
     */
    val geometry: Geometry
}