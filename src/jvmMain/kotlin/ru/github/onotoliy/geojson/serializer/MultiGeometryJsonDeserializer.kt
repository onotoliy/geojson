package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.MultiGeometry
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toMultiGeometry

class MultiGeometryJsonDeserializer: JsonDeserializer<MultiGeometry>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiGeometry
            = p.fromJson(String::toMultiGeometry)
}