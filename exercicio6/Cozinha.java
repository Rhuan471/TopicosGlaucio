package exercicio6;

public class Cozinha {
    public static void main(String[] args) {
        PilhaPratos sujos = new PilhaPratos(100);
        PilhaPratos escorredor = new PilhaPratos(10); // Limite de 10
        PilhaPratos limpos = new PilhaPratos(100);

        // Enchendo a pilha de sujos
        for (int i = 1; i <= 100; i++) {
            sujos.addPrato(new Prato(i, Estado.Sujo));
        }

        System.out.println("Iniciando lavação...");

        // Thread do Lavador
        Lavador lavador = new Lavador(sujos, escorredor);
        Thread tLavador = new Thread(lavador);
        
        // Threads dos Secadores
        Secador s1 = new Secador("Secador 1", escorredor, limpos);
        Secador s2 = new Secador("Secador 2", escorredor, limpos);
        Thread tSecador1 = new Thread(s1);
        Thread tSecador2 = new Thread(s2);

        // Iniciando as atividades
        tLavador.start();
        tSecador1.start();
        tSecador2.start();

        // Aguardando o término de todas as threads
        try {
            tLavador.join();
            tSecador1.join();
            tSecador2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos os pratos foram lavados e secos!");
    }
}