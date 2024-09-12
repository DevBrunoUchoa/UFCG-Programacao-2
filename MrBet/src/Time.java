
import java.util.*;

/**
 * Representação de um time. Cada time possui um nome, um código de
 * identificação, um mascote, e está associado a uma lista de campeonatos que
 * participam.
 *
 * @autor João Bruno Tavares Uchoa - 123210302
 */
public class Time {

    /**
     * Nome do time.
     */
    private String nome;

    /**
     * Código de identificação do time.
     */
    private String codigo;

    /**
     * Mascote do time.
     */
    private String mascote;

    /**
     * Lista de campeonatos que o time está inscrito.
     */
    private List<Campeonato> campeonatos;

    /**
     * Construtor para criar um novo time:
     *
     * @param codigo:  de identificação do time.
     * @param nome:    nome do time.
     * @param mascote: mascote do time.
     */
    public Time(String codigo, String nome, String mascote) {
        this.codigo = codigo;
        this.nome = nome;
        this.mascote = mascote;
        this.campeonatos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getMascote() {
        return mascote;
    }

    /**
     * Adiciona um objeto do tipo Campeonato à lista de cameponatos do time.
     *
     */
    public void adicionaCampeonatoAoTime(Campeonato campeonato) {
        campeonatos.add(campeonato);
    }

    /**
     * Exibe todos os campeonatos nos quais o time está inscrito
     *
     * @return uma string formatada contendo o nome dos campeonatos e a quantidade
     *         de participantes atual em relação ao limite.
     */
    public String exibeCampeonatos() {
        StringBuilder participacoes = new StringBuilder("Campeonatos do " + this.nome + ":\n");

        for (Campeonato campeonato : campeonatos) {
            participacoes.append("* ").append(campeonato.getNome()).append(" - ")
                    .append(campeonato.getNumeroParticipantes()).append("/").append(campeonato.getParticipantes())
                    .append("\n");
        }
        return participacoes.toString();
    }

    /**
     * @return a representação em String do time no formato: "[Código] Nome /
     *         Mascote".
     */
    @Override
    public String toString() {
        return "[" + this.codigo + "] " + this.nome + " / " + this.mascote;
    }

}