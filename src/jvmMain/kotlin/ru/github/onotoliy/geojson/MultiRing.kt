package ru.github.onotoliy.geojson

actual class MultiRing actual constructor(actual val coordinates: List<Ring>) :
    GeometryCoordinateTyped<Ring>(coordinates)