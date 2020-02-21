package ru.github.onotoliy.geojson

/**
 * Объект LineString.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
actual class LineString actual constructor(actual override val coordinates: MultiPosition) : Geometry(coordinates)
