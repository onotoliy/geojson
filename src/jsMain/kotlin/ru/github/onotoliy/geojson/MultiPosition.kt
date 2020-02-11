package ru.github.onotoliy.geojson

actual class MultiPosition actual constructor(actual val coordinates: List<Position>) :
    GeometryCoordinateCommon<Position>(coordinates)