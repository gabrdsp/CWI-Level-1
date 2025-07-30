import axios from "axios"

import {
  escolherPista,
  escolherCorredor,
  criarCorrida,
  contPosicao,
  buffPista,
} from '../src/index'

let arrayPistas
let arrayPersonagens

beforeAll(async () => {
  arrayPistas = await axios.get('https://gustavobuttenbender.github.io/gus.github/corrida-maluca/pistas.json')
  arrayPersonagens = await axios.get('https://gustavobuttenbender.github.io/gus.github/corrida-maluca/personagens.json')
})

describe('Teste: Obter pista', () => {
  it ('Deve conseguir obter a pista corretamente', async() => {

    const pista = arrayPistas.data[5]
    const pistaTeste = {
    "id": 6,
    "nome": "Montanha Nevada", 
    "tipo": "MONTANHA",
    "descricao": "Uma montanha nevada, os corredores devem dar uma volta inteira nela, como existe muita neve eles terão dificuldade em enxergar",
    "tamanho": 30,
    "debuff": -1,
    "posicoesBuffs": [8, 21]}
    
    expect(pistaTeste).toEqual(pista)
  })
})

describe('Teste: Obter corredor', () => {
  it('Deve conseguir obter o corredor corretamente', async() => {

    const pista = escolherPista(arrayPistas.data[0])
    const corredorTeste = {
    "id": 6,
    "nome": "Penélope Charmosa",
    "velocidade": 4,
    "drift": 3, 
    "aceleracao": 5,
    "vantagem": "CIDADE"
    }

    const personagens = []
    personagens.push(escolherCorredor(arrayPersonagens.data,'Penélope Charmosa', 'Dick Vigarista', 'Barão Vermelho'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Penélope Charmosa', null, 'Peter Perfeito'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Peter Perfeito','Penélope Charmosa','Barão Vermelho'))
    const vencedor = criarCorrida(pista, personagens)
    
    expect(corredorTeste).toEqual(arrayPersonagens.data[5])
  })
})

describe('Teste: Calcular vantagens de pistas', () => {
  it('Deve conseguir calcular a vantagem de tipo pista corretamente', async() => {

    const pista = escolherPista(arrayPistas.data[1])
    const personagens = []

    personagens.push(escolherCorredor(arrayPersonagens.data,'Peter Perfeito','Barão Vermelho','Penélope Charmosa'))
    const buffs = buffPista(pista)
    contPosicao(pista, personagens, buffs)

    expect(3).toEqual(personagens[0].proximaPosicao)
  })
})

describe('Teste: Calcular debuff de pista', () => {
  it('Deve conseguir calcular o debuff de pista corretamente', async() => {

    const pista = escolherPista(arrayPistas.data[0])
    const personagens = []

    personagens.push(escolherCorredor(arrayPersonagens.data,'Peter Perfeito','Barão Vermelho','Penélope Charmosa'))
    const buffs = buffPista(pista)
    contPosicao(pista, personagens, buffs)

    expect(0).toEqual(personagens[0].proximaPosicao)
  })
})

describe('Teste: Calcular buff de posição', () => {
  it('Deve conseguir calcular o buff de posição de pista para 3 corredores', async() => {

  const pista = escolherPista(arrayPistas.data[0])
  const personagens =[]
  personagens.push(escolherCorredor(arrayPersonagens.data,'Irmãos Rocha', 'Professor Aéreo', 'Sargento Bombarda'))
  personagens.push(escolherCorredor(arrayPersonagens.data,'Quadrilha da Morte', null, 'Peter Perfeito'))
  personagens.push(escolherCorredor(arrayPersonagens.data,'Tio Tomás','Rufus Lenhador','Irmãos Pavor'))
  
  const vencedor = criarCorrida(pista, personagens)
  const testeFinal = [34, 25, 21]
  const posicoesFinais = [personagens[0].posicaoPista, personagens[1].posicaoPista, personagens[2].posicaoPista]

  expect(testeFinal).toEqual(posicoesFinais)
  })
})

describe('Teste: Calcular próxima posição - aliado ', () => {
  it('Deve conseguir calcular a próxima posição corretamente se estiver sob o buff de um aliado', async() => {
    
    const pista = escolherPista(arrayPistas.data[0])
    const personagens = []
    personagens.push(escolherCorredor(arrayPersonagens.data,'Dick Vigarista','Penélope Charmosa'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Penélope Charmosa','Peter Perfeito','Irmãos Rocha'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Peter Perfeito','Barão Vermelho','Penélope Charmosa'))

    const testeFinal = [3]
    const buffs = buffPista(pista)
    contPosicao(pista, personagens, buffs)
    const posicoesFinais = [personagens[1].proximaPosicao]

    expect(testeFinal).toEqual(posicoesFinais)
  })
})

describe('Teste: Calcular próxima posicação -inimigo', () => {
  it('Deve conseguir calcular a próxima posição corretamente se estiver sob o debuff de um inimigo', async() => {

    const pista = escolherPista(arrayPistas.data[0])
    const personagens = []
    personagens.push(escolherCorredor(arrayPersonagens.data,'Dick Vigarista','Penélope Charmosa','Peter Perfeito'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Penélope Charmosa',null,'Irmãos Rocha'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Peter Perfeito','Barão Vermelho','Penélope Charmosa'))
    
    const testeFinal = [2]
    const buffs = buffPista(pista)
    contPosicao(pista, personagens, buffs)
    const posicoesFinais = [personagens[1].proximaPosicao]

    expect(testeFinal).toEqual(posicoesFinais)

  })
})

describe('Teste: Completar corrida com vencedor', () => {
  it('Deve conseguir completar uma corrida com um vencedor', async() => {

    const pista = escolherPista(arrayPistas.data[0])
    const personagens = []
    personagens.push(escolherCorredor(arrayPersonagens.data,'Dick Vigarista','Penélope Charmosa','Peter Perfeito'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Penélope Charmosa',null,'Irmãos Rocha'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Peter Perfeito','Barão Vermelho','Penélope Charmosa'))
    const vencedor = criarCorrida(pista, personagens)
    const testeFinal = personagens[0].nome

    expect(testeFinal).toEqual(vencedor)
  })
})

describe('Teste: Criar corredor somente com aliado', () => {
  it('Deve conseguir criar corredor corretamente somente com aliado', async() => {

    const pista = escolherPista(arrayPistas.data[0])
    const personagens = []
    personagens.push(escolherCorredor(arrayPersonagens.data,'Dick Vigarista','Penélope Charmosa',null))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Penélope Charmosa','Peter Perfeito',null))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Peter Perfeito',null,null))
    const testeFinal = {
      id: 6,
      nome: "Penélope Charmosa",
      velocidade: 4,
      drift: 3, 
      aceleracao: 5,
      vantagem: "CIDADE",
      posicaoPista: 0,
      proximaPosicao: 0,
      aliado: 'Peter Perfeito',
    }

    expect(testeFinal).toEqual(personagens[1])

  })
})

describe ('Teste: Criar corredor somente com inimigo', () => {
  it('Deve conseguir criar corredor corretamente somente com inimigo', async() => {

    const pista = escolherPista(arrayPistas.data[0])
    const personagens = []
    personagens.push(escolherCorredor(arrayPersonagens.data,'Barão Vermelho','Penélope Charmosa',null))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Penélope Charmosa',null,'Dick Vigarista'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Peter Perfeito','Barão Vermelho','Penélope Charmosa'))
    const testeFinal = {
      id: 6,
      nome: 'Penélope Charmosa',
      velocidade: 4,
      drift: 3,
      aceleracao: 5,
      vantagem: 'CIDADE',
      posicaoPista: 0,
      proximaPosicao: 0,
      inimigo: 'Dick Vigarista'
    }
    expect(testeFinal).toEqual(personagens[1])

  })
})


describe('Teste: Criar corredor com aliado e inimigo', () => {
  it('Deve conseguir criar corredor corretamente com aliado e inimigo', async() => {

    const pista = escolherPista(arrayPistas.data[0])
    const personagens = []
    personagens.push(escolherCorredor(arrayPersonagens.data,'Dick Vigarista','Penélope Charmosa',null))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Penélope Charmosa',null,'Irmãos Rocha'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Peter Perfeito','Barão Vermelho','Penélope Charmosa'))
    const testeFinal = {
      id: 10,
      nome: 'Peter Perfeito',
      velocidade: 7,
      drift: 1,
      aceleracao: 2,
      vantagem: 'CIRCUITO',
      posicaoPista: 0,
      proximaPosicao: 0,
      aliado: 'Barão Vermelho',
      inimigo: 'Penélope Charmosa'
    }

    expect(testeFinal).toEqual(personagens[2])
  })
})

describe('Teste: Calcular novas posições', () => {
  it('Deve conseguir calcular as novas posições corretamente de uma rodada para a próxima', async() => {

    const pista = escolherPista(arrayPistas.data[0])
    const personagens = []
    personagens.push(escolherCorredor(arrayPersonagens.data,'Dick Vigarista','Penélope Charmosa','Peter Perfeito'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Penélope Charmosa',null,'Irmãos Rocha'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Peter Perfeito','Barão Vermelho','Penélope Charmosa'))
    const testeFinal = [6, 4, 0]

    const buffs = buffPista(pista)
    contPosicao(pista, personagens, buffs)
    pista.rodada++
    contPosicao(pista, personagens, buffs)
    const posicoesFinais= [personagens[0].proximaPosicao, personagens[1].proximaPosicao, personagens[2].proximaPosicao]

    expect(testeFinal).toEqual(posicoesFinais)
  })
})

describe('Teste: Velocidade negativa', () => {
  it('Deve impedir que corredor se mova negativamente mesmo se o calculo de velocidade seja negativo', async() => {

    const pista = escolherPista(arrayPistas.data[0])
    const personagens = []
    personagens.push(escolherCorredor(arrayPersonagens.data,'Dick Vigarista','Penélope Charmosa','Peter Perfeito'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Penélope Charmosa',null,'Irmãos Rocha'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Peter Perfeito','Barão Vermelho','Penélope Charmosa'))

    const testeFinal = [0]
  
    const buffs = buffPista(pista)
    contPosicao(pista, personagens, buffs)
    pista.rodada++
    contPosicao(pista, personagens, buffs)
    const posicoesFinais = [personagens[2].proximaPosicao]

    expect(testeFinal).toEqual(posicoesFinais)
  })
})

describe('Teste: Dick Vigarista não pode ganhar', () => {
  it('Deve impedir que o Dick Vigarista vença a corrida se estiver a uma rodada de ganhar', async () => {

    const pista = escolherPista(arrayPistas.data[0])
    const personagens = []
    personagens.push(escolherCorredor(arrayPersonagens.data,'Dick Vigarista','Penélope Charmosa','Peter Perfeito'))
    personagens.push(escolherCorredor(arrayPersonagens.data,'Penélope Charmosa',null,'Irmãos Rocha'))

    const vencedor = criarCorrida(pista, personagens)
    const testeFinal = 'Penélope Charmosa'

    expect(testeFinal).toEqual(vencedor)
  })
})