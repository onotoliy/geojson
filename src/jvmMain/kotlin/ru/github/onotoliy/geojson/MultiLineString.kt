package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiLineStringJsonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiLineStringJsonSerializer

@JsonSerialize(using = MultiLineStringJsonSerializer::class)
@JsonDeserialize(using = MultiLineStringJsonDeserializer::class)
actual class MultiLineString actual constructor(actual override val coordinates: Ring) : Geometry(coordinates)