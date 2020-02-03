package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.MultiLineString
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toMultiLineString

class MultiLineStringJsonDeserializer: JsonDeserializer<MultiLineString>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiLineString = p.fromJson(String::toMultiLineString)
}
