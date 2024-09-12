
/**
 * Representação do descanso para monitorar o nível de cansaço do aluno.
 * A classe Descanso permite definir as horas de descanso e o número de semanas,
 * e calcula o status geral baseado nesses valores.
 *
 * @autor João Bruno Tavares Uchoa - 123210302
 */
public class Descanso {

    /**
     * Horas de descanso acumuladas.
     */
    private int horasDescanso;

    /**
     * Número de semanas para as quais as horas de descanso são contabilizadas.
     */
    private int numeroSemanas;

    /**
     * Construtor de um objeto Descanso com horas de descanso e número de semanas
     * inicializados a zero.
     */
    public Descanso() {
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }

    /**
     * Define as horas de descanso.
     *
     * @param horas o número de horas de descanso.
     */
    void defineHorasDescanso(int horas) {
        this.horasDescanso = horas;
    }

    /**
     * Define o número de semanas.
     *
     * @param semanas o número de semanas.
     */
    void defineNumeroSemanas(int semanas) {
        this.numeroSemanas = semanas;
    }

    /**
     * Retorna o status geral baseado nas horas de descanso e no número de semanas.
     * Se o número de semanas for zero ou a média de horas de descanso por semana for
     * inferior a 26, retorna "cansado". Caso contrário, retorna "descansado".
     *
     * @return o status geral como uma String.
     */
    public String getStatusGeral() {
        if (numeroSemanas == 0 || horasDescanso / numeroSemanas < 26) {
            return "cansado";
        }
        return "descansado";
    }
}