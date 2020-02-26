package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.onotoliy.geojson.LineString
import com.github.onotoliy.geojson.fromJson
import com.github.onotoliy.geojson.serializers.stringify
import com.github.onotoliy.geojson.serializers.toLineString

/**
 * Jackson сериализация [LineString].
 *
 * @author Anatoliy Pokhresnyi
 */
class LineStringJacksonSerializer : JsonSerializer<LineString>() {
    override fun serialize(value: LineString, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [LineString].
 *
 * @author Anatoliy Pokhresnyi
 */
class LineStringJsonDeserializer : JsonDeserializer<LineString>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): LineString =
        p.fromJson(String::toLineString)
}
