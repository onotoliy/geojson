package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.FeatureCollection
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toFeatureCollection

class FeatureCollectionJsonDeserializer : JsonDeserializer<FeatureCollection>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): FeatureCollection = p.fromJson(String::toFeatureCollection)
}