hsd-generator
=============

Project for generating hale studio schemas and data using Groovy builders.


Generate HSD schemas using SchemaBuilder
----------------------------------------

A task to generate an HSD schema is generated for every `schema.groovy` file placed in a subfolder of `schemas/`.

You can generate the HSD schema file for a specific schema by running:

```
./gradlew buildSchema-<subfolder-name>
```

Make sure to replace `<subfolder-name>` by the name of the respective subfolder in `schemas/`.

To run all schema generation tasks run  `./gradlew`.


Generate data using InstanceBuilder
-----------------------------------

Tasks to generate an data files are generated for every `instances.groovy` file placed in a subfolder of `schemas/`.

You can generate data files for all supported formats for a specific schema by running:

```
./gradlew genInstances-<subfolder-name>
```

Make sure to replace `<subfolder-name>` by the name of the respective subfolder in `schemas/`.

You can also run generating data files only for a specific format:

```
./gradlew genInstances-<subfolder-name>-<format-id>
```

Where `<format-id>` currently is one of:

- Shapefile
- CSV
- GeoJson
- Json
- GPKG
- XLSX

Check `./gradlew tasks` for all available tasks.
