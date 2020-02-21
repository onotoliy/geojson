package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.RingJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.RingJacksonSerializer

@JsonSerialize(using = RingJacksonSerializer::class)
@JsonDeserialize(using = RingJacksonDeserializer::class)
actual class Ring actual constructor(actual val coordinates: List<MultiPosition>) :
    AbstractGeoJsonCoordinate<MultiPosition>(coordinates), GeometryCoordinate
