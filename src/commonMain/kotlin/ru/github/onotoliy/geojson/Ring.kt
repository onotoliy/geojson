package ru.github.onotoliy.geojson

expect class Ring(coordinates: List<MultiPosition>) : GeometryCoordinateTyped<MultiPosition> {
    val coordinates: List<MultiPosition>
}