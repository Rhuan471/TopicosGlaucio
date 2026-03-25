import java.util.list;

public class Remover implements Runnable {
  private List<Integer> lista;
  
  public Remover (List<Integer> lista) {
    this.lista lista;
}
  
@Override
  public void run() { // busy wait
    while (!Thread.currentThread().isInterrupted())
      synchronized (lista) {
        if (!lista.isEmpty()) {
          lista.removeFirst();
        }
      }
        Thread.yield():
  }
}
