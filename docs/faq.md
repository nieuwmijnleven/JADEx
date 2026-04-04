# FAQ

Frequently asked questions about JADEx, its design philosophy, and how it compares to other tools and approaches.

---

## Table of Contents

- [General](#general)
- [Project Valhalla](#project-valhalla)
- [Kotlin & Other JVM Languages](#kotlin--other-jvm-languages)
- [Compatibility](#compatibility)
- [Design Philosophy](#design-philosophy)
- [Performance](#performance)

---

## General

#### Q: What exactly is JADEx?

**A:** JADEx is a **source-to-source compiler** — a Java safety layer that takes `.jadex` files (which are plain Java with optional JADEx syntax) and compiles them into standard Java source files with enhanced null-safety and readonly guarantees.

It does not replace the Java compiler. It sits in front of it, enriching your source with compile-time safety checks before handing off to `javac`.

---

#### Q: Do I have to rewrite my entire codebase to use JADEx?

**A:** No. JADEx is designed for **incremental adoption**:

- Existing `.java` files compile as-is — no changes required
- You adopt JADEx **file by file**, only where you choose to
- A `.jadex` file starts as a plain copy of a `.java` file — no syntax changes needed until you decide to add safety operators

---

#### Q: How can JADEx claim "without rewriting" when the examples show new syntax?

**A:** The key point is that **you no longer need to write repetitive null-checking boilerplate**. Consider this common pattern:

```java
// Standard Java — manual null checks
User user = userRepository.findById(id);
if (user != null &&
    user.getAddress() != null &&
    user.getAddress().getCity() != null) {
    city = user.getAddress().getCity().toUpperCase();
}
```

JADEx replaces this with a single, readable expression:

```java
// JADEx — no boilerplate
User? user = userRepository.findById(id);
String? city = user?.getAddress()?.getCity()?.toUpperCase();
```

You are not rewriting logic — you are **removing boilerplate and making intent explicit**.

---

#### Q: Is JADEx production-ready?

**A:** JADEx is in active development and is being used in real projects. That said, it is still in its early stage. We recommend:

- Starting with non-critical files to get familiar with the workflow
- Reporting any issues or unexpected behavior via [GitHub Issues](https://github.com/nieuwmijnleven/JADEx/issues)
- Following the [changelog](https://github.com/nieuwmijnleven/JADEx/releases) for breaking changes between versions

---

## Project Valhalla

#### Q: Shouldn't we just wait for Project Valhalla?

**A:** Valhalla and JADEx solve different problems and operate at different layers.

Valhalla evolves the **JVM runtime** — focusing on value types and memory layout improvements. JADEx operates at the **source code level** — focusing on null-safety and readonly semantics that are enforced at authoring time.

Even after Valhalla ships, this code will still compile and potentially crash at runtime:

```java
String s = foo();
s.length();   // NullPointerException if foo() returns null
```

In JADEx, the same problem surfaces at compile time:

```java
String s = foo();   // compile-time error if foo() is nullable
```

JADEx is not a workaround while waiting for Valhalla. It is a tool that remains valuable alongside Valhalla.

---

#### Q: How is JADEx different from Valhalla's non-null types?

**A:** Valhalla's non-null is **opt-in and conservative**:

```java
Point! p;   // Valhalla — developer must explicitly opt in
```

- Non-null must be declared explicitly at every usage site
- The default remains nullable
- Data-flow analysis across API boundaries is limited

JADEx is **non-null by default**:

```java
String name;    // JADEx — non-null (default)
String? nick;   // JADEx — nullable (explicit opt-in)
```

The practical difference is significant. With Valhalla, every type must still be doubted unless explicitly annotated. With JADEx, you only add `?` when you genuinely mean nullable.

---

#### Q: Can Valhalla and JADEx be used together?

**A:** Yes — they complement each other naturally, as they operate at different layers:

- **Valhalla** → JVM runtime, memory model, value-based objects
- **JADEx** → source-level null-safety, readonly semantics, human-readable output

After Valhalla ships, JADEx-generated code can automatically include Valhalla's `nonnull` annotations, giving developers the benefits of both tools simultaneously.

| | Valhalla | JADEx |
|---|---|---|
| Default nullability | nullable | **non-null** |
| Primary goal | Performance / modeling | **NPE elimination** |
| Target code | Mostly new code | **Legacy & new code** |
| Null-safe operators | ❌ | **`?.`, `?:`** |
| Gradual adoption | Limited | **Core design principle** |
| Output | Bytecode | **Human-readable Java** |

---

## Kotlin & Other JVM Languages

#### Q: Is JADEx trying to replace Kotlin?

**A:** No. Kotlin is a separate JVM language with its own ecosystem, tooling, and community. JADEx is a Java extension — it stays within the Java ecosystem and generates standard Java source.

The distinction matters for organizations with large Java codebases: migrating to Kotlin requires retraining, tooling changes, and often a full rewrite. JADEx lets teams add null-safety and readonly semantics to existing Java code incrementally, **without leaving Java**.

---

#### Q: If Kotlin already has null-safety, why use JADEx?

**A:** Kotlin's null-safety is excellent — but adopting Kotlin means adopting a new language. For many teams, that is not a viable option due to:

- Existing Java codebase size
- Team familiarity and hiring considerations
- Framework and tooling compatibility constraints

JADEx brings the most impactful parts of Kotlin's null-safety — `Type?`, `?.`, `?:` — directly into Java, with zero language switch required.

---

#### Q: How does JADEx compare to annotation-based tools like NullAway or Checker Framework?

**A:** Annotation-based tools are valuable, but they require **manual annotation of every nullable type** across your entire codebase:

```java
// NullAway / Checker Framework approach
@Nullable String name;
@NonNull String email;
```

JADEx takes the opposite approach: **non-null is the default**, and nullable is the explicit exception. This means far less annotation noise and a cleaner signal-to-noise ratio in code reviews.

Additionally, JADEx's `?.` and `?:` operators replace verbose null-checking boilerplate that annotations alone cannot eliminate.

JADEx also generates JSpecify annotations in its output, meaning it is **fully compatible** with NullAway and Checker Framework as a downstream consumer.

---

## Compatibility

#### Q: Can JADEx and standard Java files coexist in the same project?

**A:** Yes. Standard `.java` files are completely unaffected by JADEx. The Gradle plugin only processes `.jadex` files, leaving your existing Java compilation pipeline intact.

---

#### Q: Does JADEx work with Spring Boot and Lombok?

**A:** Yes. JADEx integrates with both:

- **Spring Boot**: JADEx-generated Java is standard Java, fully compatible with Spring's annotation processing and dependency injection
- **Lombok**: JADEx supports a Delombok pipeline that processes Lombok annotations before JADEx analysis, ensuring accurate null-safety checking over Lombok-generated code

---

#### Q: Does JADEx support Java frameworks that rely on mutability (e.g., JPA entities)?

**A:** Yes. The `apply readonly;` directive is **opt-in and file-scoped**. For classes that require mutability by design (JPA entities, Spring beans, etc.), simply do not add `apply readonly;` to those files, or use the `mutable` modifier selectively.

---

#### Q: Does JADEx attempt to transform Java into a fully sound null-safe type system?

**A:** No. JADEx is a **practical tool**, not a theoretical exercise. It does not attempt to achieve full soundness across all API boundaries or enforce null contracts on third-party libraries.

The goal is to make the common cases — field assignments, local variables, method chaining — significantly safer with minimal friction, while preserving the existing Java ecosystem.

---

## Design Philosophy

#### Q: Why `Type?` instead of `@Nullable Type`?

**A:** Annotation-based nullability (`@Nullable`) requires a separate import, adds visual noise, and still relies on the developer remembering to annotate. More importantly, it does not change the **default** — every unannotated type is still implicitly nullable.

`Type?` is a **type-level marker** that makes nullability part of the type itself. Combined with non-null by default, it gives a clear, consistent model: if there is no `?`, the value is guaranteed non-null.

---

#### Q: Why `apply readonly;` instead of a class-level modifier like `readonly class`?

**A:** `apply readonly;` is a **file-level directive** that applies to all fields, local variables, and parameters within the file — not just fields. A class-level modifier like `readonly class` would only naturally imply field-level readonly, leaving local variables and parameters outside its scope.

`apply readonly;` makes the scope unambiguous: everything in this file is `final` by default, and deviations are explicitly marked with `mutable`.

---

#### Q: Why is readonly opt-in but null-safety is enforced by default?

**A:** The two features have fundamentally different risk profiles:

- **Null** is the source of one of the most common and costly bugs in Java — `NullPointerException`. Making non-null the default catches real bugs immediately.
- **Mutability** is often intentional and necessary (JPA entities, accumulators, counters). Forcing `final` everywhere would break legitimate patterns and make migration painful.

Non-null by default is enforced because the cost of the wrong default (NPE in production) is high. Final by default is opt-in because the cost of the wrong default (overly restrictive code) is also high, but in the opposite direction.

---

## Performance

#### Q: Does JADEx add any runtime overhead?

**A:** No. JADEx operates entirely at the **source code level**. It generates standard Java source files, which are then compiled by `javac` as usual. There is no JADEx runtime agent, no bytecode instrumentation, and no reflection involved.

The generated code is identical to what a careful Java developer would write by hand — with `final` modifiers, JSpecify annotations, and explicit null checks via `SafeAccess<T>`.

---

#### Q: Does `SafeAccess<T>` add overhead compared to manual null checks?

**A:** `SafeAccess<T>` is a lightweight utility class. In practice, the JVM's JIT compiler inlines and optimizes these calls effectively, producing performance equivalent to hand-written null checks. There is no measurable overhead in typical application code.

---

## Next Steps

| Guide | Description |
|---|---|
| [Getting Started](getting-started.md) | Install JADEx and write your first `.jadex` file |
| [Null-Safety Guide](null-safety-guide.md) | Full reference for `Type?`, `?.`, and `?:` |
| [Readonly Guide](readonly-guide.md) | Full reference for `apply readonly;` and `mutable` |
| [Basic Examples](../BasicExample.md)            | Core null-safety features in everyday Java code           |
| [Real-World Examples](../RealworldExample.md)   | Applying JADEx in a real Java project                     |
| [Spring Boot Examples](../SpringBootExample.md) | Applying JADEx in a Spring Boot project                   |
