package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.onotoliy.geojson.Position
import com.github.onotoliy.geojson.fromJson
import com.github.onotoliy.geojson.serializers.stringify
import com.github.onotoliy.geojson.serializers.toPosition

/**
 * Jackson сериализация [Position].
 *
 * @author Anatoliy Pokhresnyi
 */
class PositionJacksonSerializer : JsonSerializer<Position>() {
    override fun serialize(value: Position, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [Position].
 *
 * @author Anatoliy Pokhresnyi
 */
class PositionJacksonDeserializer : JsonDeserializer<Position>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Position =
        p.fromJson(String::toPosition)
}
