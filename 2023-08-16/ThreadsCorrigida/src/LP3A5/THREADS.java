package LP3A5;

public class THREADS {
class Counter {
private int value;

public synchronized void increment() {
value++;
}
public int getValue() {
return value;
}
}
//Inicialização das duas threads
thread1.start();
thread2.start();
// ...
Counter counter = new Counter();
Runnable task = () -> {
for (int i = 0; i < 1000; i++) {) -
counter.increment();
}
};
Thread thread1 = new Thread(task);
Thread thread2 = new Thread(task);
thread1.start();
thread2.start();
thread1.join();
thread2.join();
System.out.println(counter.getValue()); // resultado esperado é 2000
}
}