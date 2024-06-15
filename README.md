# Java Cobalt API

Simple and lightweight Java wrapper for [cobalt's API](https://github.com/imputnet/cobalt).

> [!IMPORTANT]  
> [As said in the cobalt's README](https://github.com/imputnet/cobalt?tab=readme-ov-file#cobalt-api), if you'll use the
> main API instance, you can use it only in **personal** projects.

## Contents

- [Quick showcase](#quick-showcase)
- [Installation](#installation)
    - [Gradle](#gradle)
    - [Maven](#maven)
- [Documentation](#documentation)

## Quick Showcase

```java
// Create a new API instance
var api = new CobaltApi("https://example.com"); // Cobalt API URL

// Create a new download context
var context = DownloadContext.builder("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
                             .isAudioMuted(true)
                             .quality(Quality._144P).build();

// Send the request
var result = api.getDownload(context).send();

// Check if the result is an error
if (result.isError()) {
    System.out.println("Error: " + result.getText());
    return;
}

// Print the stream URL
System.out.println("Stream URL is: " + result.getUrl());
```

Result:

```text
Stream URL is: https://kityune.imput.net/api/stream?id=(...)
```

> [!TIP]  
> You can use `#sendAsync()` method to send the request asynchronously.

## Installation

### Gradle

```groovy
repositories {
    mavenCentral()
}

dependencies {
    // Library itself
    implementation 'dev.mayuna:java-cobalt-api:1.0.0'

    // Required for the library to work
    implementation 'dev.mayuna:simple-java-api-wrapper:2.3.1'
    implementation 'com.google.code.gson:gson:2.11.0'
}
```

### Maven

```xml
<!-- Library itself -->
<dependency>
    <groupId>dev.mayuna</groupId>
    <artifactId>java-cobalt-api</artifactId>
    <version>1.0.0</version>
</dependency>

        <!-- Required for the library to work -->
<dependency>
    <groupId>dev.mayuna</groupId>
    <artifactId>simple-java-api-wrapper</artifactId>
    <version>2.3.1</version>
</dependency>
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
</dependency>
```

**You can find the latest version [here](https://mvnrepository.com/artifact/dev.mayuna/java-discord-oauth2-api).**

## Documentation

TODO