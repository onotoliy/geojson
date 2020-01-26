# Сериализация GeoJson

Мильтиплатформенная сериализвация GeoJson на Kotlin

#### Подключение

**Клиентская часть**:
```
repositories {
    maven {
        url  "https://dl.bintray.com/a-k-pohresniy/onotoliy"
    }
}


dependencies {
    compile 'com.github.onotoliy.geojson:geojson-js:1.0'
}
```

**Серверная часть**:
```
repositories {
    maven {
        url  "https://dl.bintray.com/a-k-pohresniy/onotoliy"
    }
}


dependencies {
    compile 'com.github.onotoliy.geojson:geojson-jvm:1.0'
}
```