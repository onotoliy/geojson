package ru.github.onotoliy.geojson

open class Geometry(open val coordinates: GeometryCoordinate) : GeoJsonObject<GeometryCoordinate>(coordinates)