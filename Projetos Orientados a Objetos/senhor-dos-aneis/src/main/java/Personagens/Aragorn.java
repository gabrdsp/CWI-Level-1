package Personagens;

public class Aragorn extends HumanoGuerreiro {
    public Aragorn() {
        super(10, 7, 6, 60, "A", 1, true);
    }

    @Override
    public String falar() {
        return "A day may come when the courage of men fails… but it is not THIS day.";
    }
}
