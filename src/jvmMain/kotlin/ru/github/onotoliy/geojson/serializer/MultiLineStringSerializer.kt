package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.github.onotoliy.geojson.MultiLineString
import ru.github.onotoliy.geojson.MultiPoint
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.stringify
import ru.github.onotoliy.geojson.serializers.toMultiLineString

class MultiLineStringJacksonSerializer : JsonSerializer<MultiLineString>() {
    override fun serialize(value: MultiLineString, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

class MultiLineStringJacksonDeserializer : JsonDeserializer<MultiLineString>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiLineString =
        p.fromJson(String::toMultiLineString)
}
