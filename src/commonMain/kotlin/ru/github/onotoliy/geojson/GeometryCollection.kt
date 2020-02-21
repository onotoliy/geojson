package ru.github.onotoliy.geojson

/**
 * Объект GeometryCollection.
 *
 * @property geometries Список геометрий.
 * @author Anatoliy Pokhresnyi
 */
expect class GeometryCollection(geometries: MultiGeometry) : GeoJsonObject<MultiGeometry> {

    /**
     * Список геометрий.
     */
    val geometries: MultiGeometry
}
