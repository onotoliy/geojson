package ru.github.onotoliy.geojson

actual class Ring actual constructor(actual val coordinates: List<MultiPosition>) :
    GeometryCoordinateTyped<MultiPosition>(coordinates)