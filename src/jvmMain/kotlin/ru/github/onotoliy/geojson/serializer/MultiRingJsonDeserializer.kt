package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.MultiRing
import ru.github.onotoliy.geojson.Polygon
import ru.github.onotoliy.geojson.Ring
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toMultiRing
import ru.github.onotoliy.geojson.serializers.toPolygon
import ru.github.onotoliy.geojson.serializers.toRing

class MultiRingJsonDeserializer: JsonDeserializer<MultiRing>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiRing
            = p.fromJson(String::toMultiRing)
}