import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sejam bem vindos ao nosso streaming de música.\r\n"+  
        "SpotiPobre.");
        System.out.println( "Informe a opção desejada:/s/r"+
                            "1-Realizar login./s/r"+
                            "2-Mídias./s/r"+
                            "3-Playlists./s/r"+
                            "4-Gênreo musical./s/r"+
                            "5-Catálogo./s/r"+
                            "6-Sair.");
        int opcao = sc.nextInt();
        while (opcao>0 && opcao<=6) {
            switch (opcao) {
                case 1:
                    System.out.println("caso1");
                    break;
                    
                case 2:    
                    System.out.println("caso2");
                    break;
                    
                    
                case 3:
                    System.out.println("caso3");
                    break;
                
                case 4:
                    System.out.println("caso4");
                    break;
                
                case 5:
                    System.out.println("caso5");
                    break;
                
                case 6:
                    System.out.println("caso6");
                    break;
                
                default:
                    System.out.println("Tá errado aí viss");
                    break;
            }
        } 
        sc.nextLine();
    }
}
