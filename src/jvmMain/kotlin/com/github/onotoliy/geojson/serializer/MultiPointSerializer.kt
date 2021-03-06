package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.onotoliy.geojson.MultiPoint
import com.github.onotoliy.geojson.fromJson
import com.github.onotoliy.geojson.serializers.stringify
import com.github.onotoliy.geojson.serializers.toMultiPoint

/**
 * Jackson сериализация [MultiPoint].
 *
 * @author Anatoliy Pokhresnyi
 */
class MultiPointJacksonSerializer : JsonSerializer<MultiPoint>() {
    override fun serialize(value: MultiPoint, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [MultiPoint].
 *
 * @author Anatoliy Pokhresnyi
 */
class MultiPointJacksonDeserializer : JsonDeserializer<MultiPoint>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiPoint =
        p.fromJson(String::toMultiPoint)
}
