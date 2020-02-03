package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.github.onotoliy.geojson.Geometry
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.toGeometry

class GeometryJsonDeserializer: JsonDeserializer<Geometry>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Geometry = p.fromJson(String::toGeometry)
}
