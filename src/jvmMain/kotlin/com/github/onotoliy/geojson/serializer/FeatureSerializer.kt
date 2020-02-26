package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.github.onotoliy.geojson.Feature
import com.github.onotoliy.geojson.fromJson
import com.github.onotoliy.geojson.serializers.stringify
import com.github.onotoliy.geojson.serializers.toFeature

/**
 * Jackson сериализация [Feature].
 *
 * @author Anatoliy Pokhresnyi
 */
class FeatureJacksonSerializer : JsonSerializer<Feature>() {
    override fun serialize(value: Feature, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [Feature].
 *
 * @author Anatoliy Pokhresnyi
 */
class FeatureJacksonDeserializer : JsonDeserializer<Feature>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Feature =
        p.fromJson(String::toFeature)
}
