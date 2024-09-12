
import java.util.*;

/**
 * Classe que representa o sistema MrBet. Gerencia times, campeonatos e apostas,
 *
 * @autor João Bruno Tavares Uchoa - 123210302
 */
public class MrBetSistema {

    /**
     * Lista de times cadastrados.
     */
    private List<Time> times;

    /**
     * Lista de campeonatos cadastrados.
     */
    private List<Campeonato> campeonatos;

    /**
     * Lista de apostas registradas.
     */
    private List<String> apostas;

    /**
     * Construtor para inicializar o sistema MrBet com listas vazias de times,
     * campeonatos e apostas.
     */
    public MrBetSistema() {
        this.times = new ArrayList<>();
        this.campeonatos = new ArrayList<>();
        this.apostas = new ArrayList<>();

    }

    /**
     * Recupera as informações de um time a partir do seu código.
     *
     * @param codigo do time.
     * @return uma string com a representação do time, ou uma mensagem indicando que
     *         o time não existe.
     */
    public String recuperarTime(String codigo) {
        Time time = buscarTime(codigo);
        if (time == null) {
            throw new IllegalArgumentException("TIME NÃO EXISTE!");

        }

        return time.toString();
    }

    /**
     * Cadastra um novo time no sistema.
     *
     * @param codigo do time.
     * @param nome do time.
     * @param mascote do time.
     * @return uma mensagem indicando o sucesso ou falha da operação.
     */
    public String cadastrarTime(String codigo, String nome, String mascote) {
        if (buscarTime(codigo) != null) {
            throw new IllegalArgumentException("TIME JÁ EXISTE!");
        }

        times.add(new Time(codigo, nome, mascote));
        return "INCLUSÃO REALIZADA!";
    }

    /**
     * Cadastra um novo campeonato no sistema.
     *
     * @param nome nome do campeonato.
     * @param participantes número máximo de participantes do campeonato.
     * @return uma mensagem indicando que o campeonato foi adicionado com sucesso ou se já existe.
     */
    public String cadastraCampeonato(String nome, int participantes) {
        if (buscarCampeonato(nome) != null) {
            throw new IllegalArgumentException("CAMPEONATO JÁ EXISTE!");
        }

        campeonatos.add(new Campeonato(nome, participantes));
        return "CAMPEONATO ADICIONADO!";

    }

    /**
     * Adiciona um time a um campeonato.
     *
     * @param codigoTime:     o código do time a ser adicionado.
     * @param nomeCampeonato: o nome do campeonato.
     * @return uma mensagem indicando o sucesso ou falha da operação.
     */
    public String adicionaTimeEmCampeonato(String codigoTime, String nomeCampeonato) {
        Time time = buscarTime(codigoTime);
        Campeonato campeonato = buscarCampeonato(nomeCampeonato);

        if (campeonato == null) {
            throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");
        }
        if (time == null) {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }
        if (!(campeonato.adicionarTime(time))) {
            return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
        }

        time.adicionaCampeonatoAoTime(campeonato);
        return "TIME INCLUÍDO NO CAMPEONATO!";
    }

    /**
     * Verifica se um time está inscrito em um determinado campeonato.
     *
     * @param codigo do time.
     * @param nomeCampeonato: o nome do campeonato.
     * @return uma mensagem adequada à situação do time e o campeonato.
     */
    public String verificarTimeEmCampeonato(String codigo, String nomeCampeonato) {
        Time time = buscarTime(codigo);
        Campeonato campeonato = buscarCampeonato(nomeCampeonato);

        if (campeonato == null) {
            throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");
        }
        if (time == null) {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }

        if (campeonato.verificarTimeEmCampeonato(codigo)) {
            return "O TIME ESTÁ NO CAMPEONATO!";
        }

        else {
            return "O TIME NÃO ESTÁ NO CAMPEONATO!";
        }
    }

    /**
     * Exibe os campeonatos nos quais um determinado time está inscrito.
     *
     * @param nomeTime: nome do time.
     * @return uma mensagem indicando os campeonatos do time ou informando que o
     *         time não existe.
     */
    public String exibirCampeonatosDoTime(String nomeTime) {
        Time time = buscarTime(nomeTime);
        if (time == null) {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }

        return time.exibeCampeonatos();

    }

    /**
     * Busca um time pelo seu código.
     *
     * @param codigo do time.
     * @return o time correspondente ao código ou null se o time não for encontrado.
     */
    private Time buscarTime(String codigo) {
        for (Time time : times) {
            if (time.getCodigo().toUpperCase().equals(codigo.toUpperCase())) {
                return time;
            }
        }
        return null;
    }

    /**
     * Busca um campeonato pelo seu nome.
     *
     * @param nome do campeonato.
     * @return o campeonato correspondente ao nome ou null se não for
     *         encontrado.
     */
    private Campeonato buscarCampeonato(String nome) {
        for (Campeonato campeonato : campeonatos) {
            if (campeonato.getNome().toUpperCase().equals(nome.toUpperCase())) {
                return campeonato;
            }
        }
        return null;
    }

    /**
     * Adiciona uma nova aposta no sistema.
     *
     * @param nomeTime:       o nome do time apostado.
     * @param nomeCampeonato: o nome do campeonato.
     * @param colocacao:      a colocação esperada para o time.
     * @param valor da aposta.
     * @return true se a aposta foi registrada com sucesso, caso contrário, false.
     */
    public boolean adicionarAposta(String nomeTime, String nomeCampeonato, int colocacao, double valor) {
        Time time = buscarTime(nomeTime);
        Campeonato campeonato = buscarCampeonato(nomeCampeonato);

        if (campeonato == null || time == null || colocacao > campeonato.getParticipantes()) {
            return false;
        }

        String novaAposta = ". [" + time.getCodigo() + "] " + time.getNome() + " / " + time.getMascote() + "\n"
                + campeonato.getNome() + "\n" + colocacao + "/" + campeonato.getParticipantes() + "\nR$ "
                + String.format("%.2f", valor);
        apostas.add(novaAposta);
        return true;

    }

    /**
     * @return uma string com o status das apostas feitas no sistema.
     */
    public String statusApostas() {
        StringBuilder statusApostas = new StringBuilder("Apostas:\n");
        if (apostas.size() >= 1) {
            for (String aposta : apostas) {
                statusApostas.append(apostas.indexOf(aposta) + 1).append(aposta).append("\n");
            }
        } else {
            statusApostas.append("Nenhuma aposta registrada.");
        }

        return statusApostas.toString();
    }
}