import java.util.ArrayList;
import java.util.List;

public class Midia {
    private final String titulo;
    private String artista;
    private double duracao;
    private String genero;
    private String tipo;

    private static List<Midia> catalogoGeral = new ArrayList<>();

    public Midia(String titulo, String artista, double duracao, String genero, String tipo) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
        this.tipo = tipo;
        catalogoGeral.add(this);
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "[" + tipo + "] " + titulo + " - " + artista +
                " (" + genero + ", " + duracao + "min)";
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
}
