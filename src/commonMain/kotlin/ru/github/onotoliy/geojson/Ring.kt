package ru.github.onotoliy.geojson

/**
 * Список координат. Используется для геометрий типа [Polygon] или [MultiLineString].
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class Ring(coordinates: List<MultiPosition>) : AbstractGeoJsonCoordinate<MultiPosition>, GeometryCoordinate {

    /**
     * Координаты.
     */
    val coordinates: List<MultiPosition>
}