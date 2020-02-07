package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.MultiFeature
import ru.github.onotoliy.geojson.MultiGeometry
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toMultiFeature
import ru.github.onotoliy.geojson.serializers.toMultiGeometry

class MultiFeatureJsonDeserializer: JsonDeserializer<MultiFeature>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiFeature
            = p.fromJson(String::toMultiFeature)
}