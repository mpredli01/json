
## Public Review of JSON-P Specification 1.1 is Now Open

### InfoQ Java Queue

#### published March 8, 2017

This example application demonstrates how to implement a JSON parser for [JSON-P](https://json-p.github.io/), [Gson](https://github.com/google/gson/blob/master/README.md), and [Jackson](http://wiki.fasterxml.com/JacksonHome). 

The application can be built with [Gradle 3.0](https://gradle.org/) by executing the following command:

`gradle clean build`

In the `build.gradle` file, there are references to the three main methods to run the JSON-P, Gson, and Jackson applications:

`mainClassName = 'org.redlich.json.jsonp.Application'`
`mainClassName = 'org.redlich.json.gson.Application'`
`mainClassName = 'org.redlich.json.jackson.Application'`

To run a specific JSON parser, comment the other two `mainClassName` references and execute the command:

`gradle run`

The `Publication` POJO is there for future implementation of binding the JSON file, `publications.json` to the POJO.

Please don't hesitate to contact me at [mike@redlich.net](mailto:mike@redlich.net) for any questions.
