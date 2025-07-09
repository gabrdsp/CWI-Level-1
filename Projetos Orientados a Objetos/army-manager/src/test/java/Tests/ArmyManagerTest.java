package Tests;

import Militares.Militares;
import Pilotos.Pilotos;
import SimulacaoFinanceira.SimulacaoFinanceira;
import Veiculos.Veiculos;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import  static org.junit.Assert.assertEquals;

public class ArmyManagerTest {

    @Test
    public void deveCalcularOCustoTotalDaMissaoCorretamente() {

        // Arrange
        List<Veiculos> listaDeVeiculos = new ArrayList<>();
        listaDeVeiculos.add(criarUmVeiculo());

        // Act
        SimulacaoFinanceira simulacaoDeMissao = new SimulacaoFinanceira(500, listaDeVeiculos, 2);
        BigDecimal custoTotalCalculado = simulacaoDeMissao.calcularCustoTotal();

        // Assert
        assertEquals(new BigDecimal("6700.00"), custoTotalCalculado.setScale(2));
    }

    @Test
    public void deveCalcularOCustoToralComSalariosCorretamente() {

        // Arrange
        Veiculos veiculoSimulado = criarUmVeiculo();

        // Act
        BigDecimal custoDeSalarios = veiculoSimulado.calcularCustoSalarios();

        // Assert
        assertEquals(new BigDecimal("3250.00"), custoDeSalarios.setScale(2));
    }

    @Test
    public void deveCalcularOCustoTotalComCombustivelCorretamente() {
        // Arrange
        Veiculos veiculoSimulado = criarUmVeiculo();

        // Act
        BigDecimal custoDeCombustivel = veiculoSimulado.calcularCustoCombustivel(500);

        // Assert
        assertEquals(new BigDecimal("200.00"), custoDeCombustivel.setScale(2));
    }

    @Test
    public void deveCalcularCustoApenasComSalariosQuandoCombustivelZero() {
        // Arrange
        Pilotos pilotoSimulado = new Pilotos(BigDecimal.valueOf(1000), LocalDate.now().plusDays(10));
        List<Militares> equipeSimulada = new ArrayList<>();
        equipeSimulada.add(new Militares(BigDecimal.valueOf(1000)));

        // Act
        Veiculos veiculoSemCombustivel = new Veiculos(pilotoSimulado, equipeSimulada, 10, BigDecimal.ZERO);
        List<Veiculos> veiculos = new ArrayList<>();
        veiculos.add(veiculoSemCombustivel);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, veiculos, 1);
        BigDecimal custoTotal = simulacao.calcularCustoTotal();

        // Assert
        assertEquals(new BigDecimal("2000.00"), custoTotal.setScale(2));
    }

    @Test
    public void deveCalcularCustoApenasComCombustivelQuandoDuracaoZero() {
        // Arrange
        Pilotos pilotoSimulado = new Pilotos(BigDecimal.valueOf(3000), LocalDate.now().plusDays(10));
        List<Militares> equipeSimulada = new ArrayList<>();
        equipeSimulada.add(new Militares(BigDecimal.valueOf(1500)));

        // Act
        Veiculos veiculoComDuracaoZero = new Veiculos(pilotoSimulado, equipeSimulada, 10, BigDecimal.valueOf(5));
        List<Veiculos> veiculos = new ArrayList<>();
        veiculos.add(veiculoComDuracaoZero);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, veiculos, 0);
        BigDecimal custoTotal = simulacao.calcularCustoTotal();

        // Assert
        assertEquals(new BigDecimal("500.00"), custoTotal.setScale(2));
    }

    @Test
    public void deveCalcularCustoTotalComTripulacaoNula() {
        // Arrange
        Pilotos pilotoSozinho = new Pilotos(BigDecimal.valueOf(3000), LocalDate.now().plusDays(15));

        // Act
        Veiculos veiculoSemTripulacao = new Veiculos(pilotoSozinho, null, 10, BigDecimal.valueOf(5));
        List<Veiculos> veiculos = new ArrayList<>();
        veiculos.add(veiculoSemTripulacao);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, veiculos, 1);
        BigDecimal custoTotal = simulacao.calcularCustoTotal();

        // Assert
        assertEquals(new BigDecimal("3500.00"), custoTotal.setScale(2)); // 3000 + 1000/10*5 = 3000 + 500
    }

    private Veiculos criarUmVeiculo() {
        Pilotos pilotosSimulado = new Pilotos(BigDecimal.valueOf(2000), LocalDate.now().plusDays(30));
        List<Militares> equipeSimulada = new ArrayList<>();
        equipeSimulada.add(new Militares(BigDecimal.valueOf(1250)));
        return new Veiculos(pilotosSimulado, equipeSimulada, 5, BigDecimal.valueOf(2));
    }
}

