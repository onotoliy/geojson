package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.Polygon
import ru.github.onotoliy.geojson.Ring
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toPolygon
import ru.github.onotoliy.geojson.serializers.toRing

class RingJsonDeserializer: JsonDeserializer<Ring>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Ring
            = p.fromJson(String::toRing)
}