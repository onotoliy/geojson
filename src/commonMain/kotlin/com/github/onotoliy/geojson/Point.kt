package com.github.onotoliy.geojson

/**
 * Объект Point.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class Point(coordinates: Position) : Geometry {

    /**
     * Координаты.
     */
    override val coordinates: Position
}
