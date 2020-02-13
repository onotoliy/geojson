package ru.github.onotoliy.geojson

/**
 * Объект Point.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class Point(coordinates: Position) : Geometry {
    override val coordinates: Position
}