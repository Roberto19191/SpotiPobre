import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Genero {
    ROCK, JAZZ, POP, MPB, RAP, ELETRONICA, PODCAST, OUTRO;

    @Override
    public String Genero fromString(string s) {
        if (s == null) return OUTRO;

        String n = Normalizer.normalize(s, Normalizer.from.NFD)
                .replaceAll("\\p{M}',""")
                .replaceAll("[^A-Za-z0-9]", "")
                .toUpperCase().trim();
        switch (n) {
            case "ROCK": return ROCK;
            case "JAZZ": return JAZZ;
            case "POP": return POP;
            case "MPB": return MPB;
            case "RAP": return RAP;
            case "ELETRONICA": return ELETRONICA;
            case "PODCAST": return PODCAST
            default: return OUTRO;
        }
    }

    public String toString() {
        switch (this) {
            case ELETRONICA:return "eletronica";
            case PODCAST:return "podcast";
            case AUDIOBOOK: return  "audiobook";
            case OUTRO: return "outro";
            default:
                    String low = this.name().toLowercase();
                    return Character.toUpperCase(low.charAt(0)) + low.substring(1);
        }
    }
}
