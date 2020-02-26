package com.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.github.onotoliy.geojson.serializer.MultiPointJacksonDeserializer
import com.github.onotoliy.geojson.serializer.MultiPointJacksonSerializer

/**
 * Объект MultiPoint.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = MultiPointJacksonSerializer::class)
@JsonDeserialize(using = MultiPointJacksonDeserializer::class)
actual class MultiPoint actual constructor(actual override val coordinates: MultiPosition) : Geometry(coordinates)
