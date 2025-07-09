package mercadodabola.Jogador;

import mercadodabola.ApetiteFinanceiro.ApetiteFin;
import mercadodabola.Clube.Clube;

import java.math.BigDecimal;

public class MeioCampo extends Jogador {
    private static final BigDecimal DESCONTO = new BigDecimal("0.7");

    public MeioCampo(final String nome, final int idade, final Clube clubeAtual,
                     final int reputacaoHistorica, final ApetiteFin apetiteFinanceiro,
                     final BigDecimal preco) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    @Override
    public boolean temInteresse(final Clube clube) {
        return clube.getReputacaoHistorica() <= (getReputacaoHistorica() - 2);
    }

    @Override
    public BigDecimal calcularValorCompra() {
        final BigDecimal valor = super.calcularValorCompra();
        if (getIdade() > 30) {
            return valor.multiply(DESCONTO);
        }
        return valor;
    }
}
