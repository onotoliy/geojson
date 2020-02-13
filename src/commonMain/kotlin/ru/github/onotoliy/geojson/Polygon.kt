package ru.github.onotoliy.geojson

/**
 * Объект Polygon.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class Polygon(coordinates: Ring) : Geometry {
    override val coordinates: Ring
}
