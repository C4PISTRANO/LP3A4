package LP3A5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class DeadlockSimulation {
private final Lock lock1 = new ReentrantLock(); // Cria 3 objetos Lock
private final Lock lock2 = new ReentrantLock();
private final Lock lock3 = new ReentrantLock();

public void method1() {
	lock1.lock(); // Adquire o lock 1
	System.out.println("Method 1 adquiriu lock 1");

//Inicialização das 3 threads
thread1.start();
thread2.start();
thread2.start();

try {
	Thread.sleep(1000); // Espera um segundo
} 
catch (final InterruptedException e) {
	e.printStackTrace();
}

lock2.lock(); // Adquire o lock 2
System.out.println("Method 1 adquiriu lock 2");

lock2.unlock(); // Libera o lock 2
System.out.println("Method 1 liberou lock 2");

lock1.unlock(); // Libera o lock 1
System.out.println("Method 1 liberou lock 1");
}

public void method2() {
lock2.lock(); // Adquire o lock 2
System.out.println("Method 2 adquiriu lock 2");
try {
Thread.sleep(1000); // Espera um segundo
} catch (final InterruptedException e) {
e.printStackTrace();
}
lock1.lock(); // Adquire o lock 1
System.out.println("Method 2 adquiriu lock 1");
lock1.unlock(); // Libera o lock 1
System.out.println("Method 2 liberou lock 1");
lock2.unlock(); // Libera o lock 2
System.out.println("Method 2 liberou lock 2");
}

public static void main(final String[] args) {
final DeadlockSimulation simulation = new DeadlockSimulation();
final Thread thread1 = new Thread(() -> {
simulation.method1();
});
final Thread thread2 = new Thread(() -> {
simulation.method2();
});
final Thread thread3 = new Thread(() -> {
simulation.method2();
});

thread1.start();
thread2.start();
thread3.start();
}
}
