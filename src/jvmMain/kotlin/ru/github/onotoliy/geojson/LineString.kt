package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.LineStringJacksonSerializer
import ru.github.onotoliy.geojson.serializer.LineStringJsonDeserializer

/**
 * Объект LineString.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = LineStringJacksonSerializer::class)
@JsonDeserialize(using = LineStringJsonDeserializer::class)
actual class LineString actual constructor(actual override val coordinates: MultiPosition) : Geometry(coordinates)
