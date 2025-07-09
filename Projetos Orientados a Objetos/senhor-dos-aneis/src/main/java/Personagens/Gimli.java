package Personagens;

import Classes.Guerreiro;
import Comportamentos.Anao;

public class Gimli extends Guerreiro implements Anao {
    private int dosesDeBebida = 0;

    public Gimli() {
        super(9, 2, 4, 60, "I", true);
    }

    @Override
    public void beber() {
        dosesDeBebida++;
    }

    @Override
    public String falar() {
        if (dosesDeBebida < 3) {
            return "Let them come. There is one Dwarf yet in Moria who still draws breath.";
        } else {
            return "What did I say? He can't hold his liquor!";
        }
    }
}
