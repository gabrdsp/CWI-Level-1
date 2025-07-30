export const SuperArray = (itens = []) => {
  const array = { 
    /**
     * Propriedade para acessar os itens
     */

    itens: [],
  };

  for (let i = 0; i < itens.length; i++) {
    
    array.itens[i] = itens[i];
  }

  /**
   * Adiciona um novo item ao final dos itens
   */

  array.push = (item) => {
    array.itens[array.itens.length] = item;
  };

  /**
   * Itera sobre cada um dos elementos do SuperArray enviando o item e o index
   * como segundo parametro
   */

  array.forEach = (callback) => {
    for (let i = 0; i < array.itens.length; i++) {
      callback(array.itens[i], i);
    }
  };

  /**
   * Retorna um novo SuperArray com os itens mapeados
   */
  
  array.map = (callback) => {
    const novo = SuperArray();
    for (let i = 0; i < array.itens.length; i++) {
      novo.push(callback(array.itens[i], i));
    }
    return novo;
  };

  /**
   * Retorna um SuperArray novo com os itens filtrados
   */

  array.filter = (callback) => {
    const novo = SuperArray();
    for (let i = 0; i < array.itens.length; i++) {
      if (callback(array.itens[i], i)) {
        novo.push(array.itens[i]);
      }
    }
    return novo;
  };

  /**
   * Retorna o primeiro elemento do SuperArray que satisfazer o callback recebido
   * se não encontrar, deve retornar undefined
   */
  
  array.find = (callback) => {
    for (let i = 0; i < array.itens.length; i++) {
      if (callback(array.itens[i], i)) {
        return array.itens[i];
      }
    }
    return undefined;
  };

  /**
   * Reduz o SuperArray em um único valor
   */

  array.reduce = (callback, valorInicial) => {
    let acumulador = valorInicial;
    let i = 0;

    if (acumulador === undefined) {
      acumulador = array.itens[0];
      i = 1;
    }

    for (; i < array.itens.length; i++) {
      acumulador = callback(acumulador, array.itens[i], i);
    }

    return acumulador;
  };

  return array;
};
