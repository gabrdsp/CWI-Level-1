package Personagens;

import Classes.Mago;
import Comportamentos.Maia;

public class Saruman extends Mago implements Maia {
    public Saruman() {
        super(2, 2, 9, 70, "S", false);
    }

    @Override
    public Saruman ressucitar() {
        return null;
    }

    @Override
    public String falar() {
        return "Against the power of Mordor there can be no victory.";
    }
}
