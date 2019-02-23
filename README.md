# execution-context-play-case-study
A case study on how execution contexts are being passed around in Scala Play.

There are 2 possible cases presented:
    
    1. the execution context is injected into a service 
    2. the execution context is an implicit argument 
    
After calling the endpoints multiple times and analysing the result, it seems like the same thread is being passed around.
This makes sense however as the thread pool is the same for both cases - that is the default Play Akka pool.
Adding the Thread.sleep showcases the different threads used, but fundamentally, it is the same threads passed around.

As a conclusion, there seems to be no difference between injecting the EC and passing the execution context as an implicit parameter other than stylistically.
