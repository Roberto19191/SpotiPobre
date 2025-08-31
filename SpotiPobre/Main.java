import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sejam bem vindos ao nosso streaming de música.\r\n"+  
        "SpotiPobre.");
        System.out.println( "O que deseja?\r\n"+
                            "1-Realizar login.\r\n"+
                            "2-Mídias.\r\n"+
                            "3-Playlists.\r\n"+
                            "4-Gênreo musical.\r\n"+
                            "5-Catálogo.\r\n"+
                            "6-Sair.");
        while (true) {
            System.out.print("Digite a opção desejada: ");             
            int opcao = sc.nextInt();
            sc.nextLine();
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
                    return;
                
                default:
                    System.out.println("Tá errado aí viss");
                    break;
            }
        } 
    }
}
