package cozinha;

import java.util.Arrays;

public class PilhaPratos {
    private Prato[] pratos;
    private int qtde;

    public PilhaPratos(int tamanho) {
        pratos = new Prato[tamanho];
    }

    // synchronized garante que apenas uma thread mexa na pilha por vez
    public synchronized void addPrato(Prato prato) {
        // Se a pilha estiver cheia, a thread espera (ex: escorredor cheio)
        while (qtde == pratos.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        pratos[qtde] = prato;
        qtde++;
        notifyAll(); // Avisa que agora tem um prato disponível
    }

    public synchronized Prato removePrato() {
        // Se não tem prato, a thread espera (ex: secador esperando prato no escorredor)
        while (qtde == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        qtde--;
        Prato prato = pratos[qtde];
        pratos[qtde] = null;
        notifyAll(); // Avisa que abriu um espaço na pilha
        return prato;
    }

    public synchronized boolean temPrato() {
        return qtde > 0;
    }

    @Override
    public synchronized String toString() {
        return "PilhaPratos [" + Arrays.toString(pratos) + "]";
    }
}