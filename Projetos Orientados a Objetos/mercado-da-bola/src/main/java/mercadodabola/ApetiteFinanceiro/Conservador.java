package mercadodabola.ApetiteFinanceiro;

import java.math.BigDecimal;

public class Conservador extends ApetiteFin {
    private static final BigDecimal MULTIPLICADOR = new BigDecimal("1.4");

    @Override
    public BigDecimal calcular(final BigDecimal preco) {
        return preco.multiply(MULTIPLICADOR);
    }
}
