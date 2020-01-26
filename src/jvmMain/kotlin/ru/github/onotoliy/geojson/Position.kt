package ru.github.onotoliy.geojson

actual open class Position actual constructor(actual val x: Double, actual val y: Double) : PositionTyped(x, y),
    GeometryCoordinate