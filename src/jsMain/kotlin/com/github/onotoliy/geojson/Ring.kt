package com.github.onotoliy.geojson

/**
 * Список координат. Используется для геометрий типа [Polygon] или [MultiLineString].
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
actual class Ring actual constructor(actual val coordinates: List<MultiPosition>) :
    AbstractGeoJsonCoordinate<MultiPosition>(coordinates), GeometryCoordinate
