package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.Feature
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toFeature

class FeatureJsonDeserializer: JsonDeserializer<Feature>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Feature = p.fromJson(String::toFeature)
}