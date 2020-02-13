package ru.github.onotoliy.geojson

/**
 * Списк геометрий. Используется для геометрии типа [GeometryCollection].
 *
 * @property coordinates Список геометрий.
 * @author Anatoliy Pokhresnyi
 */
expect class MultiGeometry(coordinates: List<Geometry>) : AbstractMultiGeometry, GeometryCoordinate {
    val coordinates: List<Geometry>
}