import java.util.Scanner;
import excecoes.NomeInvalidoException;
import excecoes.TipoMidiaInvalidoException;
import excecoes.DuracaoInvalidaException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = Usuario.cadastrarUsuario(sc);

        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Criar playlist");
            System.out.println("2. Adicionar mídia");
            System.out.println("3. Listar playlists e mídias");
            System.out.println("4. Exibir catálogo geral");
            System.out.println("5. Remover playlist");
            System.out.println("6. Remover mídia de playlist");
            System.out.println("7. Listar apenas playlists");
            System.out.println("8. Pesquisar Músicas, Artístas ou Gênero");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    usuario.criarPlaylistMenu(sc);
                    break;

                case 2:
                    usuario.adicionarMidiaMenu(sc);
                    break;

                case 3:
                    usuario.exibirPlaylistsMenu();
                    break;

                case 4:
                    Midia.exibirCatalogo();
                    break;

                case 5:
                    System.out.print("Digite o nome da playlist a remover: ");
                    String nomePlaylistRemover = sc.nextLine();
                    try {
                        usuario.removerPlaylist(nomePlaylistRemover);
                    } catch (NomeInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                System.out.print("Digite o nome da playlist: ");
                String nomePlaylist = sc.nextLine();
                System.out.print("Digite o título da mídia a remover: ");
                String titulo = sc.nextLine();

                Midia midiaParaRemover = null;
                for (Midia m : Midia.getCatalogoGeral()) {
                    if (m.getTitulo().equalsIgnoreCase(titulo)) {
                        midiaParaRemover = m;
                        break;
                    }
                }

                if (midiaParaRemover != null) {
                    try {
                        usuario.removerMidiaDePlaylist(nomePlaylist, midiaParaRemover);
                    } catch (NomeInvalidoException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                } else {
                    System.out.println("Mídia não encontrada no catálogo.");
                }
                break;

                case 7:
                    usuario.exibirPlaylists();
                    break;

                case 8:
                    Pesquisa.PesquisarMidia(sc);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}

