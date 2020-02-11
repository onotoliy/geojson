package ru.github.onotoliy.geojson

expect class MultiPosition(coordinates: List<Position>) : GeometryCoordinateCommon<Position> {
    val coordinates: List<Position>
}