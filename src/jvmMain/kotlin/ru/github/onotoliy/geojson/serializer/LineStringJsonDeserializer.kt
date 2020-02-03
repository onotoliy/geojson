package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.LineString
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toLineString

class LineStringJsonDeserializer: JsonDeserializer<LineString>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): LineString = p.fromJson(String::toLineString)
}
