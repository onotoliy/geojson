package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.Point
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.stringify
import ru.github.onotoliy.geojson.serializers.toPoint

@JsonSerialize(`as` = Point::class, using = PointJacksonSerializer::class)
class PointJacksonSerializer : JsonSerializer<Point>() {
    override fun serialize(value: Point, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

@JsonDeserialize(`as` = Point::class, using = PointJacksonDeserializer::class)
class PointJacksonDeserializer: JsonDeserializer<Point>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Point =
        p.fromJson(String::toPoint)
}