package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.MultiPosition
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toMultiPosition

class MultiPositionJsonDeserializer: JsonDeserializer<MultiPosition>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiPosition
            = p.fromJson(String::toMultiPosition)
}