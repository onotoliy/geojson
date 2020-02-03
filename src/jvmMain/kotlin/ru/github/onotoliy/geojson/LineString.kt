package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.LineStringJsonDeserializer
import ru.github.onotoliy.geojson.serializer.LineStringJsonSerializer

@JsonSerialize(using = LineStringJsonSerializer::class)
@JsonDeserialize(using = LineStringJsonDeserializer::class)
actual class LineString actual constructor(actual override val coordinates: MultiPosition) : Geometry(coordinates)