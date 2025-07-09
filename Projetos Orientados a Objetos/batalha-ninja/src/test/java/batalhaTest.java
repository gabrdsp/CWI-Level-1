import org.junit.Assert;
import org.junit.Test;

public class batalhaTest {

    @Test
    public void deveRetornarNinjaComJutsuMaisForteSeOsDoisGastamOMesmoChakra() {
        Jutsu jutsuNinjaUm = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Gabriel", jutsuNinjaUm);

        Jutsu jutsuNinjaDois = new Jutsu(5, 8);
        Ninja ninjaDois = new Ninja("Naruto", jutsuNinjaDois);

        Batalha batalha = new Batalha();
        Ninja ninjaVencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertTrue(ninjaVencedor == ninjaUm);
    }

    @Test
    public void deveAtualizarOChakraDoOponenteDeAcordoComODanoDoJutsoQuandoAtacar() {
        Jutsu jutsuNinjaAtacante = new Jutsu(5, 10);
        Ninja ninjaAtacante = new Ninja("Gabriel", jutsuNinjaAtacante);

        Jutsu jutsuNinjaOponente = new Jutsu(5, 8);
        Ninja ninjaOponente = new Ninja("Naruto", jutsuNinjaOponente);

        int nivelChakraEsperado = 90;

        ninjaAtacante.atacar(ninjaOponente);

        Assert.assertEquals(nivelChakraEsperado, ninjaOponente.getChakra());
    }

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoONomeForItachi() {
        Jutsu jutsu = new Jutsu(3, 6);
        Ninja itachi = new Ninja("Itachi", jutsu);
        Ninja oponente = new Ninja("Gabriel", jutsu);

        Batalha batalha = new Batalha();
        Ninja vencedor = batalha.lutar(itachi, oponente);

        Assert.assertTrue(vencedor == itachi);
    }

    @Test
    public void deveRetornarSegundoNinjaComoVencedorQuandoONomeForItachi() {
        Jutsu jutsu = new Jutsu(3, 6);
        Ninja oponente = new Ninja("Gabriel", jutsu);
        Ninja itachi = new Ninja("Itachi", jutsu);

        Batalha batalha = new Batalha();
        Ninja vencedor = batalha.lutar(oponente, itachi);

        Assert.assertTrue(vencedor == itachi);
    }

    @Test
    public void deveRetornarPrimeiroNinjaComoVencedorQuandoEmpatar() {
        Jutsu jutsu = new Jutsu(5, 10);
        Ninja ninjaUm = new Ninja("Gabriel", jutsu);
        Ninja ninjaDois = new Ninja("Cresceruto", jutsu);

        Batalha batalha = new Batalha();
        Ninja vencedor = batalha.lutar(ninjaUm, ninjaDois);

        Assert.assertTrue(vencedor == ninjaUm);
    }
}
