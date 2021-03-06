package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.onotoliy.geojson.GeometryCollection
import com.github.onotoliy.geojson.fromJson
import com.github.onotoliy.geojson.serializers.stringify
import com.github.onotoliy.geojson.serializers.toGeometryCollection

/**
 * Jackson сериализация [GeometryCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
class GeometryCollectionJacksonSerializer : JsonSerializer<GeometryCollection>() {
    override fun serialize(value: GeometryCollection, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [GeometryCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
class GeometryCollectionJacksonDeserializer : JsonDeserializer<GeometryCollection>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): GeometryCollection =
        p.fromJson(String::toGeometryCollection)
}
