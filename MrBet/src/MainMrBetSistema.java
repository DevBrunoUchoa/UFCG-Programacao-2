
import java.util.Scanner;


public class MainMrBetSistema {
    public static void main(String[] args) {
        MrBetSistema mb = new MrBetSistema();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String escolha = menu(scanner);
            comando(escolha, mb, scanner);
        }
    }

    private static String menu(Scanner scanner) {
        System.out.println(
                "\n(M)Minha inclusão de times\n" +
                        "(R)Recuperar time\n" +
                        "(.)Adicionar campeonato\n" +
                        "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
                        "(E)Exibir campeonatos que o time participa\n" +
                        "(T)Tentar a sorte e status\n" +
                        "(!)Já pode fechar o programa!\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

    private static void comando(String opcao, MrBetSistema mb, Scanner scanner) {
        switch (opcao) {
            case "M":
                scanner.nextLine();
                cadastrarTime(mb, scanner);
                break;
            case "R":
                scanner.nextLine();
                recuperaTime(mb, scanner);
                break;
            case ".":
                scanner.nextLine();
                cadastrarCampeonato(mb, scanner);
                break;
            case "B":
                scanner.nextLine();
                submenuCampeonato(mb, scanner);
                break;
            case "E":
                scanner.nextLine();
                exibirCampeonatosDoTime(mb, scanner);
                break;
            case "T":
                scanner.nextLine();
                submenuApostas(mb, scanner);
                break;
            case "!":
                sai();
                break;
            default:
                throw new IllegalArgumentException("OPÇÃO INVÁLIDA!");

        }
    }

    private static void submenuCampeonato(MrBetSistema mb, Scanner scanner) {
        System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?");
        String opcao = scanner.next().toUpperCase();

        scanner.nextLine();

        if (opcao.equals("I")) {
            incluirTimeEmCampeonato(mb, scanner);
        } else if (opcao.equals("V")) {
            verificarTimeEmCampeonato(mb, scanner);
        } else {
            throw new IllegalArgumentException("OPÇÃO INVÁLIDA!");

        }
    }

    private static void cadastrarTime(MrBetSistema mb, Scanner scanner) {
        System.out.print("\nCódigo: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Mascote: ");
        String mascote = scanner.nextLine();
        System.out.println(mb.cadastrarTime(codigo, nome, mascote) + "\n");
    }


    private static void recuperaTime(MrBetSistema mb, Scanner scanner) {
        System.out.print("\nCódigo: ");
        String codigo = scanner.nextLine();
        System.out.print(mb.recuperarTime(codigo) + "\n");
    }

    private static void cadastrarCampeonato(MrBetSistema mb, Scanner scanner) {
        System.out.print("\nCampeonato: ");
        String nome = scanner.nextLine();
        System.out.print("Participantes: ");
        int participantes = scanner.nextInt();
        scanner.nextLine();
        System.out.print(mb.cadastraCampeonato(nome, participantes));
    }

    private static void incluirTimeEmCampeonato(MrBetSistema mb, Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.next();
        System.out.print("Campeonato: ");
        String campeonato = scanner.next();
        System.out.println(mb.adicionaTimeEmCampeonato(codigo, campeonato));

    }

    private static void verificarTimeEmCampeonato(MrBetSistema mb, Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.next();
        System.out.print("Campeonato: ");
        String campeonato = scanner.next();
        System.out.println(mb.verificarTimeEmCampeonato(codigo, campeonato));

    }

    private static void exibirCampeonatosDoTime(MrBetSistema mb, Scanner scanner) {
        System.out.println("Time: ");
        String nomeTime = scanner.next();
        System.out.println(mb.exibirCampeonatosDoTime(nomeTime));
    }

    private static void submenuApostas(MrBetSistema mb, Scanner scanner) {
        System.out.println("(A) Apostar ou (S) Status das Apostas?");
        String opcao = scanner.next().toUpperCase();
        if (opcao.equals("A")) {
            apostar(mb, scanner);
        } else if (opcao.equals("S")) {
            exibirStatusApostas(mb);
        } else {
            throw new IllegalArgumentException("OPÇÃO INVÁLIDA!");

        }
    }

    private static void apostar(MrBetSistema mb, Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.next();
        System.out.print("Campeonato: ");
        String campeonato = scanner.next();
        System.out.print("Colocação: ");
        int colocacao = scanner.nextInt();
        System.out.print("Valor da Aposta: ");
        double valor = scanner.nextDouble();

        if (!(mb.adicionarAposta(codigo, campeonato, colocacao, valor))) {
            System.out.println("APOSTA NÃO REGISTRADA!");
        } else {
            System.out.println("APOSTA REGISTRADA!");
        }

    }

    private static void exibirStatusApostas(MrBetSistema mb) {
        String apostas = mb.statusApostas();
        System.out.println(apostas);
    }

    private static void sai() {
        System.out.println("Por hoje é só, pessoal!");
        System.exit(0);
    }

}