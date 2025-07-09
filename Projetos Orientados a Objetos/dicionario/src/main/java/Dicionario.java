import java.util.HashMap;
import java.util.Map;

public class Dicionario  {
    private Map<String, String> palavrasEmPortugues = new HashMap<>();
    private Map<String, String> palavrasEmIngles = new HashMap<>();

    public void adicionarUmaPalavra(String palavraOriginal, String traducao, TipoDicionario tipoDicionario) {
        switch (tipoDicionario) {
            case Portugues:
                palavrasEmPortugues.put(palavraOriginal.toLowerCase(), traducao);
                break;
            case Ingles:
                palavrasEmIngles.put(palavraOriginal.toLowerCase(), traducao);
                break;
        }
    }

    public String traduzir(String palavraDesejada, TipoDicionario tipoDeBusca) {
        String resultadoDaTraducao = null;

        switch (tipoDeBusca) {
            case Portugues:
                if (!palavrasEmPortugues.containsKey(palavraDesejada.toLowerCase())) {
                    throw new PalavraNaoEncontradaExeption();
                }
                resultadoDaTraducao = palavrasEmPortugues.get(palavraDesejada.toLowerCase());
                break;

            case Ingles:
                if (!palavrasEmIngles.containsKey(palavraDesejada.toLowerCase())) {
                    throw new PalavraNaoEncontradaExeption();
                }
                resultadoDaTraducao = palavrasEmIngles.get(palavraDesejada.toLowerCase());
                break;
        }
        return resultadoDaTraducao;
    }
}