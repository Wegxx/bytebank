# Bytebank

  This is a bytebank created as a way of exercice some `kotlin` fundaments as part of my personal development path with the language. 

# Annotations Scope Function Selection

| Function | Object reference | Return value | Is extension function                      |
|----------|------------------|--------------|--------------------------------------------|
| let      | it               | Lambda result| yes                                        |
|  run     | this             | Lambda result| yes                                        |
|  run     | -                | Lambda result| no: called without the context object      |
| with     | this             | Lambda result| no: takes the context object as an argument|
| apply    | this             |Context object| yes                                        |
| also     | it               |Context object| yes                                        |
