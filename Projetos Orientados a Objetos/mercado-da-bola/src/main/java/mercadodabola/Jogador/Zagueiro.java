package mercadodabola.Jogador;

import mercadodabola.ApetiteFinanceiro.ApetiteFin;
import mercadodabola.Clube.Clube;

import java.math.BigDecimal;

public class Zagueiro extends Jogador {
    private static final BigDecimal DESCONTO = new BigDecimal("0.8");

    public Zagueiro(final String nome, final int idade, final Clube clubeAtual,
                    final int reputacaoHistorica, final ApetiteFin apetiteFinanceiro,
                    final BigDecimal preco) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
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
