package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.github.onotoliy.geojson.MultiLineString
import ru.github.onotoliy.geojson.MultiPoint
import ru.github.onotoliy.geojson.serializers.stringify

class MultiLineStringJsonSerializer : JsonSerializer<MultiLineString>() {
    override fun serialize(value: MultiLineString, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}
