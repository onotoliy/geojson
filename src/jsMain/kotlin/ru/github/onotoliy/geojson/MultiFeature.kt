package ru.github.onotoliy.geojson

actual class MultiFeature actual constructor(actual val coordinates: List<Feature>) :
    AbstractGeoJsonCoordinate<Feature>(coordinates)