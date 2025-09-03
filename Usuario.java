import excecoes.DuracaoInvalidaException;
import excecoes.NomeInvalidoException;
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
        String nome;
        do {
            System.out.print("Digite seu nome: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Nome inválido! Tente novamente.");
            }
        } while (nome.isEmpty());

        String email;
        do {
            System.out.print("Digite seu e-mail: ");
            email = sc.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("E-mail inválido! Tente novamente.");
            }
        } while (email.isEmpty());

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
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Artista: ");
        String artista = sc.nextLine();

        System.out.print("Duração (em minutos, ex: 3.5): ");
        double duracao = Double.parseDouble(sc.nextLine());

        Genero genero = Genero.escolherGenero(sc);

        System.out.print("Tipo (Musica, Podcast ou Audiobook): ");
        String tipo = sc.nextLine();

        try {
            
            //new Midia(titulo, artista, duracao, genero.name(), tipo);
            Midia m = new Midia(titulo, artista, duracao, genero.name(), tipo);
            System.out.print("Deseja adicionar esta mídia a alguma playlist? (s/n) ");
            String resposta = sc.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                System.out.print("Digite o nome da playlist: ");
                String nomePlaylistAdd = sc.nextLine();
                try {
                    adicionarMidiaEmPlaylist(nomePlaylistAdd, m);
                } catch (NomeInvalidoException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            System.out.println("Mídia adicionada ao catálogo com sucesso!");        } catch (Exception e) {
            System.out.println("Erro ao adicionar mídia: " + e.getMessage());
        }


        

    }


    public void exibirPlaylistsMenu() {
        exibirPlaylists();
        for (Playlist p : playlists) {
            p.exibirMidias();
        }
    }

    public void criarPlaylist(String nomePlaylist) {
        try {
            Playlist playlist = new Playlist(nomePlaylist);
            playlists.add(playlist);
            System.out.println("Playlist '" + nomePlaylist + "' criada!");
        } catch (NomeInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void removerPlaylist(String nomePlaylist) throws NomeInvalidoException {
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
            throw new NomeInvalidoException("Playlist não encontrada.");
        }
    }

    public void exibirPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("Nenhuma playlist criada.");
        } else {
            System.out.println("Playlists de " + nome + ":");
            for (Playlist p : playlists) {
                System.out.println("- " + p.nome);
                if (p.midias.isEmpty()) {
                    System.out.println("  (Sem mídias)");
                } else {
                    for (Midia m : p.midias) {
                        System.out.println("  - " + m);
                    }
                }
            }
        }
    }


    public void adicionarMidiaEmPlaylist(String nomePlaylist, Midia m) throws NomeInvalidoException {
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
            throw new NomeInvalidoException("Playlist não encontrada: " + nomePlaylist);
        }
    }

    public void removerMidiaDePlaylist(String nomePlaylist, Midia m) throws NomeInvalidoException {
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
            throw new NomeInvalidoException("Playlist não encontrada: " + nomePlaylist);
        }
    }



    public static double converterDuracao(String duracaoStr) throws DuracaoInvalidaException {
        try {
            String[] partes = duracaoStr.split(":");
            if (partes.length != 2) {
                throw new DuracaoInvalidaException("Formato inválido. Use mm:ss");
            }
            int minutos = Integer.parseInt(partes[0].trim());
            int segundos = Integer.parseInt(partes[1].trim());
            if (minutos < 0 || segundos < 0 || segundos >= 60) {
                throw new DuracaoInvalidaException("Duração inválida");
            }
            return minutos + segundos / 60.0;
        } catch (NumberFormatException e) {
            throw new DuracaoInvalidaException("Duração deve conter apenas números");
        }
    }
}
