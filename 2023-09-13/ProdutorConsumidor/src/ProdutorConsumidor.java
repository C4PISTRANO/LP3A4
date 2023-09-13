import java.util.LinkedList;
import java.util.Queue;

public class ProdutorConsumidor {

    // Define a capacidade do buffer
    private static final int CAPACIDADE_BUFFER = 5;

    public static void main(String[] args) {

        // Cria o objeto monitor
        Monitor monitor = new Monitor(CAPACIDADE_BUFFER);

        // Cria as threads produtor e consumidor
        Thread produtor = new Thread(() -> {
            int i = 1;
            while (true) {
                try {
                    monitor.produzir(i);
                    i++;
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumidor = new Thread(() -> {
            while (true) {
                try {
                    monitor.consumir();
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Inicia as threads
        produtor.start();
        consumidor.start();
    }

    // Define a classe Monitor para gerenciar o buffer
    private static class Monitor {

        // Define o buffer como uma fila (LinkedList)
        private Queue<Integer> buffer;

        // Define a capacidade do buffer
        private int capacidade;

        // Construtor do monitor
        public Monitor(int capacidade) {
            this.buffer = new LinkedList<>();
            this.capacidade = capacidade;
        }

        // Método para adicionar um item ao buffer
        public synchronized void produzir(int item) throws InterruptedException {
            while (buffer.size() == capacidade) {
                wait();
            }
            buffer.add(item);
            System.out.println("Produtor produziu " + item);
            notifyAll();
        }

        // Método para remover um item do buffer
        public synchronized int consumir() throws InterruptedException {
            while (buffer.size() == 0) {
                wait();
            }
            int item = buffer.remove();
            System.out.println("Consumidor consumiu " + item);
            notifyAll();
            return item;
        }
    }
}
