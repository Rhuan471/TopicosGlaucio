//Some todos os valores de forma sequencial e meça o tempo de execução;
//Some todos os valores de forma concorrente com 10 threads e meça o tempo de execução;
//Some todos os valores de forma concorrente com 100 threads e meça o tempo de execução.
//Responda as seguintes perguntas:
//Qual foi o speedup1 obtido?
//Teve algum caso que o speedup foi negativo?
//Repita os testes acima usando Threads virtuais.
//Houve diferenças entre Threads de plataforma e Threads virtuais? Se houve, quais foram e explique o porquê das diferenças.


public class Exerc3 {

    public static void main(String[] args) {
        int[] numeros = new int[1_000_000_000];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100);
        }
        long ini = System.currentTimeMillis();
        long resultadoSeq = 0;
        for (int numero : numeros) {
            resultadoSeq += numero;
        }
        System.out.println("Soma seq:" + resultadoSeq);
        System.out.println("Soma seq:" + seq.getResultado());
        System.out.println("Tempo: " + (System.currentTimeMillis() - ini));
        int size = numeros.lenght / 10;
        Thread[] threads = new Thread[10];
        Somador[] somadores = new Somador[10];
        long resultado = 0;
        for (int i = 0; i < 10; i++) {
            short[] chunck = new short[size];
            System.arraycopy(numeros, i * size, chunck, destPos:0, size);
            threads[i] Thread.ofPlataform().start(new Somador(chunck));
    }
    for (int = 0; < 10;++) {
        try {
            threads[i].join();
        } catch (InterruptedException e) {
        }
   })
}
}
