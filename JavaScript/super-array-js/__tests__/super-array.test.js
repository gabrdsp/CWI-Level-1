import instrutores from "./instrutores.json";
import { SuperArray } from "../src/super-array";

describe("Expected testes", () => {
  it("push deve adicionar um novo instrutor ao meu super array", () => {
    const instrutoresArray = new SuperArray(instrutores);
    const novoInstrutor = { nome: "Gabriel", dandoAula: false };

    instrutoresArray.push(novoInstrutor);

    expect(instrutoresArray.itens[instrutoresArray.itens.length - 1]).toEqual(
      novoInstrutor
    );
    expect(instrutoresArray.itens.length).toBe(instrutores.length + 1);
  });

  it("forEach deve passar por todos os instrutores e chamando o callback esperado", () => {
    const instrutoresArray = new SuperArray(instrutores);
    let contador = 0;

    instrutoresArray.forEach(() => {
      contador++;
    });

    expect(contador).toBe(instrutores.length);
  });

  it("filter deve retornar um novo array apenas com os instrutores que estão dando aula", () => {
    const instrutoresArray = new SuperArray(instrutores);
    const instrutoresDandoAula = instrutoresArray.filter(
      (instrutor) => instrutor.dandoAula
    );

    const resultadoEsperado = instrutores.filter(
      (instrutor) => instrutor.dandoAula
    );

    expect(instrutoresDandoAula.itens).toEqual(resultadoEsperado);
  });

  it("map deve retornar um novo array com o numero de nomes que o instrutor tem", () => {
    const instrutoresArray = new SuperArray(instrutores);
    const instrutoresNumeroDeNome = instrutoresArray.map(
      (instrutor) => instrutor.nome.split(" ").length
    );

    const resultadoEsperado = instrutores.map(
      (instrutor) => instrutor.nome.split(" ").length
    );

    expect(instrutoresNumeroDeNome.itens).toEqual(resultadoEsperado);
  });

  it("find deve retornar o primeiro instrutor que está dando aula", () => {
    const instrutoresArray = new SuperArray(instrutores);
    const instrutoresQueEstaoDandoAula = instrutoresArray.find(
      (instrutor) => instrutor.dandoAula
    );

    const resultadoEsperado = instrutores.find(
      (instrutor) => instrutor.dandoAula
    );

    expect(instrutoresQueEstaoDandoAula).toEqual(resultadoEsperado);
  });

  it("reduce deve retornar o total de letras no nome dos instrutores", () => {
    const instrutoresArray = new SuperArray(instrutores);
    const totalDeLetras = instrutoresArray.reduce((total, instrutor) => {
      return total + instrutor.nome.replace(/\s/g, "").length;
    }, 0);

    const resultadoEsperado = instrutores.reduce(
      (total, instrutor) => total + instrutor.nome.replace(/\s/g, "").length,
      0
    );

    expect(totalDeLetras).toBe(resultadoEsperado);
  });

  it("reduce deve retornar um boolean se todos os instrutores estão dando aula", () => {
    const instrutoresArray = new SuperArray(instrutores);
    const todosEstaoDandoAula = instrutoresArray.reduce((acumulador, instrutor) => {
      return acumulador && instrutor.dandoAula;
    }, true);

    const resultadoEsperado = instrutores.every(
      (instrutor) => instrutor.dandoAula
    );

    expect(todosEstaoDandoAula).toBe(resultadoEsperado);
  });
});
