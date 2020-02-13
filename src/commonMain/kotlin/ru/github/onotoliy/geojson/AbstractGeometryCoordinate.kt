package ru.github.onotoliy.geojson

/**
 * Базовый абстрактный класс координат геометрии.
 *
 * @property values Координаты геометрии.
 * @author Anatoliy Pokhresnyi
 */
abstract class AbstractGeometryCoordinate<T>(values: List<T>) : AbstractGeoJsonCoordinate<T>(values), GeometryCoordinate