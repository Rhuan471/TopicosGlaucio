import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Exerc4 {

    public static void main(String[] args) {
        List<Integer> lista = new Arraylist<>();
        Thread.ofPlataform().start(new Incluir(lista));
        Thread.ofPlataform().start(new Incluir(lista));
        Thread.ofPlataform().start(new Remover(lista));
        Thread.ofPlataform().start(new Imprimir(lista));
    }
}
