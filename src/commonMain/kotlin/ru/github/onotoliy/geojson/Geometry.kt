package ru.github.onotoliy.geojson

/**
 * Geometry.
 *
 * @property coordinates Coordinates.
 * @author Anatoliy Pokhresnyi
 */
open class Geometry(open val coordinates: GeometryCoordinate) : GeoJsonObject<GeometryCoordinate>(coordinates)