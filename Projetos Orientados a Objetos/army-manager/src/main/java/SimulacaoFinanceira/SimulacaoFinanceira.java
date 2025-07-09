package SimulacaoFinanceira;

import Veiculos.Veiculos;

import java.math.BigDecimal;
import java.util.List;

public class SimulacaoFinanceira {
    private double distanciaPercorrida;
    private List<Veiculos> veiculosParticipantes;
    private int tempoDeDuracao;

    public SimulacaoFinanceira(double distanciaPercorrida, List<Veiculos> veiculosParticipantes, int tempoDeDuracao) {
        this.distanciaPercorrida = distanciaPercorrida;
        this.veiculosParticipantes = veiculosParticipantes;
        this.tempoDeDuracao = tempoDeDuracao;
    }

    public BigDecimal calcularCustoTotal() {
        BigDecimal valorTotalMissao = BigDecimal.ZERO;

        for (Veiculos veiculoAtual : veiculosParticipantes) {
            BigDecimal custoSalario = veiculoAtual.calcularCustoSalarios().multiply(BigDecimal.valueOf(tempoDeDuracao));
            BigDecimal custoCombustivel = veiculoAtual.calcularCustoCombustivel(distanciaPercorrida);
            valorTotalMissao = valorTotalMissao.add(custoSalario).add(custoCombustivel);
        }

        return  valorTotalMissao;

    }
}