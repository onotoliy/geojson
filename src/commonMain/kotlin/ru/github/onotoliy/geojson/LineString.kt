package ru.github.onotoliy.geojson

/**
 * Объект LineString.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
expect class LineString(coordinates: MultiPosition) : Geometry {

    /**
     * Координаты.
     */
    override val coordinates: MultiPosition
}