package mercadodabola.ApetiteFinanceiro;

import java.math.BigDecimal;

public class Mercenario extends ApetiteFin {
    private static final BigDecimal MULTIPLICADOR = new BigDecimal("1.8");

    @Override
    public BigDecimal calcular(final BigDecimal preco) {
        return preco.multiply(MULTIPLICADOR);
    }
}
