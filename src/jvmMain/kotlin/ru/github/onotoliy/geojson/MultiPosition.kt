package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiPositionJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiPositionJacksonSerializer

@JsonSerialize(using = MultiPositionJacksonSerializer::class)
@JsonDeserialize(using = MultiPositionJacksonDeserializer::class)
actual class MultiPosition actual constructor(actual val coordinates: List<Position>) :
    AbstractGeoJsonCoordinate<Position>(coordinates), GeometryCoordinate