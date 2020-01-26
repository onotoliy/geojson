package ru.github.onotoliy.geojson

expect class MultiPosition(coordinates: List<Position>) : GeometryCoordinateTyped<Position> {
    val coordinates: List<Position>
}