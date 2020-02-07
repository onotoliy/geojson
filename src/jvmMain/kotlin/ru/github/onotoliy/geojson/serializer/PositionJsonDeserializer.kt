package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.Position
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toPosition

class PositionJsonDeserializer: JsonDeserializer<Position>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Position
            = p.fromJson(String::toPosition)
}