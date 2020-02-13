package ru.github.onotoliy.geojson

/**
 * Список координат. Используется для геометрий типа [Polygon] или [MultiLineString].
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class Ring(coordinates: List<MultiPosition>) : AbstractGeometryCoordinate<MultiPosition> {
    val coordinates: List<MultiPosition>
}