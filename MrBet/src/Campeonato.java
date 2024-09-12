
import java.util.*;

public class Campeonato {

    /*
     * Nome do campeonato.
     */
    private String nome;

    /*
     * Limite de participantes.
     */
    private int participantes;

    /*
     * Times que participam do campeonato.
     */
    private List<Time> times;

    /**
     * Construtor para criar um campeonato com um nome e Limite de participantes.
     *
     * @param o nome do campeonato.
     * @param o Limite de participante.
     */
    public Campeonato(String nome, int participantes) {
        this.nome = nome;
        this.participantes = participantes;
        this.times = new ArrayList<Time>();
    }

    public String getNome() {
        return nome;
    }

    public int getParticipantes() {
        return participantes;
    }

    public int getNumeroParticipantes() {
        return times.size();
    }

    /**
     * Adiciona um time ao campeonato, se ainda houver vagas disponíveis.
     *
     * @param o time.
     * @return true se o time foi adicionado com sucesso, caso contrário, false.
     */
    public boolean adicionarTime(Time time) {
        if (times.size() < participantes) {
            return times.add(time);
        }
        return false;
    }

    /**
     * Verifica se um time está inscrito no campeonato.
     *
     * @param código do time.
     * @return true se o time está inscrito, caso contrário, false.
     */
    public boolean verificarTimeEmCampeonato(String codigo) {
        for (Time t : times) {
            if (t.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return a representação em String do campeonato no formato: "Nome - Numero de participantes/Limite de Participantes".
     */
    @Override
    public String toString() {
        return this.nome + " - " + times.size() + "/" + this.participantes;

    }
}