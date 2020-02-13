package ru.github.onotoliy.geojson

/**
 * Список координат. Используется для геометрии типа [MultiPolygon].
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class MultiRing(coordinates: List<Ring>) : AbstractGeometryCoordinate<Ring> {

    val coordinates: List<Ring>
}