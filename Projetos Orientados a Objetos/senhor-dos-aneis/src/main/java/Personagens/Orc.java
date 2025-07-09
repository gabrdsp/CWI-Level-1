package Personagens;

import Classes.Guerreiro;
import Comportamentos.Monstros;

public class Orc extends Guerreiro implements Monstros {
    public Orc() {
        super(7, 4, 1, 30, "O", false);
    }

    @Override
    public String grunir() {
        return "Arrrggghhh";
    }
}
