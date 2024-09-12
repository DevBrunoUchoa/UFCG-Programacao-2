
/**
 * Representação de um resumo de estudos, permitindo a adição e gerenciamento de resumos.
 * A classe contém métodos para recuperar, contar e imprimir os resumos cadastrados.
 *
 * @autor João Bruno Tavares Uchoa - 123210302
 */
public class RegistroResumos {

    /**
     * Array de resumos armazenados.
     */
    private Resumo[] resumos;

    /**
     * Tamanho atual do array de resumos.
     */
    private int tamanhoAtual;

    /**
     * Contador do número de resumos adicionados.
     */
    private int count;

    /**
     * Posição atual para adicionar o próximo resumo.
     */
    private int posicaoAtual;

    /**
     * Construtor de um objeto RegistroResumos com a capacidade de armazenar um número
     * especificado de resumos.
     *
     * @param numeroDeResumos o número máximo de resumos a serem armazenados.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.tamanhoAtual = numeroDeResumos;
        this.resumos = new Resumo[numeroDeResumos];
        this.count = 0;
        this.posicaoAtual = 0;
    }

    /**
     * Adiciona um novo resumo com o tema e texto fornecidos.
     *
     * @param tema o tema do resumo.
     * @param texto o texto do resumo.
     */
    public void adiciona(String tema, String texto) {
        resumos[posicaoAtual] = new Resumo(tema, texto);
        posicaoAtual = (posicaoAtual + 1) % tamanhoAtual;
        if (count < tamanhoAtual) {
            count++;
        }
    }

    /**
     * Retorna um array de strings contendo os resumos cadastrados.
     *
     * @return um array de strings com os resumos.
     */
    public String[] pegaResumos() {
        String[] resumosValidos = new String[count];
        for (int i = 0; i < count; i++) {
            resumosValidos[i] = resumos[i].toString();
        }
        return resumosValidos;
    }

    /**
     * Retorna o número de resumos cadastrados.
     *
     * @return o número de resumos cadastrados.
     */
    public int conta() {
        return this.count;
    }

    /**
     * Retorna uma representação em string dos resumos cadastrados.
     * A representação inclui o número de resumos e seus temas.
     *
     * @return uma string representando os resumos cadastrados.
     */
    public String imprimeResumos() {
        StringBuilder sb = new StringBuilder();
        sb.append("- ").append(count).append(" resumo(s) cadastrado(s)\n- ");
        for (int i = 0; i < count; i++) {
            sb.append(resumos[i].pegaTema());
            if (i < count - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    /**
     * Verifica se existe um resumo com o tema fornecido.
     *
     * @param tema o tema a ser verificado.
     * @return true se existir um resumo com o tema, caso contrário, false.
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < count; i++) {
            if (resumos[i].pegaTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }
}