# unisinos-degree-grades

Sample project to presentantion Clojure Language as Functional Programming Language at Unisinos.

## Installation

* Requirements
    - JDK: https://www.oracle.com/java/technologies/downloads/
    - Leiningen: https://leiningen.org/
        - Run lein script install: 
        ```bash
        lein self-install
        ```
        - Put the lein script in your path
        
        Windows:
        ```bat
        set PATH=%CD%;%PATH%
        ```
        Linux:
        ```bash
        export PATH=$PWD:$PATH
        ```

## Usage

* Developments 
```
bash lein run
```

* Production
``` bash
$ java -jar unisinos-degree-grades-0.1.0-standalone.jar [args]
```