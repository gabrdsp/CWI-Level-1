package mercadodabola.Jogador;

import mercadodabola.ApetiteFinanceiro.ApetiteFin;
import mercadodabola.Clube.Clube;

import java.math.BigDecimal;

public class Goleiro extends Jogador {
    private final int penaltisDefendidos;
    private static final BigDecimal ACRESCIMO_POR_PENALTI = new BigDecimal("0.04");

    public Goleiro(final String nome, final int idade, final Clube clubeAtual,
                   final int reputacaoHistorica, final ApetiteFin apetiteFinanceiro,
                   final BigDecimal preco, final int penaltisDefendidos) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.penaltisDefendidos = penaltisDefendidos;
    }

    public int getPenaltisDefendidos() {
        return penaltisDefendidos;
    }

    @Override
    public BigDecimal calcularValorCompra() {
        final BigDecimal base = super.calcularValorCompra();
        final BigDecimal acrescimo = ACRESCIMO_POR_PENALTI.multiply(new BigDecimal(penaltisDefendidos));
        return base.multiply(BigDecimal.ONE.add(acrescimo));
    }
}
