package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import ru.github.onotoliy.geojson.Point
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toPoint

@JsonDeserialize(`as` = Point::class, using = PointJsonDeserializer::class)
class PointJsonDeserializer: JsonDeserializer<Point>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Point = p.fromJson(String::toPoint)
}