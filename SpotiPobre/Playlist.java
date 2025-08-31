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
