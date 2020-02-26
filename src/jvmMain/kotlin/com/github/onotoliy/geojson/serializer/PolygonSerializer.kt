package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.onotoliy.geojson.Polygon
import com.github.onotoliy.geojson.fromJson
import com.github.onotoliy.geojson.serializers.stringify
import com.github.onotoliy.geojson.serializers.toPolygon

/**
 * Jackson сериализация [Polygon].
 *
 * @author Anatoliy Pokhresnyi
 */
class PolygonJacksonSerializer : JsonSerializer<Polygon>() {
    override fun serialize(value: Polygon, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [Polygon].
 *
 * @author Anatoliy Pokhresnyi
 */
class PolygonJacksonDeserializer : JsonDeserializer<Polygon>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Polygon =
        p.fromJson(String::toPolygon)
}
