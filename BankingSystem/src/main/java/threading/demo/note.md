# Cave of Programming - Java Multithreading
https://www.udemy.com/course/java-multithreading/


-------------------------
2.

There two problems when 2 or more thread share data
1. Data being Cached
2. Thread interleaving


---------------------------

3. thread interleaving

Synchronized solves problem with thread intersleaving

What synchronization does
Every object in java has intrencive lock/ Monitor lock/ mutex 

if you call an sync method of an object you have to aquire intresive lock on the object. One thread at a time could do that and other threads has to wait to call the method until the current thread realease lock. 


when ever you got multiple threads accessnig shared data use sync

volatliel garantees all the threads access original current state of variable. Sync also handle this.


