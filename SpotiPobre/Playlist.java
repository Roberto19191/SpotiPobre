import java.util.ArrayList;
import java.util.List;

public class Playlist {
    public String nome;
    public List<Midia> midias;

    public Playlist(String nome) {
        this.nome = nome;
        this.midias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarMidia(Midia m) {
        midias.add(m);
        System.out.println("Mídia '" + m.getTitulo() + "' adicionada à playlist '" + nome + "'.");
    }

    public void removerMidia(Midia m) {
        if (midias.contains(m)) {
            midias.remove(m);
            System.out.println("Mídia '" + m.getTitulo() + "' removida da playlist '" + nome + "'.");
        } else {
            System.out.println("Mídia não encontrada na playlist.");
        }
    }

    public void exibirMidias() {
        if (midias.size() == 0) {
            System.out.println("Playlist vazia.");
        } else {
            System.out.println("Mídias da playlist '" + nome + "':");
            for (Midia m : midias) {
                System.out.println("- " + m);
            }
        }
    }
}

public Midia buscarportitulo(string titulo) {
    for (Midia m : midias) {
        if (m.getTitulo().equalsIgnoreCase(titulo)) {
            System.out.println("Mídia encotrada: " + m);
            return m;
        }
    }
 System.out.println("Nenhuma Mídia com o título" + titulo + "encontrada na Playlist. ");
    return null;
}

public void ordenarportitulo() {
    midias.sort(comparator.comparing(Midia::getTitulo, String.CASE_INSENSITIVE_ORDER));
    System.out.println("Playlist " + nome + " ordenada por titulo.");
}

public void ordenarporDuracao() {
    midias.sort(comparator.comparingDouble(Midia::getDuracao));
    System.out.println("Playlist " + nome + " ordenada por duração.");
}
}