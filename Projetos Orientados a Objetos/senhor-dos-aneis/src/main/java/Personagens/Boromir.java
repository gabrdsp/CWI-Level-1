package Personagens;

public class Boromir extends HumanoGuerreiro {
    public Boromir() {
        super(7, 6, 3, 40, "B", 2, true);
    }

    @Override
    public String falar() {
        return "One does not simply walk into Mordor.";
    }
}
