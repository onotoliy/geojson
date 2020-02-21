package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiPointJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiPointJacksonSerializer

@JsonSerialize(using = MultiPointJacksonSerializer::class)
@JsonDeserialize(using = MultiPointJacksonDeserializer::class)
actual class MultiPoint actual constructor(actual override val coordinates: MultiPosition) : Geometry(coordinates)