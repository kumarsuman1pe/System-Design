# Java Design Patterns: Examples and Practice Plan

## Creational Patterns

### 1. Singleton
Ensures a class has only one instance and provides a global point of access to it.
```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### 2. Builder
Used to construct a complex object step-by-step.
```java
public class User {
    private final String name;
    private final int age;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public static class Builder {
        private final String name; // mandatory
        private int age;           // optional

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
```

### 3. Factory
Defines an interface for creating an object, but lets subclasses alter the type of objects that will be created.
```java
public interface Shape {
    void draw();
}

public class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType.equals("Circle")) return new Circle();
        return null;
    }
}
```

## Structural Patterns

### 4. Adapter
Allows the interface of an existing class to be used as another interface.
```java
public interface MediaPlayer {
    void play(String audioType, String fileName);
}

public class AudioPlayer implements MediaPlayer {
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3: " + fileName);
        }
    }
}
```

### 5. Decorator
Adds responsibilities to objects dynamically.
```java
public interface Car {
    void assemble();
}

public class BasicCar implements Car {
    public void assemble() {
        System.out.print("Basic Car.");
    }
}

public class SportsCar extends CarDecorator {
    public SportsCar(Car c) {
        super(c);
    }
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}
```

## Behavioral Patterns

### 6. Observer
Defines a dependency between objects so that when one object changes state, all dependents are notified.
```java
public interface Observer {
    void update(String message);
}

public class User implements Observer {
    private String name;
    public User(String name) {
        this.name = name;
    }
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

public class PaymentGateway {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void paymentSuccessful(String txnId) {
        notifyObservers("Payment " + txnId + " completed successfully!");
    }

    private void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}
```

### 7. State
Allows an object to alter its behavior when its internal state changes.
```java
interface State {
    void doAction(Context context);
}

class StartState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }
}

class StopState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }
}

class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
```

---

## 5-Day Practice Plan

### Day 1: Creational Patterns
- Singleton, Builder, Factory
- Build: Config manager (Singleton), Pizza builder (Builder)

### Day 2: Structural Patterns
- Adapter, Decorator
- Build: Media Player Adapter, Feature-extending Car system

### Day 3: Behavioral Patterns (Part 1)
- Observer, Strategy
- Build: Notification system, Payment processing with strategy

### Day 4: Behavioral Patterns (Part 2)
- State, Command, Template
- Build: Music Player with state, Command-based task queue

### Day 5: Project + Mock Interview
- Choose 1-2 patterns and design a mini-project (e.g., E-commerce checkout)
- Practice with a friend or simulate with ChatGPT

---
Let me know if you'd like this as a Notion template or Google Doc as well.
