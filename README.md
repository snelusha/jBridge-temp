```bash
./gradlew clean build --no-build-cache
```

```bash
mkdir -p bothnativea/native bothnativeb/native
```

## BothNativeA

```java
// bothnativea/src/main/java/org/pkg/bothnativea/BothNativeA.java
public static void main(String[] args) {
    System.load("<PROJECT_PATH>/bothnativeb/native/bothnativeb.dylib");
}
```

```bash
cd bothnativea
native-image --no-fallback -o native/bothnativea -cp build/libs/bothnativea.jar org.pkg.bothnativea.BothNativeA
```

## BothNativeB

```bash
cd bothnativea
native-image --shared -o native/bothnativeb -cp build/libs/bothnativeb.jar org.pkg.bothnativeb.BothNativeB
```

## Run

```bash
./bothnativea/native/bothnativea
```
