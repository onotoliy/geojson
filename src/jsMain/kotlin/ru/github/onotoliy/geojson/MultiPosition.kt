package ru.github.onotoliy.geojson

/**
 * Список координат. Используется для геометрий типа [MultiPoint] или [LineString].
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
actual class MultiPosition actual constructor(actual val coordinates: List<Position>) :
    AbstractGeoJsonCoordinate<Position>(coordinates), GeometryCoordinate