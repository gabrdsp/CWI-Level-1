const listaPokemonInicial = [
  {
    id: 1,
    nome: "Squirtle",
    poderAtaque: 1,
    levelInicial: 1,
    evolucao: {
      level: 5,
      id: 2,
    },
  },
  {
    id: 2,
    nome: "Wartortle",
    poderAtaque: 10,
    levelInicial: 5,
    evolucao: {
      level: 10,
      id: 3,
    },
  },
  {
    id: 3,
    nome: "Blastoise",
    poderAtaque: 100,
    levelInicial: 10,
    evolucao: null,
  },
  {
    id: 4,
    nome: "Cyndaquil",
    poderAtaque: 1,
    levelInicial: 1,
    evolucao: {
      level: 5,
      id: 5,
    },
  },
  {
    id: 5,
    nome: "Quilava",
    poderAtaque: 10,
    levelInicial: 5,
    evolucao: {
      level: 10,
      id: 6,
    },
  },
  {
    id: 6,
    nome: "Thyphlosion",
    poderAtaque: 100,
    levelInicial: 10,
    evolucao: null,
  },
  {
    id: 7,
    nome: "Bulbasaur",
    poderAtaque: 1,
    levelInicial: 1,
    evolucao: {
      level: 5,
      id: 8,
    },
  },
  {
    id: 8,
    nome: "Ivysaur",
    poderAtaque: 10,
    levelInicial: 5,
    evolucao: {
      level: 10,
      id: 9,
    },
  },
  {
    id: 9,
    nome: "Venusaur",
    poderAtaque: 100,
    levelInicial: 10,
    evolucao: null,
  },
];

function listaPokemons(listaPokemonTreinador) {
  let listaPokemons = listaPokemonTreinador;
  return listaPokemons;
}

function novoTreinadorPokemon(nome, idade, pokeInicial) {
  let lista = listaPokemons(listaPokemonInicial);
  const pokemoninicial = lista.find((pokemon) => pokemon.nome == pokeInicial);
  let treinador = {
    nome,
    idade,
    listaPokemonTreinador: [{ ...pokemoninicial }],
  };
  return treinador;
}

function adicionarPokemon(treinador, pokemon) {
  let lista = listaPokemons(listaPokemonInicial);
  treinador.listaPokemonTreinador.push(
    lista.find((poke) => poke.nome == pokemon)
  );
}

function subirLevel(treinador) {
  return treinador.listaPokemonTreinador.map((pokemon) => {
    return { ...pokemon, levelInicial: pokemon.levelInicial++ };
  });
}

function evoluir(treinador) {
  let lista = listaPokemons(listaPokemonInicial);
  for (let index = 0; index < treinador.listaPokemonTreinador.length; index++) {
    if (treinador.listaPokemonTreinador[index].evolucao !== null) {
      if (
        treinador.listaPokemonTreinador[index].evolucao.level ==
        treinador.listaPokemonTreinador[index].levelInicial
      ) {
        treinador.listaPokemonTreinador[index] = lista.find(
          (pokemon) =>
            pokemon.id == treinador.listaPokemonTreinador[index].evolucao.id
        );
      }
    }
  }
}

function capturarPokemon(treinador, pokemon) {
  adicionarPokemon(treinador, pokemon);
  subirLevel(treinador);
  evoluir(treinador);
}

export {
  capturarPokemon,
  evoluir,
  subirLevel,
  adicionarPokemon,
  novoTreinadorPokemon,
};
