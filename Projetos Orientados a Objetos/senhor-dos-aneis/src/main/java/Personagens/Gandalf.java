package Personagens;

import Classes.Mago;
import Comportamentos.Maia;

public class Gandalf extends Mago implements Maia {
    public Gandalf() {
        super(2, 3, 10, 80, "G", true);
    }

    @Override
    public Gandalf ressucitar() {
        if (constituicao == 0) return new Gandalf();
        return null;
    }

    @Override
    public String falar() {
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }
}
