package ru.github.onotoliy.geojson

/**
 * GeometryCollection Object.
 *
 * @property geometries Geometries.
 * @author Anatoliy Pokhresnyi
 */
expect class GeometryCollection(geometries: MultiGeometry) : GeoJsonObject<MultiGeometry> {

    /**
     * Geometries.
     */
    val geometries: MultiGeometry
}