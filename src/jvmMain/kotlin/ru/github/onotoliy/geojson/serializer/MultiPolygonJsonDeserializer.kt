package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.MultiPolygon
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toMultiPolygon

class MultiPolygonJsonDeserializer: JsonDeserializer<MultiPolygon>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiPolygon = p.fromJson(String::toMultiPolygon)
}
