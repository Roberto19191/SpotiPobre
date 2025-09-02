import java.util.ArrayList;
import java.util.List;
import excecoes.NomeInvalidoException;

public class Playlist {
    public final String nome;
    public final List<Midia> midias;

    public Playlist(String nome) throws NomeInvalidoException {
        if (nome == null || nome.isEmpty()) {
            throw new NomeInvalidoException("O nome da playlist não pode ser vazio");
        }
        this.nome = nome;
        this.midias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarMidia(Midia m) {
        if (m != null) {
            midias.add(m);
            System.out.println("Mídia '" + m.getTitulo() + "' adicionada à playlist '" + nome + "'.");
        }
    }

    public void removerMidia(Midia m) {
        if (midias.contains(m)) {
            midias.remove(m);
            System.out.println("Mídia '" + m.getTitulo() + "' removida da playlist '" + nome + "'.");
        } else {
            System.out.println("Mídia não encontrada na playlist '" + nome + "'.");
        }
    }

    public void exibirMidias() {
        if (midias.isEmpty()) {
            System.out.println("Playlist '" + nome + "' vazia.");
        } else {
            System.out.println("Mídias da playlist '" + nome + "':");
            for (int i = 0; i < midias.size(); i++) {
                System.out.println((i + 1) + ". " + midias.get(i));
            }
        }
    }

    public int totalMidias() {
        return midias.size();
    }
}
