package ru.github.onotoliy.geojson

/**
 * Объект MultiPolygon.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
actual class MultiPolygon actual constructor(actual override val coordinates: MultiRing) : Geometry(coordinates)