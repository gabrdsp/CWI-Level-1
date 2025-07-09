public class Batalha {

    public Ninja lutar(Ninja primeiroNinja, Ninja segundoNinja) {

        if("Itachi".equals(primeiroNinja.getNome())) {
            return primeiroNinja;
        }

        if("Itachi".equals(segundoNinja.getNome())) {
            return segundoNinja;
        }

        primeiroNinja.atacar(segundoNinja);
        segundoNinja.atacar(primeiroNinja);

        primeiroNinja.atacar(segundoNinja);
        segundoNinja.atacar(primeiroNinja);

        primeiroNinja.atacar(segundoNinja);
        segundoNinja.atacar(primeiroNinja);

        if (primeiroNinja.getChakra() >= segundoNinja.getChakra()) {
            return primeiroNinja;
        } else {
            return segundoNinja;
        }
    }
}
