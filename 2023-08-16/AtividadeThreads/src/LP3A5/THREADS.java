//EXERCICIO 1
package LP3A5;

public class THREADS {
    private static int num = 0;

    public static void main(String[] args) {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 800; i++) {
                synchronized (THREADS.class) {
                    num++;
                }
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Final sharedVariable value: " + num);
    }
}
