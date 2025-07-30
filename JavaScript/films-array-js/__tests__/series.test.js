import axios from 'axios'

import {
  verificarSeAtorEstaEmSeriado,
  filtarPorAnoERetornarNome,
  calcularMediaTotalDeEpisodios,
  agruparTituloDasSeriesPorPropriedade,
} from '../src/metodos'


describe('Exemplo de testes', () => {
  it('Valor importado deve ser true', () => {
    expect(true).toBeTruthy()
  })
})

describe("Teste: Estreia superior a 2010", () => {
  it("Deve filtrar as series com ano de estreia maior ou igual a 2010 e retornar uma listagem com os nomes", async () => {
    const respost = await axios.get("https://gustavobuttenbender.github.io/film-array/data/films.json");

    const aux = [
      "Stranger Things",
      "Game Of Thrones",
      "The Walking Dead",
      "Band of Brothers",
      "Gus and Will The Masters of the Wizards",
      "10 Days Why",
      "Mr. Robot",
      "Narcos",
      "Westworld",
    ];
    const list = filtarPorAnoERetornarNome(respost.data, 2010);
    console.log(list);

    expect(list).toEqual(aux);
  });
});

describe("Teste: Ator está no elenco", () => {
  it("Deve retornar true ao procurar ator que está em elenco", async () => {
    const respost = await axios.get("https://gustavobuttenbender.github.io/film-array/data/films.json");

    const list = verificarSeAtorEstaEmSeriado(respost.data, "Emilia Clarke"
    // Daenerys Nascida da Tormenta da Casa Targaryen, a Primeira de Seu Nome, 
    // Rainha dos Ândalos e dos Primeiros Homens, Protetora dos Sete Reinos, Mãe dos Dragões, 
    // Khaleesi do Grande Mar de Grama, A Não-Queimada e Quebradora de Correntes.
    );

    expect(list).toEqual(true);
  });
});

describe("Teste: Ator não está no elenco", () => {
  it("Deve retornar false ao procurar ator que não participa de elenco", async () => {
    const respost = await axios.get("https://gustavobuttenbender.github.io/film-array/data/films.json");

    const list = verificarSeAtorEstaEmSeriado(
      respost.data, "Jennifer Morrison" // Minha admirável Emma Swan
    ); 

    expect(list).toEqual(false);
  });
});

describe("Teste: Média total de episódios", () => {
  it("Deve calcular corretamente a media total de episódios de todas as series", async () => {
    const respost = await axios.get("https://gustavobuttenbender.github.io/film-array/data/films.json");

    const aux = (358/10);
    const list = calcularMediaTotalDeEpisodios(respost.data);

    expect(list).toEqual(aux);
  });
});

describe("Teste: Titulos e distribuidora", () => {
  it("Deve agrupar corretamente em um objeto os titulos das series baseado na Distribuidora", async () => {
    const respost = await axios.get("https://gustavobuttenbender.github.io/film-array/data/films.json");

    const aux = "Stranger Things, Narcos";
    const list = agruparTituloDasSeriesPorPropriedade(respost.data, "Netflix");

    expect(list).toEqual(aux);
  });
});
