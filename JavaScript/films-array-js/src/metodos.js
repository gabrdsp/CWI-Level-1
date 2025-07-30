export function filtarPorAnoERetornarNome(series, ano) {
  let listaAno = [];
  series
    .filter((a) => a.anoEstreia >= ano)
    .map((list) => {
      listaAno.push(list.titulo);
    });
  return listaAno;
}

export function verificarSeAtorEstaEmSeriado(series, nomeAtor) {
  let result = [];
  result = series.find((a) => a.elenco.find((ator) => ator === nomeAtor));
  return !!result
  }

export function calcularMediaTotalDeEpisodios(series) {
  let result = 0;
  series.map((a) => {
    result += a.numeroEpisodios;
  });

  return result / series.length;
}

export function agruparTituloDasSeriesPorPropriedade(series, propriedade) {
  const reducer = (valorAnterior, valorAtual) =>
    valorAnterior + ", " + valorAtual;
  let listaPropriedade = [];
  series
    .filter((a) => a.distribuidora == propriedade).map((list) => {
      listaPropriedade.push(list.titulo);
    });
  return listaPropriedade.reduce(reducer);
}
