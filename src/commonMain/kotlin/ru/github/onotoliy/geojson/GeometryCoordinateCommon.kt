package ru.github.onotoliy.geojson

/**
 * Common Geometry coordinate. Override methods [toString], [hashCode], [equals].
 *
 * @property values Coordinates
 * @author Anatoliy Pokhresnyi
 */
open class GeometryCoordinateCommon<T>(values: List<T>) : GeoJsonCoordinateCommon<T>(values), GeometryCoordinate