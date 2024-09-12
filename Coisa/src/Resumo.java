
/**
 * Representação de um resumo, contendo um tema e um texto.
 * A classe Resumo permite a criação de um resumo com um tema específico e seu
 * respectivo texto, além de métodos para recuperar essas informações.
 *
 * @autor João Bruno Tavares Uchoa - 123210302
 */
public class Resumo {

    /**
     * Tema do resumo.
     */
    private String tema;

    /**
     * Texto do resumo.
     */
    private String texto;

    /**
     * Construtor de um objeto Resumo com o tema e texto fornecidos.
     *
     * @param tema o tema do resumo.
     * @param texto o texto do resumo.
     */
    public Resumo(String tema, String texto) {
        this.tema = tema;
        this.texto = texto;
    }

    /**
     * Retorna o tema do resumo.
     *
     * @return o tema do resumo.
     */
    public String pegaTema() {
        return tema;
    }

    /**
     * Retorna o texto do resumo.
     *
     * @return o texto do resumo.
     */
    public String pegaTexto() {
        return texto;
    }

    /**
     * Retorna uma representação em String do resumo.
     * A representação segue o formato "Tema: Texto".
     *
     * @return a representação em String do resumo.
     */
    @Override
    public String toString() {
        return tema + ": " + texto;
    }
}