# Bytebank

  **Kotlin bytebank** is a personal and the main project of this repository, created as a way of exercice some `Kotlin` fundaments as part of my personal development 
  path with the language. This repository makes part of my **Alura Kotlin training**.
  It develops and exemplify knowledge in:
##Object Orientation
  - Inheritance, polymorphism and interfaces 
  - Languages resources and composition packages 
  - Particularities Number class, String class and Data class
  - Exceptions and null references 
  - Function paradigm features
##Collections and functional features
    - ### Collections
    Kotlin Collections is the second part of **Kotlin bytebank** created as a way of exercice some `kotlin` fundaments as part of my personal development path with the language.
    It develops and exemplify knowledge in:

      - Declaring, constructing, looping and changing `Arrays`, `Ranges` and `Lists`
      - Applying collection processing functions to solve common problems
      - Understanding how to extend the language's standard library functionality by creating your own functions
      - Using aggregate operations to manipulate collections
      - Understanding the difference between mutable and immutable collections

  - ### CollectionsMapsSets
    Kotlin Collections is the third part of **Kotlin bytebank** created as a way of exercice some `kotlin` fundaments as part of my personal development path with the language.
    It develops and exemplify knowledge in:

  - Understanding the basics of `Collection` and `Iterable` references
  - Understanding the usage of `Set`
  - Creating key-value `Maps`
  - Understanding specific operations between `Maps` and `Sets`
  - Understanding functions 

  - ### Annotations Scope Function Selection
All the exercises of Scope function content are in the main **Kotlin bytebank**

| Function | Object reference | Return value | Is extension function                      |
|----------|------------------|--------------|--------------------------------------------|
| let      | it               | Lambda result| yes                                        |
|  run     | this             | Lambda result| yes                                        |
|  run     | -                | Lambda result| no: called without the context object      |
| with     | this             | Lambda result| no: takes the context object as an argument|
| apply    | this             |Context object| yes                                        |
| also     | it               |Context object| yes                                        |

**These are not rules but quick tips for scope functions usage**
- Execute lambda with non nullable objects: `let()`
- Introduce an expression as a variable in local scope: `let()`
- Configure object: `apply()`
- Configure object and compute result: `run()`
- Introduction execution when an expression is necessary: `run()- without extension`
- Additional executions without affecting the scope: `also()`
- Grouped function calls in an object: `with()`

**takeIf and takeUnless**
Not really common to see
Ex: 
```
  val number = 3
  
  val eventOrNull = number.takeIf{it % 2 == 0}
  val oddOrNull = number.takeUnless{it % 2 == 0}
  println("eventOrNull, oddOrNull")
  
  result: null, 3
```
