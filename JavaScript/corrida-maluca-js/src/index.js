export function escolherPista(pista) {
  pista = { ...pista, rodada: 1 };
  return pista;
}

export function escolherCorredor(listaCarros, personagem, aliado, inimigo) {
  for (let index = 0; index < listaCarros.length; index++) {
    if (personagem == listaCarros[index].nome) {
      if (aliado !== null && inimigo !== null) {
        personagem = {
          ...listaCarros[index],
          posicaoPista: 0,
          proximaPosicao: 0,
          aliado: aliado,
          inimigo: inimigo,
        };
      } else if (inimigo !== null && aliado == null) {
        personagem = {
          ...listaCarros[index],
          posicaoPista: 0,
          proximaPosicao: 0,
          inimigo: inimigo,
        };
      } else if (aliado !== null && inimigo == null) {
        personagem = {
          ...listaCarros[index],
          posicaoPista: 0,
          proximaPosicao: 0,
          aliado: aliado,
        };
      } else {
        personagem = { ...listaCarros[index], posicaoPista: 0, proximaPosicao: 0 };
      }
    }
  }
  return personagem;
}

export function buffPista(pista) {
  let checkPoint = [];
  for (let i = 0; i < pista.posicoesBuffs.length; i++) {
    checkPoint[i] = { posicao: pista.posicoesBuffs[i], carrosCheckPoint: [] };
  }
  return [...checkPoint];
}

export function contPosicao(pista, personagens, buffs) {
  for (let index = 0; index < personagens.length; index++) {
    let posicaoAtual = personagens[index].posicaoPista;
    let corredor = undefined;
    let auxAliado = 0;
    let auxInimigo = 0;
    let posicaoAliado = null;
    let posicaoInimigo = null;

    corredor = personagens.find(
      (carro) => carro.nome == personagens[index].aliado
    );
    if (corredor != undefined) {
      posicaoAliado = corredor.posicaoPista;
    }
    if (posicaoAliado != null) {
      auxAliado = posicaoAtual - posicaoAliado;
      if (auxAliado <= 2 && auxAliado >= -2) {
        auxAliado = 1;
      } else {
        auxAliado = 0;
      }
    }

    corredor = personagens.find(
      (carro) => carro.nome == personagens[index].inimigo
    );
    if (corredor != undefined) {
      posicaoInimigo = corredor.posicaoPista;
    }
    if (posicaoInimigo != null) {
      auxInimigo = posicaoAtual - posicaoInimigo;
      if (auxInimigo <= 2 && auxInimigo >= -2) {
        auxInimigo = 1;
      } else {
        auxInimigo = 0;
      }
    }

    let vantagemPista = 0;
    if (personagens[index].vantagem == pista.tipo) {
      vantagemPista = 2;
    }

    let posicao;
    if (pista.rodada < 4) {
      posicao =
        personagens[index].aceleracao +
        pista.debuff +
        vantagemPista +
        auxAliado -
        auxInimigo;
    } else if (pista.rodada % 4 == 0) {
      posicao =
        personagens[index].drift +
        pista.debuff +
        vantagemPista +
        auxAliado -
        auxInimigo;
    } else {
      posicao =
        personagens[index].velocidade +
        pista.debuff +
        vantagemPista +
        auxAliado -
        auxInimigo;
    }

    if (posicao < 0) {
      posicao = 0;
    }
    personagens[index].proximaPosicao += posicao;
  }

  personagens = contBuff(personagens, buffs);

  for (let index = 0; index < personagens.length; index++) {
    if (personagens[index].nome == "Dick Vigarista") {
      if (personagens[index].proximaPosicao >= pista.tamanho) {
        personagens[index].proximaPosicao = personagens[index].posicaoPista;
      }
    }
  }
}

export function contBuff(personagens, buffPista) {
  personagens.sort((a, b) => b.proximaPosicao - a.proximaPosicao);

  for (let index = 0; index < personagens.length; index++) {
    for (let checkPoint of buffPista) {
      if (personagens[index].proximaPosicao > checkPoint.posicao) {
        if (!checkPoint.carrosCheckPoint.includes(personagens[index].nome)) {
          personagens[index].proximaPosicao += checkPoint.carrosCheckPoint.length;
          checkPoint.carrosCheckPoint.push(personagens[index].nome);
        }
      }
    }
  }
  return [...personagens];
}

export function testVencedor(pista, personagens) {
  for (let index = 0; index < personagens.length; index++) {
    if (personagens[index].posicaoPista >= pista.tamanho) {
      return personagens[index].nome;
    }
  }
  return null;
}

export function contRodada(pista, personagens, buffs) {
  let indexVencedor = null;
  while (indexVencedor == null) {
    contPosicao(pista, personagens, buffs);
    for (let index = 0; index < personagens.length; index++) {
      personagens[index].posicaoPista = personagens[index].proximaPosicao;
    }
    pista.rodada++;
    indexVencedor = testVencedor(pista, personagens);
  }
  return indexVencedor;
}

export function criarCorrida(pista, personagens) {
  const buffs = buffPista(pista);
  const vencedor = contRodada(pista, personagens, buffs);
  return vencedor;
}
