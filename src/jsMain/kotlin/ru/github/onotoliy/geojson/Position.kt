package ru.github.onotoliy.geojson

/**
 * Координаты одной точки. Используется для геометрии типа [Point].
 *
 * @property x Широта.
 * @property y Долгота.
 * @author Anatoliy Pokhresnyi
 */
actual open class Position actual constructor(actual val x: Double, actual val y: Double) :
    AbstractPosition(x, y), GeometryCoordinate