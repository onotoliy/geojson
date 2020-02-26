package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.onotoliy.geojson.Ring
import com.github.onotoliy.geojson.fromJson
import com.github.onotoliy.geojson.serializers.stringify
import com.github.onotoliy.geojson.serializers.toRing

/**
 * Jackson сериализация [Ring].
 *
 * @author Anatoliy Pokhresnyi
 */
class RingJacksonSerializer : JsonSerializer<Ring>() {
    override fun serialize(value: Ring, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [Ring].
 *
 * @author Anatoliy Pokhresnyi
 */
class RingJacksonDeserializer : JsonDeserializer<Ring>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Ring =
        p.fromJson(String::toRing)
}
