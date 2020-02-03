package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.Polygon
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toPolygon

class PolygonJsonDeserializer: JsonDeserializer<Polygon>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Polygon
            = p.fromJson(String::toPolygon)
}