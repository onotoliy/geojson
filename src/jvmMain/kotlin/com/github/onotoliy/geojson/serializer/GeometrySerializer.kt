package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.onotoliy.geojson.Geometry
import com.github.onotoliy.geojson.fromJson
import com.github.onotoliy.geojson.serializers.stringify
import com.github.onotoliy.geojson.serializers.toGeometry

/**
 * Jackson сериализация [Geometry].
 *
 * @author Anatoliy Pokhresnyi
 */
class GeometryJacksonSerializer : JsonSerializer<Geometry>() {
    override fun serialize(value: Geometry, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [Geometry].
 *
 * @author Anatoliy Pokhresnyi
 */
class GeometryJacksonDeserializer : JsonDeserializer<Geometry>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Geometry =
        p.fromJson(String::toGeometry)
}
