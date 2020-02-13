package ru.github.onotoliy.geojson

/**
 * Объект Feature.
 *
 * @property geometry Геометрия.
 * @author Anatoliy Pokhresnyi
 */
expect class Feature constructor(geometry: Geometry) : GeoJsonObject<Geometry> {

    /**
     * Геометрия.
     */
    val geometry: Geometry
}