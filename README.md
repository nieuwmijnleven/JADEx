<p align="center">
  <img src="https://raw.githubusercontent.com/nieuwmijnleven/JPlus/refs/heads/master/intellij-plugin/src/main/resources/META-INF/pluginIcon.svg" alt="Logo" width="200">
</p>

[![License](https://img.shields.io/badge/License-GPL_v2_only_%2B_Commercial-blue.svg)](https://opensource.org/licenses/GPL-2.0-only)

# <img src="https://raw.githubusercontent.com/nieuwmijnleven/JPlus/refs/heads/master/intellij-plugin/src/main/resources/META-INF/pluginIcon.svg" alt="Logo" width="25" style="vertical-align: middle;"> JADEx - Same Java, Just Safer

**JADEx (Java Advanced Development Extension)** is a practical Java safety layer that adds **null-safety** and **readonly (final-by-default)** enforcement to your existing Java code — without switching languages, rewriting your codebase, or leaving the Java ecosystem.

---

## ✨ What JADEx Does

JADEx sits between your existing Java source and the Java compiler as a **source-to-source safety layer**:

```
  Existing Java  →  JADEx Safety Layer  →  Safe Java (with null-safety & readonly)
```

- **Null-safety**: Catch `NullPointerException` at compile time using `Type?`, `?.`, and `?:` operators
- **Readonly (final-by-default)**: Prevent accidental reassignment with `apply readonly;` and `mutable`
- **Zero migration cost**: `.jadex` files are plain Java — just copy your `.java` files and start adopting safety features incrementally
- **No runtime overhead**: JADEx generates standard Java source, compiled by your regular Java compiler

> JADEx is not a new language. It is Java, made safer.

---

## 🚀 Quick Start

### 1. Install the Gradle Plugin

```groovy
// build.gradle
plugins {
    id 'io.github.nieuwmijnleven.jadex' version '0.628'
}
```

```kotlin
// build.gradle.kts
plugins {
    id("io.github.nieuwmijnleven.jadex") version "0.628"
}
```

Place your `.jadex` files under `src/main/jadex`, then run:

```bash
./gradlew compileJadex
```

Generated Java source files are output to `build/generated/sources/jadex/main/java` and automatically included in subsequent Java compilation.

### 2. Install the IntelliJ Plugin

Search for **`JADEx`** in **File → Settings → Plugins → Marketplace** and click Install.

> **Prerequisites**: JDK 21+, IntelliJ 2025.2+, Gradle 8.0+

---

## 💡 Null-Safety in a Nutshell

JADEx makes nullability **explicit at the type level** and enforces it at **compile time**.

```java
// Before (standard Java — NPE waiting to happen)
User user = userRepository.findById(id);
String city = user.getAddress().getCity().toUpperCase();

// After (JADEx — safe and concise)
User? user = userRepository.findById(id);
String? city = user?.getAddress()?.getCity()?.toUpperCase();
```

| Syntax | Meaning |
|---|---|
| `Type` | Non-nullable (default) |
| `Type?` | Nullable |
| `?.` | Null-safe access |
| `?:` | Elvis operator (fallback value) |

```java
String? name = null;
String display = name ?: "Anonymous";   // "Anonymous"
int len = name?.length() ?: 0;          // 0
```

→ [Full Null-Safety Guide](docs/null-safety-guide.md)

---

## 🔒 Readonly (final-by-default) in a Nutshell

Add `apply readonly;` at the top of a file to make all fields, local variables, and parameters `final` by default. Use `mutable` to opt out selectively.

```java
package jadex.example;

apply readonly;

public class UserProfile {
    private String name = "JADEx";      // final (readonly)
    private mutable int loginCount = 0; // not final (mutable)

    public void login(String sessionId, mutable String token) {
        // sessionId is final, token is reassignable
        token = sessionId + "-refreshed"; // allowed
    }
}
```

→ [Full Readonly Guide](docs/readonly-guide.md)

---

## 📚 Documentation

| Document | Description |
|---|---|
| [Getting Started](docs/getting-started.md) | Workflow, first `.jadex` file |
| [Null-Safety Guide](docs/null-safety-guide.md) | All null-safety operators with examples |
| [Readonly Guide](docs/readonly-guide.md) | `apply readonly;` and `mutable` with examples |
| [Real-World Examples](docs/real-world-examples.md) | Applying JADEx to existing Java projects |
| [FAQ](docs/faq.md) | Project Valhalla, Kotlin, performance, and more |

---

## 🤝 Sponsorship & Support

JADEx is in its early stage — every contribution helps shape its future.

- **Bug reports, feature requests, and PRs** are always welcome
- **Sponsors** help accelerate development and gain early access to new features

[Become a Sponsor via GitHub](https://github.com/sponsors/nieuwmijnleven) · [Become a Sponsor via PayPal](https://paypal.me/nieuwmijnleven)

---

## 🌟 Thanks to My Sponsor!

Special thanks to [@shocklateboy92](https://github.com/shocklateboy92) for supporting this project through GitHub Sponsors!
