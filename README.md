<p align="center">
  <img src="https://raw.githubusercontent.com/nieuwmijnleven/JPlus/refs/heads/master/intellij-plugin/src/main/resources/META-INF/pluginIcon.svg" alt="Logo" width="200">
</p>

[![License](https://img.shields.io/badge/License-GPL_v2_only_%2B_Commercial-blue.svg)](https://opensource.org/licenses/GPL-2.0-only)

# <img src="https://raw.githubusercontent.com/nieuwmijnleven/JPlus/refs/heads/master/intellij-plugin/src/main/resources/META-INF/pluginIcon.svg" alt="Logo" width="25" style="vertical-align: middle;"> JADEx - Same Java, Just safer

JADEx (Java Advanced Development Extension) is a practical **Java safety layer** that enhances the safety of your code by providing **null-safety** and **readonly(final-by-default)** enforcement. It strengthens Java’s type system without requiring a full rewrite, while fully leveraging existing Java libraries and tools.

---

## ✨ Project Overview

### Key Idea

* JADEx is a **Java safety layer** that strengthens the language’s type system by enforcing **null-safety** and **readonly (final-by-default)** semantics. It brings compile-time guarantees to your existing Java code without requiring a full rewrite, while fully leveraging existing Java libraries and tools.

    			+---------------------------+
    			|       Existing Java       |
    			| (potentially unsafe)      |
    			+------------+--------------+
    					 	 |
    					 	 v
    	+----------------------------------------+
    	|       JADEx (Java Safety Layer)        |
    	| (strengthens type system, applies      |
    	|  null-safety operators & readonly)     |
    	+------------------+---------------------+
    						 |
    						 v
    		    +---------------------------+
    		    |   Safe & Robust Java Code |
    		    | (compile-time enforcement |
    		    | of null-safety & readonly)|
    		    +---------------------------+

> **JADEx is not designed to replace Java. It acts as a practical Java safety layer, strengthening Java’s null-related type system and providing optional readonly semantics, all without leaving the existing Java ecosystem**.

### Key Benefits

* Familiar Syntax: **No new language to learn, just safer Java.**
* Seamless Integration: Works with existing Java projects with minimal changes.
* Incremental Adoption: Apply null-safety only where you need it.
* Enhanced Code Safety: Catch potential null-pointer issues at compile time, not runtime.

> **JADEx makes your Java code safer, more maintainable, and future-proof without compromise**.

### Workflow (with JADEx IntelliJ Plugin and Gradle Plugin)

The typical JADEx workflow for producing Java source code with enhanced null-safety guarantees is as follows:

```
           << JAVA SOURCE >>
                   ↓
     << COPIED AS-IS TO .JADEX >>
                   ↓
           << JADEX SOURCE >>
                   ↓
     << JADEX NULL-SAFETY ANALYSIS >>
                   ↓
         << REVIEW THE RESULTS >>
                   ↓
   << APPLY JADEX NULL-SAFETY OPERATORS >>
                   ↓
           << JADEX COMPILER >>
                   ↓
   << JAVA SOURCE WITH ENHANCED NULL-SAFETY >>

```

* Existing Java source files are copied unchanged into `.jadex` files. JADEx null-safety operators are then applied to the JADEx sources to explicitly annotate and enforce null-safety semantics. These annotated JADEx sources are subsequently compiled by the JADEx compiler into Java source code with enhanced null-safety guarantees.

* Essentially, **all you need to do is review the null-safety analysis results and apply the null-safety operators** in your `.jadex` files. The JADEx IntelliJ plugin takes care of the rest automatically.

---

## Installation

### JADEx IntelliJ Plugin Installation
The JADEx IntelliJ plugin allows you to easily analyze your Java code and apply null-safety operators without leaving your familiar IDE. Follow the steps below to install it.

**Prerequisites**

- above JDK(Java Development Kit) 21**
- above IntelliJ 2025.2

**Installation from Jetbrains Marketplace**

![image](https://github.com/user-attachments/assets/32afb71b-7e19-4a8f-a3f0-a1d5ec337b1d)

* Step1: Launch your IntelliJ IDEA IDE.
* Step2: Navigate to File → Settings → Plugins → Marketplace.
* Step3: Type **`JADEx`** in the search bar and locate the plugin.
* Step4: Click Install and wait for the installation to complete.
* Step5: Restart your IDE to activate the plugin.

**(Alternative) Manual Installation**

- Download [intellij-plugin-0.26.zip](https://github.com/user-attachments/files/25161928/intellij-plugin-0.26.zip)
- Open IntelliJ
- Go to `File > Settings > Plugin > ⚙️ > Install Plugin from Disk`
- Select the downloaded `intellij-plugin-0.26.zip`
- Restart IntelliJ

---

### JADEx Gradle Plugin Installation

The JADEx Gradle plugin allows you to compile `.jadex` files into standard Java source files as part of your existing Gradle build pipeline.

**Prerequisites**

- JDK 21 or above
- Gradle 8.0 or above

**Installation**

Add the plugin to your `build.gradle`:
```groovy
plugins {
    id 'io.github.nieuwmijnleven.jadex' version '0.14'
}
```

Or in `build.gradle.kts`:
```kotlin
plugins {
    id("io.github.nieuwmijnleven.jadex") version "0.14"
}
```

**Available Tasks**

| Task | Description |
|---|---|
| `compileJadex` | Compiles `.jadex` source files into standard Java source files with enhanced null-safety |

**Basic Usage**

Place your `.jadex` files under `src/main/jadex`, then run:
```bash
./gradlew compileJadex
```

The generated Java source files will be output to
`build/generated/sources/jadex/main/java` and automatically included
in subsequent Java compilation.

The generated Java source files will be output to the build directory and automatically included in subsequent Java compilation.

**(Optional) Custom Configuration**

To override the default source or output directory, add a `jadex` block to your `build.gradle`:
```groovy
jadex {
    sourceDir = "src/main/jadex"
    outputDir = "build/generated/sources/jadex/main/java"
}
```

Or in `build.gradle.kts`:
```kotlin
jadex {
    sourceDir = "src/main/jadex"
    outputDir = "build/generated/sources/jadex/main/java"
}
```

> **Tip:** Use the Gradle plugin in your CI/CD pipeline to enforce null-safety checks and readonly semantics on every build, and the IntelliJ plugin locally for interactive analysis and operator application.

---

## 💡 How to make your java code null-safe

Making your existing Java code null-safe with JADEx is simple and straightforward. The process guides you from analyzing potential null-pointer issues to applying null-safety operators, and finally generating safe, standard Java code without rewriting your code or leaving the Java ecosystem.

### 📚 Essential Examples
- Simple, focused examples showing how to use JADEx null-safety operators.

#### ✅ Example ① - Compile-time null assignment check

JADEx explicitly defines nullability at the type system level and performs **compile-time checks**  
to eliminate the possibility of `NullPointerException` at runtime.

#### 📌 Basic Rules

- `Type` → **non-nullable** (cannot be assigned `null`)
- `Type?` → **nullable** (can be assigned `null`)
- `?.` → safely access methods or fields on nullable objects
- `?:` → elvis operator: returns the left-hand side if non-null, otherwise the right-hand side (x ?: y ≡ (x != null) ? x : y)

#### 📄 Example – `NullableType1.jadex`

```java
public class Main {
    public static void main(String[] args) {
        String? s1 = null;
        String s2 = null;
    }
}
```

- `s1` is a **nullable** variable and can be assigned `null`.
- `s2` is a **non-nullable** variable, so assigning `null` causes a **compile-time error**.

#### ❌ Output

```
Warning: (line:6, column:8) s2 is a non-nullable variable. But null value is assigned to it.
```
---

### ✅ Example ② — Enforcing the null-safe operator (`?.`)

In JADEx, **you must use the `?.` operator when accessing nullable variables.**  
If you try to access fields or methods on a potentially-null object without the null-safe operator, a compile-time error will occur.


#### 📄 Example – `NullableType2.jadex`

```java
public class Main {
    public static void main(String[] args) {
        String? s1 = null;
        String s2 = "JADEx";

        s1.length();
        s2.length();
    }
}
```

- `s1` is **nullable** but tries to call a method **without using the null-safe operator (`?.`)**  
  → **Compile-time error**

- `s2` is **non-nullable**, so method access is allowed without issue


#### ❌ Output

```
Warning: (line:8, column:8) s1 is a nullable variable. But it direct accesses to length(). You must consider to use null-safe operator(?.)
```

#### ✅ Corrected Code (Works as Expected)

```java
s1?.length(); // null-safe access
s2.length();  // regular access
```

As shown above, JADEx **enforces safe access to nullable variables at the language level**,  
helping to eliminate null-related runtime errors before they happen.

---
### ✅ Example ③ — Elvis Operator (`?:`)

JADEx introduces the **Elvis operator (`?:`)**,  
which allows you to easily provide a default or fallback value when a nullable variable is `null`.

#### 📄 Example – `ElvisOperator.jadex`

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

- `s1` is a nullable variable.
- `s1 ?: "JADEx"` assigns `"JADEx"` if `s1` is `null`.
- When printing, `s1 ?: "null-value"` safely handles null values.

#### ✅ Output (Java code generated by JADEx)

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
### ✅ Example ④ — Correct Usage of the Null-safe Operator (`?.`)

In JADEx, the use of the **null-safe access operator (`?.`) is enforced** for nullable variables.  
This prevents null reference errors and allows safe method calls on potentially null values.

#### 📄 Example – `NullsafeOperator.jadex`

```java
public class Main {
    public static void main(String[] args) {
        String? s1 = null;
        String s2 = "JADEx";
        System.out.printf("the length of s1 : %d\n", s1?.length());
        System.out.printf("the length of s2 : %d\n", s2.length());
    }
}
```

- `s1` is a nullable variable.
- `s1?.length()` safely returns `null` if `s1` is `null`.
- `s2` is non-nullable, so calling `length()` is valid without safety checks.

#### ✅ Output (Java code generated by JADEx)

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

This example demonstrates how JADEX handles the null-safe operator for nullable variables  
and clearly shows how to write code that adheres to JADEx's null safety rules.

---
### ✅ Example ⑤ — Combining `?.` and `?:` Operators

JADEx supports **combining the null-safe access operator (`?.`) and the Elvis operator (`?:`)**  
to simplify complex null-handling logic into clean and concise expressions.

#### 📄 Example – `NullsafeWithElvisOperator.jadex`

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

- `s1` is a nullable variable.
- `s1 ?: "JADEx"` → assigns `"JADEx"` if `s1` is null.
- `s1?.length() ?: 0` → safely calls `length()` on `s1`, returns `0` if `s1` is null.
- By combining both operators, **null handling becomes safe and concise**.

#### ✅ Output (Java code generated by JADEx)

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

> The expression `s1?.length() ?: 0` is translated into a nested conditional check in Java:  
> `jadex.runtime.SafeAccess.ofNullable(s1).map(t0 -> t0.length()).orElseGet(() -> 0)`, ensuring safe execution.

#### 📌 Summary

This example demonstrates a **natural combination** of the following features:

- ✅ **Null-safe method call** (`s1?.length()`)  
  Ensures safe access to nullable variables without throwing `NullPointerException`.

- ✅ **Default fallback value** (`?: 0`)  
  Provides a default value when an expression evaluates to `null`, improving code safety and readability.

JADEx allows even complex null-handling logic to be expressed **safely and concisely** with its extended syntax.

---

### 📚 Basic Examples

- Hands-on examples that demonstrate the core JADEx null-safety features in everyday Java code.  
  These examples focus on common patterns such as nullable fields, safe access (`?.`), and evis operator (`?:`) to help you quickly understand how to write null-safe code with JADEx.

  [Making Your Java Code Null-Safe without Rewriting it](https://github.com/nieuwmijnleven/JADEx/blob/master/BasicExample.md)

---

### 📚 Real-World Examples

- This section demonstrates how to apply **JADEx** to a larger, real-world Java codebase and resolve null-safety issues reported by the tool.

  [Applying JADEx to a Real Java Project: Making OntheGoDataBase Null-Safe](https://github.com/nieuwmijnleven/JADEx/blob/master/RealworldExample.md)

---

## 💡 How to make your Java code readonly

JADEx allows you to optionally make fields, local variables, and method parameters **readonly (final-by-default)**. This helps prevent accidental reassignment and enforces immutability where you choose to apply it.

The process is straightforward:

1. Mark your code with `apply readonly`.
2. JADEx analyzes your code and applies `final` modifiers where appropriate.
3. Generates standard Java code with readonly enforcement, fully compatible with existing Java libraries and tooling.

> **This approach provides a flexible safety layer, allowing you to adopt readonly semantics incrementally without rewriting your existing Java code.**

---

### 📚 Essential Examples
- Simple, focused examples showing how to use JADEx readonly feature

#### ✅ Example ① - Basic Field Readonly

```java
package jadex.example;

apply readonly;

public class Example1 {
    private int count = 0;        // readonly
    private String? name = "JADEx"; // readonly

    public static void main(String[] args) {
        var example = new Example1();
        example.count = 10; // error: readonly
        example.name = "New"; // error: readonly
    }
}
```

#### ✅ Output (Java code generated by JADEx)

```java
package jadex.example;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import jadex.runtime.SafeAccess;

//apply readonly;

@NullMarked
public class Example1 {
    private final int count = 0;        // readonly
    private final @Nullable String name = "JADEx"; // readonly

    public static void main(final String[] args) {
        final var example = new Example1();
        example.count = 10; // error: readonly
        example.name = "New"; // error: readonly
    }
}
```
---

#### ✅ Example ② - Mutable Fields

```java
apply readonly;

public class Example2 {
    private mutable int temp = 5; // mutable
    private mutable String? note = "mutable"; // mutable

    public static void main(String[] args) {
        var example = new Example2();
        example.temp = 10;       // allowed
        example.note = "updated"; // allowed
    }
}
```

#### ✅ Output (Java code generated by JADEx)

```java
package jadex.example;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import jadex.runtime.SafeAccess;

//apply readonly;

@NullMarked
public class Example2 {
    private int temp = 5; // mutable
    private @Nullable String note = "mutable"; // mutable

    public static void main(final String[] args) {
        final var example = new Example2();
        example.temp = 10;       // allowed
        example.note = "updated"; // allowed
    }
}
```

---

#### ✅ Example ③ - Readonly Method Parameters

```java
apply readonly;

public class Example3 {

    public static void process(String? readonlyParam, mutable String? mutableParam) {
        readonlyParam = "change"; // error: readonly
        mutableParam = "change";  // allowed
    }

    public static void main(String[] args) {
        String? msg = "hello";
        process(msg, msg);
    }
}
```

#### ✅ Output (Java code generated by JADEx)

```java
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import jadex.runtime.SafeAccess;

//apply readonly;

@NullMarked
public class Example3 {

    public static void process(final @Nullable String readonlyParam, @Nullable String mutableParam) {
        readonlyParam = "change"; // error: readonly
        mutableParam = "change";  // allowed
    }

    public static void main(final String[] args) {
        final @Nullable String msg = "hello";
        process(msg, msg);
    }
}
```
---

## FAQ

#### Q: Shouldn’t we just wait for Project Valhalla?

**A:** Valhalla is the future of the JVM and JADEx lets you experience Valhalla-style null-safety in today’s Java.

However, JADEx is not a temporary workaround while waiting for Valhalla. It is a tool that remains valuable even after Valhalla arrives.

From a null-safety perspective, the key difference is this:
- **Valhalla helps you avoid null**. it does not eliminate null.
- **JADEx makes NPEs structurally impossible to write**.

|                     | Valhalla               | JADEx                     |
| ------------------- | ---------------------- | ------------------------- |
| Default             | nullable               | **non-null**              |
| Primary goal        | Performance / modeling | **NPE elimination**       |
| Target code         | Mostly new code        | **Legacy code**           |
| Null-safe operators | ❌                      | **`?.`, `?:`**            |
| Gradual adoption    | Limited                | **Core design principle** |
| Output focus        | Bytecode               | **Human-readable Java**   |

Even after Valhalla ships:

```
String s = foo();
s.length();
```

This code will still:
- Compile successfully
- Potentially crash at runtime
- Exist across billions of lines of legacy Java

> **Valhalla does not infer or enforce null contracts in existing APIs.**

In JADEx,

```
String s = foo(); // compile-time error if foo() is nullable
```

> **The problem surfaces at authoring time, not in production.**


---

#### Q: How is this different from Valhalla’s non-null types?

**A:** ① Valhalla’s **non-null is opt-in and conservative**

```java
Point! p;
```

* Developers must explicitly opt in
* Data-flow analysis is limited
* It does not change Java as a whole

👉 **The default is still nullable**

> In other words, Valhalla introduces non-null selectively, without redefining Java’s baseline assumptions.

② JADEx is **non-null by default**

```java
String name;    // non-null
String? nick;   // nullable
```

This difference is immediately noticeable in daily development.

> **“Java, where every type must be doubted”**
> vs.
> **“JADEx, where you only add ? when you actually mean nullable”**

---

#### Q: Can Valhalla and JADEx Be Used Together?

**A:** **Absolutely. In fact, they are an ideal combination.**

**1. Clear Separation of Responsibilities**

- **Project Valhalla**
    - Evolves the JVM’s runtime and memory model
    - Introduces **value-based objects** for better performance
    - Supports **enhanced type annotations**, such as `nonnull`, at the JVM level

- **JADEx**
    - Enhances **null-safety and type safety** at the source code level
    - Generates plain Java code that is **fully compatible** with existing JVM features


**2. Why They Work Well Together**

- **No conflicts arise** between Valhalla and JADEx; they operate at different layers:
    - Valhalla → runtime and memory optimizations (JVM Level)
    - JADEx → source-level null-safety and expressiveness (Source Code Level)

- After Valhalla is released, JADEx-generated code **can include Valhalla’s `nonnull` annotations** automatically.
    - This means that developers **gain clear, explicit information about which types are nullable or non-nullable** directly in the source code.

    - As a result, developers can write safer and more predictable code, **confidently knowing which variables can or cannot be null**, without extra manual annotations or runtime checks.


- Neither project replaces the other; instead, they **complement each other**, improving both **performance** and **developer productivity**.


---

#### Q: Can JADEx and Java coexist in the same project?

**A:** Yes.

- **Unmodified Java files** continue to **compile as-is** without any changes.
- **JADEx features** can be **enabled incrementally**, allowing developers to adopt them **file by file**.
- This approach makes it easy to **gradually introduce null-safety** into an existing Java codebase without disrupting existing functionality.

---

#### Q: Does JADEx attempt to transform Java into a fully sound null-safe type language?

**A:** JADEx is not an attempt to redesign Java into a theoretically sound null-safe type system, nor is it trying to create a world where "Optional wins".

The goal of JADEx is to provide a practical tool that incrementally strengthens null-safety at the source-code level, while preserving the existing Java ecosystem.

---

#### Q: Is JADEx Optional-based?

**A:** JADEx does not enforce the use of Optional and does not attempt to redefine existing APIs.

Instead, it makes nullability explicit at the usage boundary and enforces safe access through operators like ?. and ?:.

---

#### Q: Is JADEx trying to replace Kotlin or Java?

**A:** No.

- **Kotlin** : a separate JVM language, designed independently
- **JADEx** : a **Java language extension**, enhancing Java with **null-safety and type expressiveness**

**Key Point:**  
JADEx does **not aim to replace Java**; it simply **extends Java**, making it safer and more expressive while staying fully compatible with existing Java code.


---

#### Q: What about performance?

**A:** JADEx operates at the **source code level**, producing **Java source files with enhanced null-safety**.

- The workflow generates **standard Java constructs**, enhanced with null-safety operators.
- JADEx itself **does not generate bytecode**; the resulting Java source is then compiled using a **regular Java compiler**.
- Since JADEx only modifies source code, there is **no runtime overhead** beyond what a developer would write manually.

**Key Point:**
- JADEx improves **null-safety at the source level**, **without affecting runtime performance**.
- Developers can safely adopt JADEx while ensuring that the resulting code runs as efficiently as standard Java code.

---

#### Q: How can you say "enhance your code’s safety and without rewriting it" when in all of the examples there require new syntax to make it work.
**A:** The main point is that **you no longer need to write repetitive boilerplate code to handle null values**.

**Original Code Example**

Consider the following code:

```java
User user = userRepository.findById(id);
String city = user.getAddress().getCity().toUpperCase();
````

Potential points where a **NullPointerException (NPE)** can occur:

* `user`
* `user.getAddress()`
* `user.getAddress().getCity()`

**Typical Null Handling Approach**

To prevent NPEs, developers usually write multiple null checks:

```java
if (user != null &&
    user.getAddress() != null &&
    user.getAddress().getCity() != null) {
    city = user.getAddress().getCity().toUpperCase();
}
```

This approach works but is verbose and introduces repetitive boilerplate code.

**Using JADEx Null-safe Access Operator**

JADEx provides a **null-safe access operator (`?.`)**, which allows you to simplify the code:

```java
User? user = userRepository.findById(id);
String? city = user?.getAddress()?.getCity()?.toUpperCase();
```

The operator automatically generates the necessary null checks internally.

**Conclusion**

* No need to manually write repetitive null-checking code.
* Code becomes cleaner and more readable.
* The developer's burden for null handling is greatly reduced.

---

## 🤝 Sponsorship & Support

JADEx is currently in its early stage, and your support can make a big difference in shaping its future.

- **Report bugs, suggest features, and contribute code** : every contribution helps!
- **By sponsoring, you help accelerate development and gain early access to new features.**
- We are preparing exclusive perks for sponsors as a token of our gratitude.

If you want to support the project financially, please visit our sponsorship page:

[Become a Sponsor via Github](https://github.com/sponsors/nieuwmijnleven)

[Become a Sponsor via PayPal.me](https://paypal.me/nieuwmijnleven)

Thank you for helping us build a better, safer, and more productive programming tools!

---

## 🌟 Thanks to my sponsor!

Special thanks to [@shocklateboy92](https://github.com/shocklateboy92) for supporting this project through GitHub Sponsors!

---
