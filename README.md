# Bytebank

  This is a **bytebank** created as a way of exercice some `Kotlin` fundaments as part of my personal development 
  path with the language. This repository makes part of my **Alura Kotlin training**.

### Annotations Scope Function Selection

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