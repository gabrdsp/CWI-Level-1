package Personagens;

import Mapa.Mapa;

public abstract class Personagem {
    protected int forca;
    protected int agilidade;
    protected int inteligencia;
    protected int constituicao;
    protected String simbolo;
    protected final boolean pertenceASociedade;

    protected Personagem(int forca, int agilidade, int inteligencia, int constituicao, String simbolo, boolean pertenceASociedade) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.constituicao = constituicao;
        this.simbolo = simbolo;
        this.pertenceASociedade = pertenceASociedade;
    }

    public int getConstituicao() {
        return constituicao;
    }

    @Override
    public String toString() {
        return simbolo;
    }

    public boolean isSociedade() {
        return pertenceASociedade;
    }

    public void sofrerDano(int dano) {
        constituicao -= dano;
        if (constituicao < 0) constituicao = 0;
    }

    protected int getDirecao() {
        return isSociedade() ? 1 : -1;
    }

    public abstract void atacar(Mapa mapa);
    public abstract void mover(Mapa mapa);
}
