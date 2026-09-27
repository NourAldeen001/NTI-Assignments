---
tags: [java, spring, spring-core, teaching, lab]
---

# Lab 6 — Spring Core (XML-Based Dependency Injection)

> [!info] How to use this lab
> Each exercise has a **task** and a hidden **solution**. Try each for 5–10 minutes before revealing. A runnable Maven project (`starter/` and `solution/`) is included alongside this guide — see the [[#Running the Labs]] section at the bottom for setup instructions.

> [!NOTE]
> These exercises assume the concepts from [[Spring Core]] — beans, `<bean>`, `<constructor-arg>`, `<property>`, and `ApplicationContext`.

---

## Exercise 6.1 — Your First Bean

**Task:** Create a `Greeter` class with a method `greet()` that prints `"Hello from Spring!"`. Register it as a bean in XML, then retrieve and use it via `ApplicationContext`.

```java
public class Greeter {
    public void greet() {
        // TODO: print "Hello from Spring!"
    }
}
```

```xml
<!-- TODO: register Greeter as a bean with id "greeter" -->
```

```java
public class MainApp {
    public static void main(String[] args) {
        // TODO: load the ApplicationContext, get the "greeter" bean, call greet()
    }
}
```

> [!success]- Solution
> ```java
> public class Greeter {
>     public void greet() {
>         System.out.println("Hello from Spring!");
>     }
> }
> ```
> ```xml
> <bean id="greeter" class="com.example.Greeter" />
> ```
> ```java
> import org.springframework.context.ApplicationContext;
> import org.springframework.context.support.ClassPathXmlApplicationContext;
>
> public class MainApp {
>     public static void main(String[] args) {
>         ApplicationContext context =
>             new ClassPathXmlApplicationContext("applicationContext.xml");
>
>         Greeter greeter = (Greeter) context.getBean("greeter");
>         greeter.greet(); // Hello from Spring!
>     }
> }
> ```

---

## Exercise 6.2 — Constructor Injection

**Task:** Create `Engine` and `Car` classes, where `Car` requires an `Engine` through its constructor. Wire them together using `<constructor-arg ref="...">`.

```java
public class Engine {
    public void start() {
        // TODO: print "Engine started"
    }
}

public class Car {
    // TODO: add a final Engine field and a constructor that takes an Engine

    public void drive() {
        // TODO: call engine.start(), then print "Car is driving"
    }
}
```

> [!success]- Solution
> ```java
> public class Engine {
>     public void start() {
>         System.out.println("Engine started");
>     }
> }
>
> public class Car {
>     private final Engine engine;
>
>     public Car(Engine engine) {
>         this.engine = engine;
>     }
>
>     public void drive() {
>         engine.start();
>         System.out.println("Car is driving");
>     }
> }
> ```
> ```xml
> <bean id="engine" class="com.example.Engine" />
>
> <bean id="car" class="com.example.Car">
>     <constructor-arg ref="engine" />
> </bean>
> ```
> ```java
> Car car = (Car) context.getBean("car");
> car.drive();
> // Engine started
> // Car is driving
> ```

---

## Exercise 6.3 — Setter Injection

**Task:** Rewrite `Car` from Exercise 6.2 to use **setter injection** instead of constructor injection. Update the XML to use `<property>` instead of `<constructor-arg>`.

```java
public class Car {
    // TODO: add an Engine field with a setter (no constructor needed)

    public void drive() {
        // TODO: same as before
    }
}
```

> [!success]- Solution
> ```java
> public class Car {
>     private Engine engine;
>
>     public void setEngine(Engine engine) {
>         this.engine = engine;
>     }
>
>     public void drive() {
>         engine.start();
>         System.out.println("Car is driving");
>     }
> }
> ```
> ```xml
> <bean id="engine" class="com.example.Engine" />
>
> <bean id="car" class="com.example.Car">
>     <property name="engine" ref="engine" />
> </bean>
> ```

---

## Exercise 6.4 — Injecting Simple Values

**Task:** Add a `String model` and an `int year` field to `Car` (setter injection), and inject literal values for both via XML (`value="..."`). Print them from `drive()`.

```java
public class Car {
    private Engine engine;
    // TODO: add model (String) and year (int) fields with setters

    public void drive() {
        engine.start();
        // TODO: print "Driving a <year> <model>"
    }
}
```

> [!success]- Solution
> ```java
> public class Car {
>     private Engine engine;
>     private String model;
>     private int year;
>
>     public void setEngine(Engine engine) { this.engine = engine; }
>     public void setModel(String model) { this.model = model; }
>     public void setYear(int year) { this.year = year; }
>
>     public void drive() {
>         engine.start();
>         System.out.println("Driving a " + year + " " + model);
>     }
> }
> ```
> ```xml
> <bean id="engine" class="com.example.Engine" />
>
> <bean id="car" class="com.example.Car">
>     <property name="engine" ref="engine" />
>     <property name="model" value="Tesla Model 3" />
>     <property name="year" value="2024" />
> </bean>
> ```
> Output: `Driving a 2024 Tesla Model 3`

---

## Exercise 6.5 — Beans Are Singletons by Default

**Task:** Retrieve the `engine` bean **twice** from the context and check whether both references point to the **same object**. Then explain the result in a comment.

```java
public class Exercise6_5_SingletonCheck {
    public static void main(String[] args) {
        // TODO: load context, get "engine" bean twice, compare with ==
    }
}
```

> [!success]- Solution
> ```java
> ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
>
> Engine engine1 = (Engine) context.getBean("engine");
> Engine engine2 = (Engine) context.getBean("engine");
>
> System.out.println(engine1 == engine2); // true
>
> // Explanation: by default, every Spring bean has "singleton" scope -
> // the container creates ONE instance and returns that same instance
> // every time getBean() is called for it.
> ```
> **Talking point:** this is different from calling `new Engine()` twice, which would always produce two different objects.

---

## Exercise 6.6 — Swapping an Implementation (The Payoff)

**Task:** Create an interface `Notifier` with a method `send(String message)`. Create two implementations: `EmailNotifier` and `SmsNotifier`. Wire `Car` to depend on `Notifier` (constructor injection), and swap between the two implementations by changing **only the XML** — no Java code changes.

```java
public interface Notifier {
    void send(String message);
}

// TODO: implement EmailNotifier and SmsNotifier

public class Car {
    // TODO: add a Notifier dependency via constructor
    public void drive() {
        // TODO: call notifier.send("Car started driving")
    }
}
```

> [!success]- Solution
> ```java
> public interface Notifier {
>     void send(String message);
> }
>
> public class EmailNotifier implements Notifier {
>     @Override
>     public void send(String message) {
>         System.out.println("Email sent: " + message);
>     }
> }
>
> public class SmsNotifier implements Notifier {
>     @Override
>     public void send(String message) {
>         System.out.println("SMS sent: " + message);
>     }
> }
>
> public class Car {
>     private final Notifier notifier;
>
>     public Car(Notifier notifier) {
>         this.notifier = notifier;
>     }
>
>     public void drive() {
>         notifier.send("Car started driving");
>     }
> }
> ```
> ```xml
> <!-- Switch this single line to change behavior, no Java changes needed -->
> <bean id="notifier" class="com.example.EmailNotifier" />
> <!-- <bean id="notifier" class="com.example.SmsNotifier" /> -->
>
> <bean id="car" class="com.example.Car">
>     <constructor-arg ref="notifier" />
> </bean>
> ```

---

## Exercise 6.7 — `BeanFactory` vs `ApplicationContext` (Eager vs Lazy)

**Task:** Add a `System.out.println("Engine bean created")` line inside the `Engine` constructor. Load the context using `ClassPathXmlApplicationContext` but **never call `getBean("engine")`**. Observe whether the message prints anyway, and explain why in a comment.

```java
public class Engine {
    public Engine() {
        // TODO: add a print statement here
    }
    public void start() {
        System.out.println("Engine started");
    }
}

public class Exercise6_7_EagerLoading {
    public static void main(String[] args) {
        // TODO: load the context, do NOT call getBean("engine"), observe the output
    }
}
```

> [!success]- Solution
> ```java
> public class Engine {
>     public Engine() {
>         System.out.println("Engine bean created");
>     }
>     public void start() {
>         System.out.println("Engine started");
>     }
> }
>
> public class Exercise6_7_EagerLoading {
>     public static void main(String[] args) {
>         ApplicationContext context =
>             new ClassPathXmlApplicationContext("applicationContext.xml");
>         // "Engine bean created" prints here, even though getBean() was never called
>     }
> }
> ```
> **Explanation:** `ApplicationContext` uses **eager initialization** — it creates all singleton beans as soon as the container starts, not only when `getBean(...)` is called. A `BeanFactory` would behave differently: it uses **lazy initialization**, only creating a bean the first time it's actually requested.

---

## Exercise 6.8 — Capstone: Three-Layer Wiring

**Task:** Build the following dependency chain entirely with XML:

```text
OrderService  →  PaymentService  →  Notifier
```

- `Notifier` (interface, from Exercise 6.6) — reuse `EmailNotifier`
- `PaymentService` — has a `pay(double amount)` method that prints a message and then calls `notifier.send(...)`
- `OrderService` — has a `placeOrder(double amount)` method that prints a message and then calls `paymentService.pay(amount)`

Wire all three beans via constructor injection in one XML file, then run the full chain from `main`.

```java
public class PaymentService {
    // TODO: constructor-inject a Notifier
    public void pay(double amount) {
        // TODO: print, then call notifier.send(...)
    }
}

public class OrderService {
    // TODO: constructor-inject a PaymentService
    public void placeOrder(double amount) {
        // TODO: print, then call paymentService.pay(amount)
    }
}
```

> [!success]- Solution
> ```java
> public class PaymentService {
>     private final Notifier notifier;
>
>     public PaymentService(Notifier notifier) {
>         this.notifier = notifier;
>     }
>
>     public void pay(double amount) {
>         System.out.println("Paying " + amount);
>         notifier.send("Payment of " + amount + " completed");
>     }
> }
>
> public class OrderService {
>     private final PaymentService paymentService;
>
>     public OrderService(PaymentService paymentService) {
>         this.paymentService = paymentService;
>     }
>
>     public void placeOrder(double amount) {
>         System.out.println("Placing order for " + amount);
>         paymentService.pay(amount);
>     }
> }
> ```
> ```xml
> <bean id="notifier" class="com.example.EmailNotifier" />
>
> <bean id="paymentService" class="com.example.PaymentService">
>     <constructor-arg ref="notifier" />
> </bean>
>
> <bean id="orderService" class="com.example.OrderService">
>     <constructor-arg ref="paymentService" />
> </bean>
> ```
> ```java
> OrderService orderService = (OrderService) context.getBean("orderService");
> orderService.placeOrder(250.0);
> // Placing order for 250.0
> // Paying 250.0
> // Email sent: Payment of 250.0 completed
> ```
> **Talking point:** this is the exact three-layer chain from [[Request-Response Flow & Application Layers]] wired entirely through XML — not one `new` keyword appears anywhere in the business classes.

---

## Wrap-up Discussion Questions

1. In Exercise 6.5, what would you need to change in the XML to make `getBean("engine")` return a **new** object every time instead of the same singleton? (Hint: look up the `scope` attribute — `prototype`.)
2. In Exercise 6.7, if you used `BeanFactory` instead of `ApplicationContext`, at what point would `"Engine bean created"` print?
3. In the capstone (6.8), what is the minimum change needed to swap `EmailNotifier` for `SmsNotifier`? Why is that such a small change?

---

## Running the Labs

This lab requires a Maven project with the Spring Framework dependency, since — unlike Labs 1–5 — plain `javac` cannot compile against Spring's classes.

**`pom.xml`** (already included in both `starter/` and `solution/`):
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.1.13</version>
</dependency>
```

**To run:**
```bash
cd solution   # or starter, once TODOs are filled in
mvn compile exec:java -Dexec.mainClass="com.example.MainApp"
```

> [!NOTE]
> Maven will download the Spring dependency automatically the first time you build — this requires an internet connection.
