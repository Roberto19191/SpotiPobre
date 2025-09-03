import java.text.Normalizer;
import java.util.Scanner;
import excecoes.DuracaoInvalidaException;
import excecoes.NomeInvalidoException;
import excecoes.TipoMidiaInvalidoException;

public class Pesquisa extends Midia{
    public Pesquisa(String titulo, String artista, double duracao, String genero, String tipo)
            throws NomeInvalidoException, TipoMidiaInvalidoException, DuracaoInvalidaException {
        super(titulo, artista, duracao, genero, tipo);
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
