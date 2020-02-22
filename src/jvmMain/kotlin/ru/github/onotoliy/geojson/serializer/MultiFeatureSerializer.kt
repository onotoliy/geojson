package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.github.onotoliy.geojson.MultiFeature
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.stringify
import ru.github.onotoliy.geojson.serializers.toMultiFeature

/**
 * Jackson сериализация [MultiFeature].
 *
 * @author Anatoliy Pokhresnyi
 */
class MultiFeatureJacksonSerializer : JsonSerializer<MultiFeature>() {
    override fun serialize(value: MultiFeature, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [MultiFeature].
 *
 * @author Anatoliy Pokhresnyi
 */
class MultiFeatureJacksonDeserializer : JsonDeserializer<MultiFeature>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MultiFeature =
        p.fromJson(String::toMultiFeature)
}
