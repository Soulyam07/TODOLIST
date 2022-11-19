import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;


public class GestionTache {

    static void menu() {
    
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("------------------------------Menu TODOLIST------------------------------");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\t1:Ajouter une tache");
        System.out.println("\t2:Supprimer une tache");
        System.out.println("\t3:Modifier une tache");
        System.out.println("\t4:Lister toutes les taches");
        System.out.println("\t5:Lister les taches selon l'etat:");
        System.out.println("\t\t51:En cours");
        System.out.println("\t\t51:Prevues");
        System.out.println("\t\t51:Terminées");
        System.out.println("\t0:Pour quitter");
        System.out.println("-------------------------------------------------------------------------");
        
    }
  
    public  static void order() {

        String again ;
        Scanner fd = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("----------------------Bienvenu dans votre TODOLIST-----------------------");
        System.out.println("-------------------------------------------------------------------------");  
         
        System.out.print("\n\tCombien de tache voulez-vous avoir dans votre gestionnaire :");
        int nombreTache = fd.nextInt();
        
        
        
        
        
       
        
        GestionnaireTache gest = new GestionnaireTache(nombreTache);
        Tache tache ;
        
        System.out.println("Vous aviez un stockage de "+nombreTache+"dans votre gestionnaire");
        menu();
        
        
        
      
       while(true){
        System.out.print("\tQue voulez - vous faire :");
        int choix = fd.nextInt();
        System.out.println("----------------------------------------------------");
        switch (choix){
            case 1:                                                  
                    System.out.println("Saisir le titre de la tache");
                    String titre = fd.next();
                    tache = new Tache(titre);
                    
                    if(gest.ajouter(tache)==true){
                        System.out.println("Votre tache "+titre+" taches sont ajoutes avec succes");
                    }else{
                        System.out.println("Malheureusement votre gestionnaire est pleine");
                    }
                                             
            break;
            case 2:
                System.out.println("Saisir l'identifiant de la tache à supprimer");
                int id = fd.nextInt();
                if(gest.supprimer(id)== true)
                    System.out.println("La Tache "+id+"a ete supprimer avec succes");
                else
                    System.out.println("Cette tache n'existe pas dans votre gestionnaire");
            break;
            case 3:
                System.out.println("Quelle tache voulez-vous modifier ?");
                String titreM= fd.next();
                
                System.out.println("La tache "+titreM+" va etre modifier");
                // System.out.println("Saisir le nouveau titre");
                // String titreN= fd.next();
                // System.out.println("Saisir le nouveau etat");
                // String Etat= fd.next();


                tache = new Tache(titreM);
                gest.modifier(tache);
                    

            break;
            case 4:
                System.out.println(Arrays.toString(gest.lister()));
            break;
            default:
            System.out.println("Choix invalide");
            break;
        }
        System.out.println("");
        System.out.println("Voulez-vous quitter votre TODOLIST (Y/N)");
        again = fd.next();
        ClearConsole();
        if(again.equalsIgnoreCase("N")){
            menu();
            
            
        }
            
        else if (again.equalsIgnoreCase("Y")){
            System.out.println("Good buys ....!!!!");
            break;
        }
        else 
            System.out.println("Invalide choice");

       }
       



        
        
    }
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
     public static void main(String[] args) {
        
        order();
        
    }
    
}
