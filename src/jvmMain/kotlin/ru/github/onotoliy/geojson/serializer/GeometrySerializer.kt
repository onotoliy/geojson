package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.github.onotoliy.geojson.Geometry
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.stringify
import ru.github.onotoliy.geojson.serializers.toGeometry

class GeometryJacksonSerializer : JsonSerializer<Geometry>() {
    override fun serialize(value: Geometry, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

class GeometryJacksonDeserializer : JsonDeserializer<Geometry>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Geometry =
        p.fromJson(String::toGeometry)
}
