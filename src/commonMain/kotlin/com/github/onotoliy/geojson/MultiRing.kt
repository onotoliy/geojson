package com.github.onotoliy.geojson

/**
 * Список координат. Используется для геометрии типа [MultiPolygon].
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class MultiRing(coordinates: List<Ring>) : AbstractGeoJsonCoordinate<Ring>, GeometryCoordinate {

    /**
     * Координаты.
     */
    val coordinates: List<Ring>
}
