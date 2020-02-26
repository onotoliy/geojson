package com.github.onotoliy.geojson

/**
 * Объект Polygon.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class Polygon(coordinates: Ring) : Geometry {

    /**
     * Координаты.
     */
    override val coordinates: Ring
}
