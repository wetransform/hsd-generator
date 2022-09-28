hsd-generator
=================

Generate HSD schemas using SchemaBuilder
----------------------------------------

A task to generate an HSD schema is generated for every `schema.groovy` file placed in a subfolder of `schemas/`.

You can generate the HSD schema file for a specific schema by running:

```
./gradlew buildSchema-<subfolder-name>
```

Make sure to replace `<subfolder-name>` by the name of the respective subfolder in `schemas/`.

To run all schema generation tasks run  `./gradlew`.
