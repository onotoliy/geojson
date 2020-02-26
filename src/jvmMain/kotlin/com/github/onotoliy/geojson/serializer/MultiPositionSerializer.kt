package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.onotoliy.geojson.MultiPosition
import com.github.onotoliy.geojson.fromJson
import com.github.onotoliy.geojson.serializers.stringify
import com.github.onotoliy.geojson.serializers.toMultiPosition

/**
 * Jackson сериализация [MultiPosition].
 *
 * @author Anatoliy Pokhresnyi
 */
class MultiPositionJacksonSerializer : JsonSerializer<MultiPosition>() {
    override fun serialize(value: MultiPosition, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [MultiPosition].
 *
 * @author Anatoliy Pokhresnyi
 */
class MultiPositionJacksonDeserializer : JsonDeserializer<MultiPosition>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiPosition =
        p.fromJson(String::toMultiPosition)
}
