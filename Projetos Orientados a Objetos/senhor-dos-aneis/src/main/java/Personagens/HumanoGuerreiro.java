package Personagens;

import Classes.Guerreiro;
import Comportamentos.Humanos;

public abstract class HumanoGuerreiro extends Guerreiro implements Humanos {
    private final int danoEnvelhecimento;

    protected HumanoGuerreiro(int forca, int agilidade, int inteligencia, int constituicao, String simbolo, int danoEnvelhecimento, boolean pertenceASociedade) {
        super(forca, agilidade, inteligencia, constituicao, simbolo, pertenceASociedade);
        this.danoEnvelhecimento = danoEnvelhecimento;
    }

    @Override
    public void envelhecer() {
        sofrerDano(danoEnvelhecimento);
    }
}
