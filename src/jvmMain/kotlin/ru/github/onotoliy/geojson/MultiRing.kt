package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiRingJsonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiRingJsonSerializer

@JsonSerialize(using = MultiRingJsonSerializer::class)
@JsonDeserialize(using = MultiRingJsonDeserializer::class)
actual class MultiRing actual constructor(actual val coordinates: List<Ring>) :
    GeometryCoordinateTyped<Ring>(coordinates)