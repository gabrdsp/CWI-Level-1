


public class Ninja {
    private String nome;
    private int chakra;
    private Jutsu jutsuPrincipal;

    public Ninja(String nome, Jutsu jutsuPrincipal) {
        this.nome = nome;
        this.chakra = 100;
        this.jutsuPrincipal = jutsuPrincipal;

    }

    public void atacar(Ninja rival) {
        this.chakra = this.chakra - this.jutsuPrincipal.getChakraConsumido();
        rival.receberGolpe(this.jutsuPrincipal.getDano());

    }

    public void receberGolpe(int danoRecebido) {
        this.chakra = this.chakra - danoRecebido;

    }

    public String getNome() {
        return nome;

    }

    public int getChakra() {
        return chakra;

    }

    public Jutsu getJutsuPrincipal() {
        return jutsuPrincipal;

    }
}
