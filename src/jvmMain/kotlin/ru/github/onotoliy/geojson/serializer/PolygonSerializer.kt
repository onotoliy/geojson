package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.github.onotoliy.geojson.Polygon
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.stringify
import ru.github.onotoliy.geojson.serializers.toPolygon

class PolygonJacksonSerializer : JsonSerializer<Polygon>() {
    override fun serialize(value: Polygon, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

class PolygonJacksonDeserializer : JsonDeserializer<Polygon>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Polygon =
        p.fromJson(String::toPolygon)
}
