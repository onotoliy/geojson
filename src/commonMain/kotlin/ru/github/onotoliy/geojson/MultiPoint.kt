package ru.github.onotoliy.geojson

/**
 * Объект MultiPoint.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class MultiPoint(coordinates: MultiPosition) : Geometry {

    /**
     * Координаты.
     */
    override val coordinates: MultiPosition
}