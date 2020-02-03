package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.github.onotoliy.geojson.Geometry
import ru.github.onotoliy.geojson.Point
import ru.github.onotoliy.geojson.Polygon
import ru.github.onotoliy.geojson.Ring
import ru.github.onotoliy.geojson.serializers.stringify

class PolygonJsonSerializer : JsonSerializer<Polygon>() {
    override fun serialize(value: Polygon, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}