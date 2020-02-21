package ru.github.onotoliy.geojson

/**
 * Объект GeometryCollection.
 *
 * @property geometries Список геометрий.
 * @author Anatoliy Pokhresnyi
 */
actual class GeometryCollection actual constructor(geometries: MultiGeometry) :
    GeoJsonObject<MultiGeometry>(geometries) {

    /**
     * Список геометрий.
     */
    actual val geometries: MultiGeometry
        get() = value
}
