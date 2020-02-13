package ru.github.onotoliy.geojson

/**
 * Координаты одной точки. Используется для геометрии типа [Point].
 *
 * @property x Широта.
 * @property y Долгота.
 * @author Anatoliy Pokhresnyi
 */
expect open class Position(x: Double, y: Double) : AbstractPosition, GeometryCoordinate {
    val x: Double
    val y: Double
}