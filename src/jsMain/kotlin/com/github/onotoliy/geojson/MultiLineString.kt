package com.github.onotoliy.geojson

/**
 * Объект MultiLineString.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
actual class MultiLineString actual constructor(actual override val coordinates: Ring) : Geometry(coordinates)
