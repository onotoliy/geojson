package ru.github.onotoliy.geojson

/**
 * Объект Polygon.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
actual class Polygon actual constructor(actual override val coordinates: Ring) : Geometry(coordinates)