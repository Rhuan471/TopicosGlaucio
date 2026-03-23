import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Exerc4 {

    public static void main(String[] args) {
        List<Integer> lista = Collections.synchronizedList(new ArrayList<>());
        Random random = new Random();

        Thread produtor1 = new Thread(() -> {
            while (true) {
                lista.add(random.nextInt(100));
                pausar(300); 
            }
        });

        Thread produtor2 = new Thread(() -> {
            while (true) {
                lista.add(random.nextInt(100));
                pausar(400);
            }
        });

        Thread consumidor = new Thread(() -> {
            while (true) {

                synchronized (lista) {
                    if (!lista.isEmpty()) {
                        lista.remove(0);
                    }
                }
                pausar(500); 
            }
        });

        Thread monitor = new Thread(() -> {
            while (true) {
                pausar(1000); 
                
                synchronized (lista) {
                    System.out.println("Lista atual: " + lista);
                }
            }
        });

        produtor1.start();
        produtor2.start();
        consumidor.start();
        monitor.start();
    }

    private static void pausar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
