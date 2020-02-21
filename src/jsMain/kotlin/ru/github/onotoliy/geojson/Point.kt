package ru.github.onotoliy.geojson

/**
 * Объект Point.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
actual class Point actual constructor(actual override val coordinates: Position) : Geometry(coordinates)
