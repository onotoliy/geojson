package ru.github.onotoliy.geojson

/**
 * Списк геометрий. Используется для геометрии типа [GeometryCollection].
 *
 * @property coordinates Список геометрий.
 * @author Anatoliy Pokhresnyi
 */
actual class MultiGeometry actual constructor(actual val coordinates: List<Geometry>) :
    AbstractGeoJsonCoordinate<Geometry>(coordinates), GeometryCoordinate
