package Veiculos;

import Militares.Militares;
import Pilotos.Pilotos;

import java.math.BigDecimal;
import java.util.List;

public class Veiculos {
    private Pilotos condutorPrincipal;
    private List<Militares> equipeTripulante;
    private double rendimentoKmPorLitro;
    private BigDecimal valorPorLitroCombustivel;

    public Veiculos(Pilotos condutorPrincipal, List<Militares> equipeTripulante, double rendimentoKmPorLitro, BigDecimal valorPorLitroCombustivel) {
        this.condutorPrincipal = condutorPrincipal;
        this.equipeTripulante = equipeTripulante;
        this.rendimentoKmPorLitro = rendimentoKmPorLitro;
        this.valorPorLitroCombustivel = valorPorLitroCombustivel;
    }

    public BigDecimal calcularCustoCombustivel(double distanciaMissao) {
        if (rendimentoKmPorLitro == 0 || valorPorLitroCombustivel == null) {
            return BigDecimal.ZERO;
        }

        double litrosNecessarios = distanciaMissao / rendimentoKmPorLitro;
        return BigDecimal.valueOf(litrosNecessarios).multiply(valorPorLitroCombustivel);
    }

    public BigDecimal calcularCustoSalarios() {
        BigDecimal totalSalarios = condutorPrincipal.getValorSalario();
        if (equipeTripulante != null) {
            for (Militares membroEquipe : equipeTripulante) {
                totalSalarios = totalSalarios.add(membroEquipe.getValorSalario());
            }
        }
        return totalSalarios;
    }

}