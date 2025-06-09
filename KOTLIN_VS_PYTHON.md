#### 1. Kotlin is statically typed

When you create a variable in Python:
```python
my_variable = "hello"
```
you do not have to specify what type it is, and you can then change this variable to be another type later on:
```python
my_variable = "hello"
print(my_variable) # prints "hello"
my_variable = 3
my_variable += 1
print(my_variable) # prints 4
```

However, in Kotlin, any variable is a single predefined type, and cannot change type.
Except where it can be inferred, the type of a variable or parameter is explicitly stated, with a syntax similar to Python type annotations:

```kotlin
var myVariable: String = "hello"
myVariable = 3 // Error: Assignment type mismatch: actual type is 'kotlin.Int', but 'kotlin.String' was expected.
```

#### 2. `var` and `val` keywords

Whereas in Python, you can just start a new line by writing a new variable name:
```python
second_variable = 5
```

In Kotlin, you must use the `var` or `val` keywords to declare a new variable or value.
`var` is used for variables that may be changed later on.
`val` is used for values that stay fixed once defined.

```kotlin
var secondVariable = 5
val firstValue = 6
secondVariable += firstValue // This works fine
firstValue += secondVariable // Error: `val` cannot be redefined
```

#### 3. Curly brackets

In Python, code blocks or scopes are determined by how indented the code is:
```python
def a_function():
    # some stuff

class MyClass:
    def __init__(self):
        # some more stuff

if (__name__ == "__main__"):
    # even more stuff
```

In Kotlin, any new scope is surrounded in curly brackets `{` and `}`. Usually the scope is also indented within those brackets, but it doesn't have to be.

```kotlin
fun aFunction() {
    // some stuff
}

class MyClass {
    init {
        // some more stuff
    }
}

// even more stuff
```