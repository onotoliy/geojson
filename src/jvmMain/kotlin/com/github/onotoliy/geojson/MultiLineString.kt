package com.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.github.onotoliy.geojson.serializer.MultiLineStringJacksonDeserializer
import com.github.onotoliy.geojson.serializer.MultiLineStringJacksonSerializer

/**
 * Объект MultiLineString.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = MultiLineStringJacksonSerializer::class)
@JsonDeserialize(using = MultiLineStringJacksonDeserializer::class)
actual class MultiLineString actual constructor(actual override val coordinates: Ring) : Geometry(coordinates)
