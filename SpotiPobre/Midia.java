import java.util.*;
import java.text.Normalizer;
import excecoes.DuracaoInvalidaException;
import excecoes.NomeInvalidoException;
import excecoes.TipoMidiaInvalidoException;

public class Midia {
    private final String titulo;
    private String artista;
    private double duracao;
    private String genero;
    private String tipo;
///    private String pesquisa;

    private static List<Midia> catalogoGeral = new ArrayList<>();

    public Midia(String titulo, String artista, double duracao, String genero, String tipo)
            throws NomeInvalidoException, TipoMidiaInvalidoException, DuracaoInvalidaException {

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new NomeInvalidoException("O título da mídia não pode ser vazio");
        }

        String tipoNormalizado = Normalizer
                .normalize(tipo, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .trim()
                .toLowerCase();

        if (!tipoNormalizado.equals("musica") &&
                !tipoNormalizado.equals("podcast") &&
                !tipoNormalizado.equals("audiobook")) {
            throw new TipoMidiaInvalidoException("Tipo de mídia inválido: " + tipo);
        }

        if (duracao <= 0) {
            throw new DuracaoInvalidaException("Duração inválida");
        }

        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
        this.tipo = tipoNormalizado.substring(0, 1).toUpperCase() + tipoNormalizado.substring(1);

        catalogoGeral.add(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public double getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public String getTipo() {
        return tipo;
    }

    public static List<Midia> getCatalogoGeral() {
        return catalogoGeral;
    }

    @Override
    public String toString() {
        int minutos = (int) duracao;
        int segundos = (int) Math.round((duracao - minutos) * 60);
        String duracaoFormatada = String.format("%d:%02d", minutos, segundos);

        return "[" + tipo + "] " + titulo + " - " + artista +
                " (" + genero + ", " + duracaoFormatada + ")";
    }

    public static void exibirCatalogo() {
        System.out.println("\n--- Catálogo Geral de Mídias ---");
        if (catalogoGeral.isEmpty()) {
            System.out.println("Catálogo vazio.");
        } else {
            for (Midia m : catalogoGeral) {
                System.out.println(" - " + m);
            }
        }
    }

    public static void PesquisarMidia(Scanner sc) {
    System.out.print("Digite o termo para pesquisa (música, artista ou gênero): ");
    String termo = sc.nextLine();
    
    termo = Normalizer.normalize(termo, Normalizer.Form.NFD)
            .replaceAll("\\p{M}", "")
            .toLowerCase();

    boolean encontrado = false;
    for (Midia m : catalogoGeral) {
        String tituloNorm = Normalizer.normalize(m.getTitulo(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "").toLowerCase();
        String artistaNorm = Normalizer.normalize(m.getArtista(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "").toLowerCase();
        String generoNorm = Normalizer.normalize(m.getGenero(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "").toLowerCase();

        if (tituloNorm.contains(termo) || artistaNorm.contains(termo) || generoNorm.contains(termo)) {
            System.out.println(m);
            encontrado = true;
        }
    }

    if (!encontrado) {
        System.out.println("Nenhuma mídia encontrada para o termo informado.");
    }
}
}
