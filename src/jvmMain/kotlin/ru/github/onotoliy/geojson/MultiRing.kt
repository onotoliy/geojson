package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiRingJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiRingJacksonSerializer

@JsonSerialize(using = MultiRingJacksonSerializer::class)
@JsonDeserialize(using = MultiRingJacksonDeserializer::class)
actual class MultiRing actual constructor(actual val coordinates: List<Ring>) :
    AbstractGeoJsonCoordinate<Ring>(coordinates), GeometryCoordinate
