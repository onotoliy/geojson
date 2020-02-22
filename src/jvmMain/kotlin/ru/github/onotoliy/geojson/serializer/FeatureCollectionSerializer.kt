package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.github.onotoliy.geojson.FeatureCollection
import ru.github.onotoliy.geojson.fromJson
import ru.github.onotoliy.geojson.serializers.stringify
import ru.github.onotoliy.geojson.serializers.toFeatureCollection

/**
 * Jackson сериализация [FeatureCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
class FeatureCollectionJacksonSerializer : JsonSerializer<FeatureCollection>() {
    override fun serialize(value: FeatureCollection, gen: JsonGenerator?, serializers: SerializerProvider?) =
        if (gen == null) throw IllegalArgumentException() else gen.writeRaw(value.stringify())
}

/**
 * Jackson десериализация [FeatureCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
class FeatureCollectionJacksonDeserializer : JsonDeserializer<FeatureCollection>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): FeatureCollection =
        p.fromJson(String::toFeatureCollection)
}
