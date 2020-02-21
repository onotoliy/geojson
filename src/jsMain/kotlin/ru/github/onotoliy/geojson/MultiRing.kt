package ru.github.onotoliy.geojson

/**
 * Список координат. Используется для геометрии типа [MultiPolygon].
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
actual class MultiRing actual constructor(actual val coordinates: List<Ring>) :
    AbstractGeoJsonCoordinate<Ring>(coordinates), GeometryCoordinate
