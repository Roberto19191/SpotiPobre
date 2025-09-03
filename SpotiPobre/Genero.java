import java.util.Scanner;

public enum Genero {
    ROCK,
    POP,
    FUNK,
    ELETRONICA,
    CLASSICA,
    JAZZ,
    RAP,
    BLUES,
    OUTRO;

    public static Genero escolherGenero(Scanner sc) {
        System.out.println("Escolha o gênero da mídia:");

        Genero[] generos = Genero.values();
        for (int i = 0; i < generos.length; i++) {
            System.out.println((i + 1) + ". " + generos[i]);
        }

        int opcao = -1;
        while (opcao < 1 || opcao > generos.length) {
            System.out.print("Digite o número do gênero: ");
            try {
                opcao = Integer.parseInt(sc.nextLine());
                if (opcao < 1 || opcao > generos.length) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }

        return generos[opcao - 1];
    }
}