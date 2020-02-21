package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.github.onotoliy.geojson.MultiGeometry
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.stringify
import ru.github.onotoliy.geojson.serializers.toMultiGeometry

class MultiGeometryJacksonSerializer : JsonSerializer<MultiGeometry>() {
    override fun serialize(value: MultiGeometry, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

class MultiGeometryJacksonDeserializer : JsonDeserializer<MultiGeometry>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiGeometry =
        p.fromJson(String::toMultiGeometry)
}
