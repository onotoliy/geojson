package ru.github.onotoliy.geojson

/**
 * Объект MultiPoint.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
actual class MultiPoint actual constructor(actual override val coordinates: MultiPosition) : Geometry(coordinates)