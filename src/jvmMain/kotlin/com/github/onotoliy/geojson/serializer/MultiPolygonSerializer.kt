package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.onotoliy.geojson.MultiPolygon
import com.github.onotoliy.geojson.fromJson
import com.github.onotoliy.geojson.serializers.stringify
import com.github.onotoliy.geojson.serializers.toMultiPolygon

/**
 * Jackson сериализация [MultiPolygon].
 *
 * @author Anatoliy Pokhresnyi
 */
class MultiPolygonJacksonSerializer : JsonSerializer<MultiPolygon>() {
    override fun serialize(value: MultiPolygon, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [MultiPolygon].
 *
 * @author Anatoliy Pokhresnyi
 */
class MultiPolygonJacksonDeserializer : JsonDeserializer<MultiPolygon>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiPolygon =
        p.fromJson(String::toMultiPolygon)
}
