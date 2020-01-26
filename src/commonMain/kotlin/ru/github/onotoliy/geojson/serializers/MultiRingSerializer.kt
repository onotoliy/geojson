package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiRing
import ru.github.onotoliy.geojson.Ring

object MultiRingSerializer : GeoJsonCoordinateSerializer<MultiRing, Ring>(
    "MultiRing", MultiRing::coordinates, RingSerializer, ::MultiRing
)