package ru.github.onotoliy.geojson

/**
 * Объект FeatureCollection.
 *
 * @property features Список объектов Features.
 * @author Anatoliy Pokhresnyi
 */
actual class FeatureCollection actual constructor(features: MultiFeature) : GeoJsonObject<MultiFeature>(features) {

    /**
     * Список объектов Features.
     */
    actual val features: MultiFeature
        get() = value
}