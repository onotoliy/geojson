package ru.github.onotoliy.geojson

/**
 * Объект MultiPolygon.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class MultiPolygon(coordinates: MultiRing) : Geometry {

    /**
     * Координаты.
     */
    override val coordinates: MultiRing
}