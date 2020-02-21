package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.Feature
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.stringify
import ru.github.onotoliy.geojson.serializers.toFeature

@JsonSerialize(`as` = Feature::class)
class FeatureJacksonSerializer : JsonSerializer<Feature>() {
    override fun serialize(value: Feature, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

@JsonDeserialize(`as` = Feature::class)
class FeatureJacksonDeserializer : JsonDeserializer<Feature>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Feature =
        p.fromJson(String::toFeature)
}