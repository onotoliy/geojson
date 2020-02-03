package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiPointJsonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiPointJsonSerializer

@JsonSerialize(using = MultiPointJsonSerializer::class)
@JsonDeserialize(using = MultiPointJsonDeserializer::class)
actual class MultiPoint actual constructor(actual override val coordinates: MultiPosition) : Geometry(coordinates)