import poke from "../src/poke.json";
import { capturarPokemon } from "../src/index";
import { novoTreinadorPokemon } from "../src/index";

describe("teste 1", () => {
  it("Deve subir o nível do pokemon corretamente", () => {
    const listaPokemons = [poke];
    const treinadorPokemonAtual = novoTreinadorPokemon(
      "Gabriel",
      21,
      "Squirtle"
    );
    const result = 6;
    capturarPokemon(treinadorPokemonAtual, "Bulbasaur");
    capturarPokemon(treinadorPokemonAtual, "Cyndaquil");
    capturarPokemon(treinadorPokemonAtual, "Blastoise");
    capturarPokemon(treinadorPokemonAtual, "Thyphlosion");
    capturarPokemon(treinadorPokemonAtual, "Venusaur");

    const levelPokemon =
      treinadorPokemonAtual.listaPokemonTreinador[0].levelInicial;

    expect(levelPokemon).toEqual(result);
  });
});

describe("teste 2", () => {
  it("Deve evoluir pokemon ao atingir o nível necessário", () => {
    const treinador = novoTreinadorPokemon("Pi", 21, "Squirtle");

    capturarPokemon(treinador, "Bulbasaur");
    capturarPokemon(treinador, "Cyndaquil");
    capturarPokemon(treinador, "Blastoise");
    capturarPokemon(treinador, "Thyphlosion");

    const levelPokemon = treinador.listaPokemonTreinador[0];
    expect(treinador.listaPokemonTreinador[0].nome).toEqual("Wartortle");
  });
});

describe("teste 3", () => {
  it("Não deve evoluir pokemon caso não possua o level necessário", () => {
    const treinadorPokemonAtual = novoTreinadorPokemon(
      "Gabriel",
      21,
      "Squirtle"
    );

    capturarPokemon(treinadorPokemonAtual, "Bulbasaur");
    capturarPokemon(treinadorPokemonAtual, "Cyndaquil");
    capturarPokemon(treinadorPokemonAtual, "Blastoise");
    capturarPokemon(treinadorPokemonAtual, "Thyphlosion");

    expect(treinadorPokemonAtual.listaPokemonTreinador[2].nome).toEqual(
      "Cyndaquil"
    );
  });
});

describe("teste 4", () => {
  it("Treinador será criado com nome correto", () => {
    const treinadorPokemonAtual = novoTreinadorPokemon(
      "Gabriel",
      21,
      "Squirtle"
    );

    capturarPokemon(treinadorPokemonAtual, "Bulbasaur");
    capturarPokemon(treinadorPokemonAtual, "Cyndaquil");
    capturarPokemon(treinadorPokemonAtual, "Blastoise");
    capturarPokemon(treinadorPokemonAtual, "Thyphlosion");

    expect(treinadorPokemonAtual.nome).toEqual("Gabriel");
  });
});

describe("teste 5", () => {
  it("Treinador será criado com a idade correta", () => {
    const treinadorPokemonAtual = novoTreinadorPokemon(
      "Gabriel",
      21,
      "Squirtle"
    );

    capturarPokemon(treinadorPokemonAtual, "Bulbasaur");
    capturarPokemon(treinadorPokemonAtual, "Cyndaquil");
    capturarPokemon(treinadorPokemonAtual, "Blastoise");
    capturarPokemon(treinadorPokemonAtual, "Thyphlosion");

    expect(treinadorPokemonAtual.idade).toEqual(21);
  });
});

describe("teste 6", () => {
  it("Treinador será criado com o pokemon inicial correto", () => {
    const treinadorPokemonAtual = novoTreinadorPokemon(
      "Gabriel",
      21,
      "Squirtle"
    );

    capturarPokemon(treinadorPokemonAtual, "Bulbasaur");

    expect(treinadorPokemonAtual.listaPokemonTreinador[0].nome).toEqual(
      "Squirtle"
    );
  });
});

describe("teste 7", () => {
  it("Treinador terá seus pokemons atualizados após nova captura", () => {
    const treinadorPokemonAtual = novoTreinadorPokemon(
      "Gabriel",
      21,
      "Squirtle"
    );
    const resultadoEsperado = novoTreinadorPokemon("teste", 0, "Squirtle");
    capturarPokemon(resultadoEsperado, "Bulbasaur");
    capturarPokemon(treinadorPokemonAtual, "Bulbasaur");

    expect(treinadorPokemonAtual.listaPokemonTreinador).toEqual(
      resultadoEsperado.listaPokemonTreinador
    );
  });
});
