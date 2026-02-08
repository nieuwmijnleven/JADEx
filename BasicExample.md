Null-pointer exceptions are a common error in Java, causing inconvenience for many developers. Preventing null pointer exceptions in advance is important, but for developers who want to focus solely on logic, handling them can be tedious. Moreover, it’s not always easy to account for every scenario. Typically, static analysis tools are used to detect potential null pointer issues, but developers still have to find and fix the code themselves. JADEx reduces that burden. Let’s write null-safe Java code with JADEx.

---

## JADEx GitHub repository

https://github.com/nieuwmijnleven/JADEx

---

## JADEx IntelliJ plugin Installation

#### Installation From Jetbrains MarketPlace

![image](https://github.com/user-attachments/assets/32afb71b-7e19-4a8f-a3f0-a1d5ec337b1d)

- Open IntelliJ
- Go to `File > Settings > Plugins > Marketplace`
- Type **`JADEx`** in the search bar and locate the plugin
- Click Install and wait for the installation to complete
- Restart IntelliJ

#### (Alternative) Manual Installation

- Download [intellij-plugin-0.26.zip](https://github.com/user-attachments/files/25161928/intellij-plugin-0.26.zip)
- Open IntelliJ
- Go to `File > Settings > Plugin > ⚙️ > Install Plugin from Disk`
- Select the downloaded `intellij-plugin-0.25.zip`
- Restart IntelliJ


---

## Open the example project in IntelliJ
- Go to `File > New > Project from Version Control`
- Enter `https://github.com/nieuwmijnleven/JADExExample`
- Click the `Clone` button

![image](https://github.com/user-attachments/assets/3235169a-dc70-472a-ba52-8e99d412690b)

---

## Create a JADEx file for User.java in the Project View
- Right-click User.java in the Project View
- Select Convert Java File to JADEx File from the menu

![image](https://github.com/user-attachments/assets/b0d50215-0746-41d2-b2e6-e60528d9da95)

---

#### User.jadex
```java
package JADEx.example;

class User {
    // Name is required
    String name;        
    // Address can be null
    Address address;   

    User(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    //remain codes
}
```

Opening the generated `User.jadex` file, you can see warning messages in the Problems tab.

![image](https://github.com/user-attachments/assets/944c5eb5-81dc-4389-97c7-8280b35d2548)

By default, **JADEx assumes all reference types are non-nullable**, which causes these warnings. The problematic parts are where the constructors of the User and Address classes are called.

```java
User(String name, Address address) {
    this.name = name;
    this.address = address;
}

Address(String city) {
    this.city = city;
}

User user1 = new User("Jeroen", new Address("New Amsterdam"));
User user2 = new User("Jane Smith", null);
User user3 = new User(null, new Address(null));
```
- The constructor parameters for User and Address are all non-nullable. Passing null violates the null-safety rules.
- Therefore, warnings occur for user2 and user3.

---

## Making Java code null-safe with JADEx
 
#### (1) Assume the address field is nullable
- Add ? to the Address type
- Also mark the constructor parameter as nullable

```java
package JADEx.example;

class User {
    // Name is required
    final String name;
    // Address can be null
    Address? address;

    User(String name, Address? address) {
        this.name = name;
        this.address = address;
    }
```

The Problems tab shows:
- The method(getCity) is declared to return a non-null value, but this return statement may return null.
- address is a nullable variable. But it directly accesses city. Consider using null-safe operator(?.)

![image](https://github.com/user-attachments/assets/f7b3ab34-26b5-4858-bac9-70617278cb6e)


- Use the null-safe operator ?.:
- Add ? to the return type (String) of method getCity.
```java
    // Safely get the city name of the address
    String? getCity() {
        return address?.city;
    }

```

Then only the constructor-related warning for name remains. 

![image](https://github.com/user-attachments/assets/4b3c5a81-9667-4829-83d1-5b6c64485b00)

Replace null with "No Name" because name field is required.

```java
User user3 = new User("No Name", new Address(null));
```

Now only one warning remains:
- The 1st argument of the Address constructor is a non-nullable variable, but a null value is assigned to it.

![image](https://github.com/user-attachments/assets/148921bc-b542-4979-bf33-681799db5317)

---

**(3) Assume city in Address is nullable**
- Add ? to String type and constructor parameter

```java
static class Address {
    // City can be null
    String? city;

    Address(String? city) {
        this.city = city;
    }
}
```
  
All nullability warnings disappear. Save the file `(Ctrl + S)` to generate new User.java.

User.java made null-safe by JADEx

```java
package jadex.example;

class User {
    // Name is required
    String name;
    // Address can be null
    @org.jspecify.annotations.Nullable Address address;

    User(String name, @org.jspecify.annotations.Nullable Address address) {
        this.name = name;
        this.address = address;
    }

    // Safely get the city name of the address
    @org.jspecify.annotations.Nullable String getCity() {
        return jadex.runtime.SafeAccess.ofNullable(address).map(t0 -> t0.city).orElse(null);
    }

    // Get the display name of the user
    String getDisplayName() {
        return name;
    }

    // Address class
    static class Address {
        @org.jspecify.annotations.Nullable String city; // City can be null

        Address(@org.jspecify.annotations.Nullable String city) {
            this.city = city;
        }
    }

    public static void main(String[] args) {
        // Null-safe object creation
        User user1 = new User("Jeroen", new Address("New Amsterdam"));
        User user2 = new User("Jane Smith", null);
        User user3 = new User("No Name", new Address(null));

        // Null-safe access
        System.out.println(user1.getDisplayName() + "'s city: " + user1.getCity()); // Jeroen's city: New Amsterdam
        System.out.println(user2.getDisplayName() + "'s city: " + user2.getCity()); // Jane Smith's city: No Address
        System.out.println(user3.getDisplayName() + "'s city: " + user3.getCity()); // No Name's city: No Address
    }

}

```

Run the program:
- Go to User.java
- Select Run > 'Run User.java'

![image](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/hhkyo3en31720gszchje.png)


No NullPointerException occurs, but some outputs are null. Use the Elvis operator ?: to provide default values.

Edit getCity() in User.jadex:

```java
class User {
    //...
    // Safely get the city name of the address
    String getCity() {
        return address?.city ?: "No City";
    }
   //...
}
```

Also, be sure to press Ctrl + S to save. This ensures that the new Java code is saved in User.java.

User.java made null-safe by JADEx

```java
package jadex.example;

class User {
    // Name is required
    String name;
    // Address can be null
    @org.jspecify.annotations.Nullable Address address;

    User(String name, @org.jspecify.annotations.Nullable Address address) {
        this.name = name;
        this.address = address;
    }

    // Safely get the city name of the address
    @org.jspecify.annotations.Nullable String getCity() {
        return jadex.runtime.SafeAccess.ofNullable(address).map(t0 -> t0.city).orElseGet(() -> "No City");
    }

    // Get the display name of the user
    String getDisplayName() {
        return name;
    }

    // Address class
    static class Address {
        @org.jspecify.annotations.Nullable String city; // City can be null

        Address(@org.jspecify.annotations.Nullable String city) {
            this.city = city;
        }
    }

    public static void main(String[] args) {
        // Null-safe object creation
        User user1 = new User("Jeroen", new Address("New Amsterdam"));
        User user2 = new User("Jane Smith", null);
        User user3 = new User("No Name", new Address(null));

        // Null-safe access
        System.out.println(user1.getDisplayName() + "'s city: " + user1.getCity()); // Jeroen's city: New Amsterdam
        System.out.println(user2.getDisplayName() + "'s city: " + user2.getCity()); // Jane Smith's city: No Address
        System.out.println(user3.getDisplayName() + "'s city: " + user3.getCity()); // No Name's city: No Address
    }

}

```

Run the program:
- Go to User.java
- Select Run > 'Run User.java'

![image](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/rw7gytaxueue939mgd9n.png)


All null values are replaced with "No City"

---

## Summary

With JADEx, you can easily enforce null-safety in Java code. JADEx fully supports Java syntax, making it accessible for Java developers. The final code is converted to Java, allowing developers to review it. JADEx is still in its early stages and needs support from the Java community. Even small, regular contributions will help complete this project. Your support can make a real impact.

[Become a Sponsor via Github](https://github.com/sponsors/nieuwmijnleven)

[Become a Sponsor via PayPal.me](https://paypal.me/nieuwmijnleven)









