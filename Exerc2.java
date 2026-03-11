// Faça um programa concorrente que crie 10 threads que exibam o nome da thread e um contador que varia de 1 a 10. Execute várias 
// vezes e observe as variações na saída. Os valores são sempre impressos na mesma ordem?
public class Exerc2 extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Exerc2 e1 = new Exerc2();
            e1.start();
        }
    }
}
