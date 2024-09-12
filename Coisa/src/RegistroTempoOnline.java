
/**
 * Representação do registro do tempo online de estudo de uma disciplina.
 * A classe RegistroTempoOnline permite registrar o tempo estudado e verificar se a meta de tempo foi atingida.
 *
 * @autor João Bruno Tavares Uchoa - 123210302
 */
public class RegistroTempoOnline {

    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Tempo estudado acumulado em horas.
     */
    private int tempoEstudado;

    /**
     * Tempo esperado de estudo em horas.
     */
    private int tempoEsperado;

    /**
     * Construtor de um registro de tempo online para uma disciplina com o tempo esperado
     * de estudo inicializado para 120 horas.
     *
     * @param disciplina o nome da disciplina.
     */
    public RegistroTempoOnline(String disciplina) {
        this.nomeDisciplina = disciplina;
        this.tempoEstudado = 0;
        this.tempoEsperado = 120;
    }

    /**
     * Constrói um registro de tempo online para uma disciplina com o tempo esperado
     * de estudo definido pelo usuário.
     *
     * @param disciplina o nome da disciplina.
     * @param horas o tempo esperado de estudo em horas.
     */
    public RegistroTempoOnline(String disciplina, int horas) {
        this.nomeDisciplina = disciplina;
        this.tempoEstudado = 0;
        this.tempoEsperado = horas;
    }

    /**
     * Adiciona tempo ao tempo estudado acumulado.
     *
     * @param tempo o tempo a ser adicionado em horas.
     */
    void adicionaTempoOnline(int tempo) {
        this.tempoEstudado += tempo;
    }

    /**
     * Verifica se o tempo estudado atingiu ou ultrapassou o tempo esperado de estudo.
     *
     * @return true se o tempo estudado for maior ou igual ao tempo esperado, false caso contrário.
     */
    boolean atingiuMetaTempoOnline() {
        return this.tempoEstudado >= this.tempoEsperado;
    }

    /**
     * Retorna a String que representa o registro de tempo online.
     * A representação segue o seguinte formato: “NomeDisciplina TempoEstudado/TempoEsperado”.
     *
     * @return a representação em String do registro de tempo online.
     */
    public String toString() {
        return nomeDisciplina + " " + tempoEstudado + "/" + tempoEsperado;
    }
}