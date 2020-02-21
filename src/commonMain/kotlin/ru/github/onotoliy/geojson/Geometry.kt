package ru.github.onotoliy.geojson

/**
 * Геометрия.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
open class Geometry(open val coordinates: GeometryCoordinate) : GeoJsonObject<GeometryCoordinate>(coordinates)
