package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.github.onotoliy.geojson.*
import ru.github.onotoliy.geojson.serializers.stringify

class MultiFeatureJsonSerializer : JsonSerializer<MultiFeature>() {
    override fun serialize(value: MultiFeature, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}