package exercicio6;

public class Secador implements Runnable {
    private PilhaPratos escorredor;

    public Secador(PilhaPratos escorredor, PilhaPratos limpos, String nome) {
        this.escorredor = escorredor;
        this.limpos = limpos;
        this.nome = nome;
    }
    public PilhaPratos getEscorredor() {
        return escorredor;
    }

    public void setEscorredor(PilhaPratos escorredor) {
        this.escorredor = escorredor;
    }

    private PilhaPratos limpos;
    public PilhaPratos getLimpos() {
        return limpos;
    }

    public void setLimpos(PilhaPratos limpos) {
        this.limpos = limpos;
    }

    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Secador(String nome, PilhaPratos escorredor, PilhaPratos limpos) {
        this.nome = nome;
        this.escorredor = escorredor;
        this.limpos = limpos;
    }

    @Override
    public void run() {
        // O secador continua tentando trabalhar enquanto houver pratos
        // No mundo real, precisaríamos de uma condição de parada definitiva
        while (true) {
            Prato prato = escorredor.removePrato();
            if (prato != null) {
                System.out.println(nome + " secando prato: " + prato);
                prato.setEstado(Estado.Limpo);
                limpos.addPrato(prato);
                System.out.println(nome + " guardou prato: " + prato);
            }
        }
    }

    public String getNome() {
        return nome;
    }
}