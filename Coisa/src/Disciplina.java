
import java.util.*;

/**
 * Representação de uma disciplina, permitindo o cadastro de horas de estudo e notas,
 * além de verificar se o aluno foi aprovado com base na média das notas.
 *
 * @autor João Bruno Tavares Uchoa - 123210302
 */
public class Disciplina {

    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Notas obtidas na disciplina em cada prova.
     */
    private double[] notas = {0, 0, 0, 0};

    /**
     * Horas de estudo dedicadas à disciplina.
     */
    private int horasEstudadas = 0;

    /**
     * Média das notas da disciplina.
     */
    private double media = 0.0;

    /**
     * Construtor de uma disciplina com o nome fornecido.
     *
     * @param disciplina o nome da disciplina.
     */
    public Disciplina(String disciplina) {
        this.nomeDisciplina = disciplina;
    }

    /**
     * Cadastra as horas de estudo.
     *
     * @param horas o número de horas de estudo a ser adicionado.
     */
    void cadastraHoras(int horas) {
        this.horasEstudadas += horas;
    }

    /**
     * Cadastra a nota em uma posição referente ao número da prova.
     *
     * @param nota o índice da nota (1 a 4).
     * @param valorNota o valor da nota a ser cadastrado.
     */
    void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    /**
     * Verifica se o aluno está aprovado com base na média das notas.
     *
     * @return true se a média das notas for maior ou igual a 7.0, caso contrário, false.
     */
    boolean aprovado() {
        media = (notas[0] + notas[1] + notas[2] + notas[3]) / 4;
        return media >= 7.0;
    }

    /**
     * Retorna uma representação em String da disciplina.
     * A representação segue o seguinte formato: "NomeDisciplina HorasEstudadas Media [Notas]".
     *
     * @return a representação em String da disciplina.
     */
    public String toString() {
        return nomeDisciplina + " " + horasEstudadas + " " + media + " " + Arrays.toString(this.notas);
    }
}