public class Jutsu {
    private int chakraConsumido;
    private int dano;

    public Jutsu(int chakraConsumido, int dano) {
        if (chakraConsumido > 5) {
            this.chakraConsumido = 5;
        } else {
            this.chakraConsumido = chakraConsumido;
        }

        if (dano > 10) {
            this.dano = 10;
        } else {
            this.dano = dano;
        }
    }

    public int getChakraConsumido(){
    return chakraConsumido;
    }

    public int getDano(){
    return dano;
    }
}

