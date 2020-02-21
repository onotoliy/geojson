package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.github.onotoliy.geojson.*
import ru.github.onotoliy.geojson.serializers.stringify
import ru.github.onotoliy.geojson.serializers.toPosition

class PositionJacksonSerializer : JsonSerializer<Position>() {
    override fun serialize(value: Position, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

class PositionJacksonDeserializer : JsonDeserializer<Position>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Position =
        p.fromJson(String::toPosition)
}