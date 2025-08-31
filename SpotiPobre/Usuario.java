import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    public String nome;
    public String email;
    public List<Playlist> playlists;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
    }

    public static Usuario cadastrarUsuario(Scanner sc) {
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu e-mail: ");
        String email = sc.nextLine();
        Usuario usuario = new Usuario(nome, email);
        System.out.println("Usuário " + nome + " cadastrado!");
        return usuario;
    }

    public void criarPlaylistMenu(Scanner sc) {
        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = sc.nextLine();
        criarPlaylist(nomePlaylist);
    }

    public void adicionarMidiaMenu(Scanner sc) {
        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = sc.nextLine();

        System.out.print("Digite o título da mídia: ");
        String titulo = sc.nextLine();
        System.out.print("Digite o artista: ");
        String artista = sc.nextLine();
        System.out.print("Digite a duração (minutos): ");
        double duracao = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite o gênero: ");
        String genero = sc.nextLine();
        System.out.print("Digite o tipo (Música, Podcast, Audiobook): ");
        String tipo = sc.nextLine();

        Midia m = new Midia(titulo, artista, duracao, genero, tipo);
        adicionarMidiaEmPlaylist(nomePlaylist, m);
    }

    public void exibirPlaylistsMenu() {
        exibirPlaylists();
        for (Playlist p : playlists) {
            p.exibirMidias();
        }
    }

    public void criarPlaylist(String nomePlaylist) {
        Playlist playlist = new Playlist(nomePlaylist);
        playlists.add(playlist);
        System.out.println("Playlist '" + nomePlaylist + "' criada!");
    }

    public void removerPlaylist(String nomePlaylist) {
        Playlist encontrada = null;
        for (Playlist p : playlists) {
            if (p.nome.equalsIgnoreCase(nomePlaylist)) {
                encontrada = p;
                break;
            }
        }
        if (encontrada != null) {
            playlists.remove(encontrada);
            System.out.println("Playlist '" + nomePlaylist + "' removida!");
        } else {
            System.out.println("Playlist não encontrada.");
        }
    }

    public void exibirPlaylists() {
        if (playlists.size() == 0) {
            System.out.println("Nenhuma playlist criada.");
        } else {
            System.out.println("Playlists de " + nome + ":");
            for (Playlist p : playlists) {
                System.out.println("- " + p.nome);
            }
        }
    }

    public void adicionarMidiaEmPlaylist(String nomePlaylist, Midia m) {
        Playlist encontrada = null;
        for (Playlist p : playlists) {
            if (p.nome.equalsIgnoreCase(nomePlaylist)) {
                encontrada = p;
                break;
            }
        }
        if (encontrada != null) {
            encontrada.adicionarMidia(m);
        } else {
            System.out.println("Playlist não encontrada.");
        }
    }

    public void removerMidiaDePlaylist(String nomePlaylist, Midia m) {
        Playlist encontrada = null;
        for (Playlist p : playlists) {
            if (p.nome.equalsIgnoreCase(nomePlaylist)) {
                encontrada = p;
                break;
            }
        }
        if (encontrada != null) {
            encontrada.removerMidia(m);
        } else {
            System.out.println("Playlist não encontrada.");
        }
    }
}
