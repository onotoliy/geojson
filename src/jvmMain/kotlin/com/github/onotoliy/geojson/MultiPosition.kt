package com.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.github.onotoliy.geojson.serializer.MultiPositionJacksonDeserializer
import com.github.onotoliy.geojson.serializer.MultiPositionJacksonSerializer

/**
 * Список координат. Используется для геометрий типа [MultiPoint] или [LineString].
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = MultiPositionJacksonSerializer::class)
@JsonDeserialize(using = MultiPositionJacksonDeserializer::class)
actual class MultiPosition actual constructor(actual val coordinates: List<Position>) :
    AbstractGeoJsonCoordinate<Position>(coordinates), GeometryCoordinate
