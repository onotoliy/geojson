package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.GeometryCollection
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toGeometryCollection

class GeometryCollectionJsonDeserializer: JsonDeserializer<GeometryCollection>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): GeometryCollection = p.fromJson(String::toGeometryCollection)
}