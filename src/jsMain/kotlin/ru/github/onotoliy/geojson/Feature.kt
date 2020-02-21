package ru.github.onotoliy.geojson

/**
 * Объект Feature.
 *
 * @property geometry Геометрия.
 * @author Anatoliy Pokhresnyi
 */
actual class Feature actual constructor(geometry: Geometry) : GeoJsonObject<Geometry>(geometry) {

    /**
     * Геометрия.
     */
    actual val geometry: Geometry
        get() = value
}
