package ru.github.onotoliy.geojson

/**
 * an array of LineString or linear ring (see Section 3.1.6)
coordinates in the case of a Polygon or MultiLineString geometry,
or





 */

actual class Ring actual constructor(actual val coordinates: List<MultiPosition>) :
    AbstractGeometryCoordinate<MultiPosition>(coordinates)