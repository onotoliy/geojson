package ru.github.onotoliy.geojson

/**
 * Объект MultiLineString.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class MultiLineString(coordinates: Ring) : Geometry {

    /**
     * Координаты.
     */
    override val coordinates: Ring
}