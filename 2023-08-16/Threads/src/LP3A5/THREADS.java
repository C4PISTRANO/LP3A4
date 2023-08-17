package LP3A5;

public class THREADS {
public static void main(String[] args) throws InterruptedException {
	
// TODO Auto-generated method stub
class Counter {
private int value;
public void increment() {
value++;
}

public int getValue() {
return value;
}
}

// ...

Counter counter = new Counter();
Runnable task = () -> {
for (int i = 0; i < 1000; i++) {
counter.increment();
}
};
Thread thread1 = new Thread(task);
Thread thread2 = new Thread(task);
thread1.start();
thread2.start();
thread1.join();
thread2.join();
System.out.println(counter.getValue()); // resultado esperado é 2000, mas pode variar
}
}
