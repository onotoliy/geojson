package ru.github.onotoliy.geojson

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

val FEATURE_JSON = """
{
  "type": "Feature",
  "geometry": {
    "type": "Polygon",
    "coordinates": [
      [
        [
          100.0,
          0.0
        ],
        [
          101.0,
          0.0
        ],
        [
          101.0,
          1.0
        ],
        [
          100.0,
          1.0
        ],
        [
          100.0,
          0.0
        ]
      ]
    ]
  }
}
""".formatted()
val FEATURE_OBJECT = Feature(
    Polygon(
        Ring(
            listOf(
                MultiPosition(
                    listOf(
                        Position(100.0, 0.0),
                        Position(101.0, 0.0),
                        Position(101.0, 1.0),
                        Position(100.0, 1.0),
                        Position(100.0, 0.0)
                    )
                )
            )
        )
    )
)

val FEATURE_COLLECTION_JSON = """
{
  "type": "FeatureCollection",
  "features": [
    {
      "type": "Feature",
      "geometry": {
        "type": "Point",
        "coordinates": [
          102.0,
          0.5
        ]
      }
    },
    {
      "type": "Feature",
      "geometry": {
        "type": "LineString",
        "coordinates": [
          [
            102.0,
            0.0
          ],
          [
            103.0,
            1.0
          ],
          [
            104.0,
            0.0
          ],
          [
            105.0,
            1.0
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
            [
              100.0,
              0.0
            ],
            [
              101.0,
              0.0
            ],
            [
              101.0,
              1.0
            ],
            [
              100.0,
              1.0
            ],
            [
              100.0,
              0.0
            ]
          ]
        ]
      }
    }
  ]
}
""".formatted()
val FEATURE_COLLECTION_OBJECT = FeatureCollection(
    MultiFeature(
        listOf(
            Feature(Point(Position(102.0, 0.5))),
            Feature(
                LineString(
                    MultiPosition(
                        listOf(
                            Position(102.0, 0.0),
                            Position(103.0, 1.0),
                            Position(104.0, 0.0),
                            Position(105.0, 1.0)
                        )
                    )
                )
            ),
            Feature(
                Polygon(
                    Ring(
                        listOf(
                            MultiPosition(
                                listOf(
                                    Position(100.0, 0.0),
                                    Position(101.0, 0.0),
                                    Position(101.0, 1.0),
                                    Position(100.0, 1.0),
                                    Position(100.0, 0.0)
                                )
                            )
                        )
                    )
                )
            )
        )
    )
)

val GEOMETRY_COLLECTION_JSON = """
{
  "type": "GeometryCollection",
  "geometries": [
    {
      "type": "Point",
      "coordinates": [
        100.0,
        0.0
      ]
    },
    {
      "type": "LineString",
      "coordinates": [
        [
          101.0,
          0.0
        ],
        [
          102.0,
          1.0
        ]
      ]
    }
  ]
}
""".formatted()
val GEOMETRY_COLLECTION_OBJECT = GeometryCollection(
    MultiGeometry(
        listOf(
            Point(Position(100.0, 0.0)),
            LineString(MultiPosition(listOf(Position(101.0, 0.0), Position(102.0, 1.0))))
        )
    )
)

val LINE_STRING_JSON = """
{
  "type": "LineString",
  "coordinates": [
    [
      100.0,
      0.0
    ],
    [
      101.0,
      1.0
    ]
  ]
}
""".formatted()
val LINE_STRING_OBJECT = LineString(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 1.0))))

val MULTI_LINE_STRING_JSON = """
{
  "type": "MultiLineString",
  "coordinates": [
    [
      [
        100.0,
        0.0
      ],
      [
        101.0,
        1.0
      ]
    ],
    [
      [
        102.0,
        2.0
      ],
      [
        103.0,
        3.0
      ]
    ]
  ]
}    
""".formatted()
val MULTI_LINE_STRING_OBJECT = MultiLineString(
    Ring(
        listOf(
            MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 1.0))),
            MultiPosition(listOf(Position(102.0, 2.0), Position(103.0, 3.0)))
        )
    )
)

val MULTI_POINT_JSON = """
{
  "type": "MultiPoint",
  "coordinates": [
    [
      100.0,
      0.0
    ],
    [
      101.0,
      1.0
    ]
  ]
}    
""".formatted()
val MULTI_POINT_OBJECT = MultiPoint(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 1.0))))

val MULTI_POLYGON_JSON = """
{
  "type": "MultiPolygon",
  "coordinates": [
    [
      [
        [
          102.0,
          2.0
        ],
        [
          103.0,
          2.0
        ],
        [
          103.0,
          3.0
        ],
        [
          102.0,
          3.0
        ],
        [
          102.0,
          2.0
        ]
      ]
    ],
    [
      [
        [
          100.0,
          0.0
        ],
        [
          101.0,
          0.0
        ],
        [
          101.0,
          1.0
        ],
        [
          100.0,
          1.0
        ],
        [
          100.0,
          0.0
        ]
      ],
      [
        [
          100.2,
          0.2
        ],
        [
          100.2,
          0.8
        ],
        [
          100.8,
          0.8
        ],
        [
          100.8,
          0.2
        ],
        [
          100.2,
          0.2
        ]
      ]
    ]
  ]
}    
""".formatted()
val MULTI_POLYGON_OBJECT = MultiPolygon(
    MultiRing(
        listOf(
            Ring(
                listOf(
                    MultiPosition(
                        listOf(
                            Position(102.0, 2.0),
                            Position(103.0, 2.0),
                            Position(103.0, 3.0),
                            Position(102.0, 3.0),
                            Position(102.0, 2.0)
                        )
                    )
                )
            ),
            Ring(
                listOf(
                    MultiPosition(
                        listOf(
                            Position(100.0, 0.0),
                            Position(101.0, 0.0),
                            Position(101.0, 1.0),
                            Position(100.0, 1.0),
                            Position(100.0, 0.0)
                        )
                    ),
                    MultiPosition(
                        listOf(
                            Position(100.2, 0.2),
                            Position(100.2, 0.8),
                            Position(100.8, 0.8),
                            Position(100.8, 0.2),
                            Position(100.2, 0.2)
                        )
                    )
                )
            )
        )
    )
)

val POINT_JSON = """
{
  "type": "Point",
  "coordinates": [
    100.0,
    0.0
  ]
}    
""".formatted()
val POINT_OBJECT = Point(Position(100.0, 0.0))

val POLYGON_NO_HOLES_JSON = """
{
  "type": "Polygon",
  "coordinates": [
    [
      [
        100.0,
        0.0
      ],
      [
        101.0,
        0.0
      ],
      [
        101.0,
        1.0
      ],
      [
        100.0,
        1.0
      ],
      [
        100.0,
        0.0
      ]
    ]
  ]
}    
""".formatted()
val POLYGON_NO_HOLES_OBJECT = Polygon(
    Ring(
        listOf(
            MultiPosition(
                listOf(
                    Position(100.0, 0.0),
                    Position(101.0, 0.0),
                    Position(101.0, 1.0),
                    Position(100.0, 1.0),
                    Position(100.0, 0.0)
                )
            )
        )
    )
)

val POLYGON_WITH_HOLES_JSON = """
{
  "type": "Polygon",
  "coordinates": [
    [
      [
        100.0,
        0.0
      ],
      [
        101.0,
        0.0
      ],
      [
        101.0,
        1.0
      ],
      [
        100.0,
        1.0
      ],
      [
        100.0,
        0.0
      ]
    ],
    [
      [
        100.8,
        0.8
      ],
      [
        100.8,
        0.2
      ],
      [
        100.2,
        0.2
      ],
      [
        100.2,
        0.8
      ],
      [
        100.8,
        0.8
      ]
    ]
  ]
}    
""".formatted()
val POLYGON_WITH_HOLES_OBJECT = Polygon(
    Ring(
        listOf(
            MultiPosition(
                listOf(
                    Position(100.0, 0.0),
                    Position(101.0, 0.0),
                    Position(101.0, 1.0),
                    Position(100.0, 1.0),
                    Position(100.0, 0.0)
                )
            ),
            MultiPosition(
                listOf(
                    Position(100.8, 0.8),
                    Position(100.8, 0.2),
                    Position(100.2, 0.2),
                    Position(100.2, 0.8),
                    Position(100.8, 0.8)
                )
            )
        )
    )
)

fun String.formatted() = Json(JsonConfiguration.Stable).parseJson(this).toString()
