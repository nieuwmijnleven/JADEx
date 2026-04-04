# Null-Safety Guide

JADEx makes nullability **explicit at the type level** and enforces it at **compile time**. This guide covers all null-safety operators and rules with complete examples.

---

## Core Concepts

### The Problem with Java's Null

In standard Java, every reference type is implicitly nullable — meaning any variable can be `null` at any time, and the compiler won't warn you:

```java
String name = null;       // compiles fine
name.length();            // NullPointerException at runtime
```

The only way to avoid this is to write defensive null checks everywhere, which leads to verbose, error-prone boilerplate.

### JADEx's Approach: Non-Null by Default

JADEx flips the default. Every type is **non-nullable unless explicitly marked otherwise**:

```java
String name = null;    // ❌ compile-time error
String? name = null;   // ✅ explicitly nullable
```

This means you only add `?` when you actually mean nullable — exactly like Kotlin or modern Swift — while staying in the Java ecosystem.

---

## Syntax Reference

| Syntax | Meaning | Example |
|---|---|---|
| `Type` | Non-nullable (default) | `String name` |
| `Type?` | Nullable | `String? name` |
| `?.` | Null-safe access operator | `user?.getName()` |
| `?:` | Elvis operator (fallback value) | `name ?: "Anonymous"` |

---

## Examples

### Example ① — Compile-Time Null Assignment Check

JADEx catches invalid null assignments at compile time, before they reach production.

```java
public class Main {
    public static void main(String[] args) {
        String? s1 = null;   // ✅ nullable — allowed
        String  s2 = null;   // ❌ non-nullable — compile-time error
    }
}
```

**Output**

```
Warning: (line:4, column:8) s2 is a non-nullable variable. But null value is assigned to it.
```

---

### Example ② — Enforcing the Null-Safe Operator (`?.`)

When accessing methods or fields on a nullable variable, JADEx **requires** the use of the null-safe operator `?.`. Direct access causes a compile-time error.

```java
public class Main {
    public static void main(String[] args) {
        String? s1 = null;
        String  s2 = "JADEx";

        s1.length();    // ❌ compile-time error: s1 is nullable
        s2.length();    // ✅ allowed: s2 is non-nullable
    }
}
```

**Output**

```
Warning: (line:6, column:8) s1 is a nullable variable. But it direct accesses to length(). You must consider to use null-safe operator(?.)
```

**Corrected Code**

```java
s1?.length();   // ✅ null-safe access
s2.length();    // ✅ regular access
```

---

### Example ③ — Elvis Operator (`?:`)

The Elvis operator `?:` provides a fallback value when a nullable expression evaluates to `null`.

```java
package jadex.example;

public class Main {
    public static void main(String[] args) {
        String? s1 = null;
        String s2 = s1 ?: "JADEx";
        System.out.printf("s1 = %s\n", s1 ?: "null-value");
        System.out.printf("s2 = %s\n", s2);
    }
}
```

- `s1 ?: "JADEx"` → assigns `"JADEx"` because `s1` is `null`
- `s1 ?: "null-value"` → prints `"null-value"` safely

**Generated Java**

```java
package jadex.example;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import jadex.runtime.SafeAccess;

@NullMarked
public class Main {
    public static void main(String[] args) {
        @Nullable String s1 = null;
        String s2 = SafeAccess.ofNullable(s1).orElseGet(() -> "JADEx");
        System.out.printf("s1 = %s\n", SafeAccess.ofNullable(s1).orElseGet(() -> "null-value"));
        System.out.printf("s2 = %s\n", s2);
    }
}
```

---

### Example ④ — Null-Safe Operator (`?.`) in Practice

`?.` safely calls a method on a nullable variable. If the variable is `null`, the entire expression evaluates to `null` instead of throwing a `NullPointerException`.

```java
public class Main {
    public static void main(String[] args) {
        String? s1 = null;
        String  s2 = "JADEx";
        System.out.printf("the length of s1 : %d\n", s1?.length());
        System.out.printf("the length of s2 : %d\n", s2.length());
    }
}
```

- `s1?.length()` → safely returns `null` if `s1` is `null`
- `s2.length()` → regular access, no null check needed

**Generated Java**

```java
package jadex.example;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import jadex.runtime.SafeAccess;

@NullMarked
public class Main {
    public static void main(String[] args) {
        @Nullable String s1 = null;
        String s2 = "JADEx";
        System.out.printf("the length of s1 : %d\n", SafeAccess.ofNullable(s1).map(t0 -> t0.length()).orElse(null));
        System.out.printf("the length of s2 : %d\n", s2.length());
    }
}
```

---

### Example ⑤ — Combining `?.` and `?:`

`?.` and `?:` can be combined to express complex null-handling logic in a single, readable expression.

```java
package jadex.example;

public class Main {
    public static void main(String[] args) {
        String? s1 = null;
        String s2 = s1 ?: "JADEx";
        System.out.printf("the length of s1 : %d\n", s1?.length() ?: 0);
        System.out.printf("the length of s2 : %d\n", s2.length());
    }
}
```

- `s1?.length() ?: 0` → calls `length()` safely; returns `0` if `s1` is `null`

**Generated Java**

```java
package jadex.example;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import jadex.runtime.SafeAccess;

@NullMarked
public class Main {
    public static void main(String[] args) {
        @Nullable String s1 = null;
        String s2 = SafeAccess.ofNullable(s1).orElseGet(() -> "JADEx");
        System.out.printf("the length of s1 : %d\n", SafeAccess.ofNullable(s1).map(t0 -> t0.length()).orElseGet(() -> 0));
        System.out.printf("the length of s2 : %d\n", s2.length());
    }
}
```

---

### Example ⑥ — Real-World Null-Safe Chaining

This is where JADEx's operators shine most — deeply chained method calls that would otherwise require multiple nested null checks.

```java
// Before (standard Java)
User user = userRepository.findById(id);
String city = null;
if (user != null &&
    user.getAddress() != null &&
    user.getAddress().getCity() != null) {
    city = user.getAddress().getCity().toUpperCase();
}

// After (JADEx)
User? user = userRepository.findById(id);
String? city = user?.getAddress()?.getCity()?.toUpperCase();
```

Same null-safety guarantee. No boilerplate.

---

## Rules Summary

| Situation | Required |
|---|---|
| Assigning `null` to a variable | Variable must be declared as `Type?` |
| Accessing a method/field on a nullable variable | Must use `?.` |
| Providing a fallback when expression may be `null` | Use `?:` |
| Passing a nullable value to a non-nullable parameter | Compile-time error |

---

## Generated Java — What Happens Under the Hood

JADEx generates standard Java using **JSpecify annotations** and **`SafeAccess<T>`** (JADEx's runtime utility):

| JADEx | Generated Java |
|---|---|
| `String name` | `@NullMarked` context + plain `String name` |
| `String? name` | `@Nullable String name` |
| `x?.method()` | `SafeAccess.ofNullable(x).map(t -> t.method()).orElse(null)` |
| `x ?: fallback` | `SafeAccess.ofNullable(x).orElseGet(() -> fallback)` |
| `x?.method() ?: fallback` | `SafeAccess.ofNullable(x).map(t -> t.method()).orElseGet(() -> fallback)` |

This means the generated code is **fully compatible with NullAway, Checker Framework, and any JSpecify-aware tooling**.

---

## Next Steps

| Guide | Description |
|---|---|
| [Readonly Guide](readonly-guide.md) | Add `final-by-default` semantics with `apply readonly;` |
| [Basic Examples](../BasicExample.md)            | Core null-safety features in everyday Java code           |
| [Real-World Examples](../RealworldExample.md)   | Applying JADEx in a real Java project                     |
| [Spring Boot Examples](../SpringBootExample.md) | Applying JADEx in a Spring Boot project                   |
| [FAQ](faq.md) | Project Valhalla, Kotlin, performance, and more |