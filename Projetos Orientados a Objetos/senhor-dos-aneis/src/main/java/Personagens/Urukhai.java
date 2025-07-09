package Personagens;

import Classes.Guerreiro;
import Comportamentos.Humanos;
import Comportamentos.Monstros;

public class Urukhai extends Guerreiro implements Humanos, Monstros {
    public Urukhai() {
        super(8, 6, 3, 45, "U", false);
    }

    @Override
    public void envelhecer() {
        sofrerDano(2);
    }

    @Override
    public String falar() {
        return "Looks like meat's back on the menu boys!";
    }

    @Override
    public String grunir() {
        return "Uuurrrrrr";
    }
}
