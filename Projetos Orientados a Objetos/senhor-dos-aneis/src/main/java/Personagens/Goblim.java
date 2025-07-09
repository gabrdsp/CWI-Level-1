package Personagens;

import Classes.Arqueiro;
import Comportamentos.Monstros;

public class Goblim extends Arqueiro implements Monstros {
    public Goblim() {
        super(3, 6, 1, 20, "M", false);
    }

    @Override
    public String grunir() {
        return "Iiisshhhh";
    }
}
