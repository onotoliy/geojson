package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.RingJsonDeserializer
import ru.github.onotoliy.geojson.serializer.RingJsonSerializer

@JsonSerialize(using = RingJsonSerializer::class)
@JsonDeserialize(using = RingJsonDeserializer::class)
actual class Ring actual constructor(actual val coordinates: List<MultiPosition>) :
    GeometryCoordinateCommon<MultiPosition>(coordinates)