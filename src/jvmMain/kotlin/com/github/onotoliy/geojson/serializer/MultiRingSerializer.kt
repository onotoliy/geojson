package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.onotoliy.geojson.MultiRing
import com.github.onotoliy.geojson.fromJson
import com.github.onotoliy.geojson.serializers.stringify
import com.github.onotoliy.geojson.serializers.toMultiRing

/**
 * Jackson сериализация [MultiRing].
 *
 * @author Anatoliy Pokhresnyi
 */
class MultiRingJacksonSerializer : JsonSerializer<MultiRing>() {
    override fun serialize(value: MultiRing, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [MultiRing].
 *
 * @author Anatoliy Pokhresnyi
 */
class MultiRingJacksonDeserializer : JsonDeserializer<MultiRing>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiRing =
        p.fromJson(String::toMultiRing)
}
