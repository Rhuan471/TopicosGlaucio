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
