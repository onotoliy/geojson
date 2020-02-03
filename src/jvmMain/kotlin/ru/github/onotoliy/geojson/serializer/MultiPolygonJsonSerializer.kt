package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.github.onotoliy.geojson.MultiPolygon
import ru.github.onotoliy.geojson.serializers.stringify

class MultiPolygonJsonSerializer : JsonSerializer<MultiPolygon>() {
    override fun serialize(value: MultiPolygon, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}
