# Getting Started with JADEx

JADEx (Java Advanced Development Extension) is a **source-to-source compiler** that adds null-safety and readonly (final-by-default) semantics to your existing Java code. This guide walks you through everything you need to get up and running.

---

## Prerequisites

| Tool | Minimum Version |
|---|---|
| JDK | 21 |
| Gradle | 8.0 |
| IntelliJ IDEA | 2025.2 (optional, but recommended) |

---

## Installation

### Gradle Plugin

The JADEx Gradle plugin compiles `.jadex` files into standard Java source files as part of your existing build pipeline.

Add the plugin to your `build.gradle`:

```groovy
plugins {
    id 'io.github.nieuwmijnleven.jadex' version '0.628'
}
```

Or in `build.gradle.kts`:

```kotlin
plugins {
    id("io.github.nieuwmijnleven.jadex") version "0.628"
}
```

**Available Tasks**

| Task | Description |
|---|---|
| `compileJadex` | Compiles `.jadex` source files into standard Java source files |

**(Optional) Custom Configuration**

```groovy
// build.gradle
jadex {
    sourceDir = "src/main/jadex"
    outputDir = "build/generated/sources/jadex/main/java"
}
```

```kotlin
// build.gradle.kts
jadex {
    sourceDir = "src/main/jadex"
    outputDir = "build/generated/sources/jadex/main/java"
}
```

---

### IntelliJ Plugin

The JADEx IntelliJ plugin provides real-time null-safety analysis and lets you apply null-safety operators interactively without leaving your IDE.

**Installation from JetBrains Marketplace**

1. Launch IntelliJ IDEA
2. Navigate to **File → Settings → Plugins → Marketplace**
3. Search for **`JADEx`**
4. Click **Install** and restart your IDE

**(Alternative) Manual Installation**

1. Download [intellij-plugin-0.26.zip](https://github.com/user-attachments/files/25161928/intellij-plugin-0.26.zip)
2. Navigate to **File → Settings → Plugins → ⚙️ → Install Plugin from Disk**
3. Select the downloaded `.zip` file and restart your IDE

> **Tip:** Use the Gradle plugin in your CI/CD pipeline to enforce null-safety and readonly checks on every build, and the IntelliJ plugin locally for interactive analysis.

---

## How JADEx Works

JADEx sits between your existing Java source and the Java compiler as a safety layer:

```
+---------------------------+
|       Existing Java       |
|   (potentially unsafe)    |
+------------+--------------+
             |
             v
+---------------------------+
|  JADEx (Safety Layer)     |
|  - null-safety analysis   |
|  - readonly enforcement   |
+------------+--------------+
             |
             v
+---------------------------+
|    Safe & Robust Java     |
|  (compile-time enforced)  |
+---------------------------+
```

JADEx does **not generate bytecode**. It produces standard Java source files, which are then compiled by your regular Java compiler — meaning **zero runtime overhead**.

---

## Workflow

The typical JADEx workflow looks like this:

```
1. Copy your existing .java file as-is to a .jadex file
          ↓
2. Run JADEx null-safety analysis
          ↓
3. Review the reported nullable/non-nullable issues
          ↓
4. Apply JADEx null-safety operators (Type?, ?., ?:) and then optionally readonly semantics (apply readonly;)
          ↓
5. Run the JADEx compiler (./gradlew compileJadex)
          ↓
6. Safe Java source is generated and included in your build
```

The JADEx IntelliJ plugin automates steps 2–4, so in practice **all you need to do is review the analysis results and apply the operators**.

---

## Your First .jadex File

### Step 1 — Copy your Java file

Take any existing `.java` file and copy it as a `.jadex` file under `src/main/jadex`. No changes needed at this point — `.jadex` files are valid Java.

```
src/
  main/
    java/
      com/example/UserService.java     ← original
    jadex/
      com/example/UserService.jadex    ← copy
```

### Step 2 — Apply null-safety operators

Open the `.jadex` file in IntelliJ. JADEx will highlight potential null-safety issues. Apply the operators where needed:

```java
// Before
public class UserService {
    public String getCity(User user) {
        return user.getAddress().getCity().toUpperCase();
    }
}

// After
public class UserService {
    public String? getCity(User? user) {
        return user?.getAddress()?.getCity()?.toUpperCase();
    }
}
```

### Step 3 — Optionally apply readonly

Add `apply readonly;` at the top of the file to enforce final-by-default semantics across all fields, local variables, and parameters. Use `mutable` to opt out selectively:

```java
package com.example;

apply readonly;

public class UserService {
    private String? cachedCity = null;          // final (readonly)
    private mutable int requestCount = 0;       // reassignable (mutable)

    public String? getCity(User? user) {
        requestCount++;                         // allowed: mutable
        return user?.getAddress()?.getCity()?.toUpperCase();
    }
}
```

### Step 4 — Compile

```bash
./gradlew compileJadex
```

The generated Java source is placed in `build/generated/sources/jadex/main/java` and automatically included in your subsequent Java compilation.

---

## Next Steps

| Guide                                           | Description                                               |
|-------------------------------------------------|-----------------------------------------------------------|
| [Null-Safety Guide](null-safety-guide.md)       | Full reference for `Type?`, `?.`, and `?:` with examples  |
| [Readonly Guide](readonly-guide.md)             | Full reference for `apply readonly;` and `mutable` with examples |
| [Basic Examples](../BasicExample.md)            | Core null-safety features in everyday Java code           |
| [Real-World Examples](../RealworldExample.md)   | Applying JADEx in a real Java project                     |
| [Spring Boot Examples](../SpringBootExample.md) | Applying JADEx in a Spring Boot project                   |
| [FAQ](faq.md)                                   | Project Valhalla, Kotlin, performance, and more           |