# Readonly Guide

JADEx provides optional **readonly (final-by-default)** semantics that prevent accidental reassignment of fields, local variables, and method parameters. This guide covers all readonly features with complete examples.

---

## Core Concepts

### The Problem with Mutable-by-Default

In standard Java, every variable is mutable by default. Making something immutable requires explicitly adding `final` everywhere — which most developers skip because it is verbose:

```java
// Standard Java — everything is mutable by default
String name = "JADEx";
int count = 0;
name = "other";   // silently allowed — intentional or a bug?
count = 10;       // silently allowed
```

With `final`, the intent is clear but the syntax is noisy:

```java
final String name = "JADEx";
final int count = 0;
// now every local variable and parameter needs 'final'
```

### JADEx's Approach: Final by Default, Mutable by Exception

JADEx flips the default within a marked scope. Add `apply readonly;` at the top of a file and every field, local variable, and parameter becomes `final` — unless explicitly marked `mutable`:

```java
apply readonly;

public class Example {
    String name = "JADEx";      // final (readonly)
    mutable int count = 0;      // reassignable (mutable)
}
```

This mirrors JADEx's null-safety philosophy: **the safe option is the default, and the unsafe option must be explicitly opted into**.

| JADEx | Java equivalent |
|---|---|
| `apply readonly;` (file scope) | `final` on every field, local variable, and parameter |
| `mutable` modifier | no `final` (reassignable) |

---

## Syntax Reference

| Syntax | Scope | Meaning |
|---|---|---|
| `apply readonly;` | File | All fields, local variables, and parameters in this file become `final` by default |
| `mutable` | Field / variable / parameter | Explicitly opt out of readonly — remains reassignable |

> `apply readonly;` is a **file-level directive**, not a class-level modifier. It applies to every class declared within the file.

---

## Examples

### Example ① — Basic Field Readonly

When `apply readonly;` is declared, all fields are treated as `final`. Attempting to reassign them causes a compile-time error.

```java
package jadex.example;

apply readonly;

public class Example1 {
    private int count = 0;           // readonly (final)
    private String? name = "JADEx"; // readonly (final)

    public static void main(String[] args) {
        var example = new Example1();
        example.count = 10;  // ❌ error: readonly
        example.name = "New"; // ❌ error: readonly
    }
}
```

**Generated Java**

```java
package jadex.example;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import jadex.runtime.SafeAccess;

//apply readonly;

@NullMarked
public class Example1 {
    private final int count = 0;
    private final @Nullable String name = "JADEx";

    public static void main(final String[] args) {
        final var example = new Example1();
        example.count = 10;   // ❌ error: readonly
        example.name = "New"; // ❌ error: readonly
    }
}
```

---

### Example ② — Mutable Fields

Use the `mutable` modifier to explicitly opt out of readonly for fields that need to be reassigned.

```java
package jadex.example;

apply readonly;

public class Example2 {
    private mutable int temp = 5;         // reassignable
    private mutable String? note = "hi"; // reassignable

    public static void main(String[] args) {
        var example = new Example2();
        example.temp = 10;        // ✅ allowed
        example.note = "updated"; // ✅ allowed
    }
}
```

**Generated Java**

```java
package jadex.example;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import jadex.runtime.SafeAccess;

//apply readonly;

@NullMarked
public class Example2 {
    private int temp = 5;
    private @Nullable String note = "hi";

    public static void main(final String[] args) {
        final var example = new Example2();
        example.temp = 10;        // ✅ allowed
        example.note = "updated"; // ✅ allowed
    }
}
```

---

### Example ③ — Readonly Method Parameters

Under `apply readonly;`, method parameters are also `final` by default. Use `mutable` to allow reassignment within the method body.

```java
package jadex.example;

apply readonly;

public class Example3 {

    public static void process(String? readonlyParam, mutable String? mutableParam) {
        readonlyParam = "change"; // ❌ error: readonly
        mutableParam = "change";  // ✅ allowed
    }

    public static void main(String[] args) {
        String? msg = "hello";
        process(msg, msg);
    }
}
```

**Generated Java**

```java
package jadex.example;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import jadex.runtime.SafeAccess;

//apply readonly;

@NullMarked
public class Example3 {

    public static void process(final @Nullable String readonlyParam, @Nullable String mutableParam) {
        readonlyParam = "change"; // ❌ error: readonly
        mutableParam = "change";  // ✅ allowed
    }

    public static void main(final String[] args) {
        final @Nullable String msg = "hello";
        process(msg, msg);
    }
}
```

---

### Example ④ — Readonly Local Variables

Local variables declared inside method bodies are also affected by `apply readonly;`.

```java
package jadex.example;

apply readonly;

public class Example4 {

    public static String buildGreeting(String name) {
        String greeting = "Hello, " + name;  // readonly (final)
        mutable int retryCount = 0;           // reassignable

        greeting = "Hi";     // ❌ error: readonly
        retryCount = 1;      // ✅ allowed

        return greeting;
    }
}
```

**Generated Java**

```java
package jadex.example;

import org.jspecify.annotations.NullMarked;

//apply readonly;

@NullMarked
public class Example4 {

    public static String buildGreeting(final String name) {
        final String greeting = "Hello, " + name;
        int retryCount = 0;

        greeting = "Hi";  // ❌ error: readonly
        retryCount = 1;   // ✅ allowed

        return greeting;
    }
}
```

---

### Example ⑤ — Combining Readonly with Null-Safety

`apply readonly;` and JADEx null-safety operators work together naturally.

```java
package jadex.example;

apply readonly;

public class UserService {
    private String? cachedCity = null;     // readonly + nullable
    private mutable int requestCount = 0; // mutable

    public String? getCity(User? user) {
        requestCount++;   // ✅ allowed: mutable
        return user?.getAddress()?.getCity()?.toUpperCase();
    }
}
```

**Generated Java**

```java
package jadex.example;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import jadex.runtime.SafeAccess;

//apply readonly;

@NullMarked
public class UserService {
    private final @Nullable String cachedCity = null;
    private int requestCount = 0;

    public @Nullable String getCity(final @Nullable User user) {
        requestCount++;
        return SafeAccess.ofNullable(user)
            .map(t0 -> t0.getAddress())
            .map(t1 -> t1.getCity())
            .map(t2 -> t2.toUpperCase())
            .orElse(null);
    }
}
```

---

## Rules Summary

| Target | Under `apply readonly;` | With `mutable` |
|---|---|---|
| Fields | `final` by default | Reassignable |
| Local variables | `final` by default | Reassignable |
| Method parameters | `final` by default | Reassignable |
| Classes / methods | No effect | N/A |

---

## Generated Java — What Happens Under the Hood

| JADEx | Generated Java |
|---|---|
| `apply readonly;` | Generates `final` on all applicable targets in the file |
| `String name` (under `apply readonly;`) | `final String name` |
| `mutable String name` | `String name` (no `final`) |
| `String? name` (under `apply readonly;`) | `final @Nullable String name` |
| `mutable String? name` | `@Nullable String name` |

The `apply readonly;` directive is stripped from the generated Java and replaced with a comment (`//apply readonly;`) to preserve traceability.

---

## Design Philosophy

JADEx's `readonly` approach is intentionally **opt-in at the file level**:

- Existing Java files remain untouched — no forced migration
- Teams can adopt readonly semantics **file by file**, at their own pace
- `mutable` makes the exception **visible and intentional** — a deliberate signal in code review

This mirrors the same philosophy as JADEx's null-safety: the safe behavior is the default, and deviations must be explicit.

---

## Next Steps

| Guide | Description |
|---|---|
| [Null-Safety Guide](null-safety-guide.md) | Full reference for `Type?`, `?.`, and `?:` |
| [Basic Examples](../BasicExample.md)            | Core null-safety features in everyday Java code           |
| [Real-World Examples](../RealworldExample.md)   | Applying JADEx in a real Java project                     |
| [Spring Boot Examples](../SpringBootExample.md) | Applying JADEx in a Spring Boot project                   |
| [FAQ](faq.md) | Project Valhalla, Kotlin, performance, and more |