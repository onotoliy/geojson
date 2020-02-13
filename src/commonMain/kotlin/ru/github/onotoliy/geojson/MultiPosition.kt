package ru.github.onotoliy.geojson

/**
 * Список координат. Используется для геометрий типа [MultiPoint] или [LineString].
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class MultiPosition(coordinates: List<Position>) : AbstractGeometryCoordinate<Position> {

    /**
     * Координаты.
     */
    val coordinates: List<Position>
}