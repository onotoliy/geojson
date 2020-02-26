package com.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.github.onotoliy.geojson.serializer.MultiRingJacksonDeserializer
import com.github.onotoliy.geojson.serializer.MultiRingJacksonSerializer

/**
 * Список координат. Используется для геометрии типа [MultiPolygon].
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = MultiRingJacksonSerializer::class)
@JsonDeserialize(using = MultiRingJacksonDeserializer::class)
actual class MultiRing actual constructor(actual val coordinates: List<Ring>) :
    AbstractGeoJsonCoordinate<Ring>(coordinates), GeometryCoordinate
