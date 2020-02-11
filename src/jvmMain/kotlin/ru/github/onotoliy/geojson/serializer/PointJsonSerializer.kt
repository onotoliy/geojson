package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.Point
import ru.github.onotoliy.geojson.serializers.stringify

@JsonSerialize(`as` = Point::class, using = PointJsonSerializer::class)
class PointJsonSerializer : JsonSerializer<Point>() {
    override fun serialize(value: Point, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}