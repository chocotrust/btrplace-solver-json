# Btrplace solver-json  #

This maven artifact allows to read and write models, constraints, and plans
from/to the JSON serialization format.

Contact: fabien.hermenier@unice.fr

## Usage ##

The maven artifact is available through a private repository
so you have first to edit your `pom.xml` to declare it:

```xml
<repositories>
    <repository>
        <id>btrp-releases</id>
        <url>http://btrp.inria.fr:8080/repos/releases</url>
    </repository>
    <repository>
        <id>btrp-snapshots</id>
        <url>http://btrp.inria.fr:8080/repos/snapshot-releases</url>
    </repository>
</repositories>
```

Next, just declare the dependency:

```xml
<dependency>
   <groupId>btrplace</groupId>
   <artifactId>solver-json</artifactId>
   <version>0.4</version>
</dependency>
```

## Documentation ##

* Javadoc for the last snapshot version: http://btrp.inria.fr:8080/apidocs/snapshots/solver-json
* Javadoc for the released versions: http://btrp.inria.fr:8080/apidocs/releases/btrplace/solver-json

## Building from sources ##

Requirements:
* JDK 6+
* maven 3+

The source of the released versions are directly available in the `Tag` section.
You can also download them using github features.
Once downloaded, move to the source directory then execute the following command
to make the jar:

    $ mvn clean install

If the build succeeded, the resulting jar will be automatically
installed in your local maven repository and available in the `target` sub-folder.


## Copyright ##
Copyright (c) 2013 University of Nice-Sophia Antipolis. See `LICENSE.txt` for details
