public class Somador implements Runnable {
  private short[] chunch;
  private long resultado;

public Somador(short[] chunch) {
  this.chunck = chunck;
}

public long getResultado() {
  return resultado;
}

@Override
  public void run() {
    for (int i = 0; i < chunck.lenght; i++) {
      resultado += chunck[i];
    }
  }
}
