package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.MultiPoint
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toMultiPoint

class MultiPointJsonDeserializer: JsonDeserializer<MultiPoint>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiPoint = p.fromJson(String::toMultiPoint)
}