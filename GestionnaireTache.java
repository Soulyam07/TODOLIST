import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class GestionnaireTache{
    private Tache taches[] ;
    private int nombreTache;
    Scanner fd = new Scanner(System.in);

    public void setTaches(Tache tache[]) {
        this.taches = tache;
    }
    
    public Tache[] getTache() {
        return this.taches;
    }
    public void setNombreTache(int nombreTache){
        this.nombreTache = nombreTache;
    }
    public int getNombreTache(){
        return this.nombreTache;
    }

    public GestionnaireTache(int nombreMax){
        this.nombreTache = 0;
        this.taches = new Tache[nombreMax];
    }

    public boolean ajouter(Tache tache){
        
        if(this.nombreTache<this.taches.length ){
            this.taches[nombreTache] = tache;
            nombreTache++;
            return true;
        }else{
            return false;
        }
    }

    public  boolean modifier(Tache tache){
        
        for(int i=0;i<nombreTache;i++){
            if(this.taches[i].getIdentifiant() == tache.getIdentifiant()){
                System.out.println("La tache "+tache.getTitre()+" va etre modifier");
                System.out.println("Saisir le nouveau titre");
                String titreN = fd.next();
                System.out.println("Saisir l'etat de la tache");
                String etat= fd.next();
                tache.setTitre(titreN);
                tache.setEtat(etat);
                this.taches[i] = tache;
             return true;   
            }
            
        }
        return false;
    }

    public boolean supprimer(int id){
       
        for(int i=0;i<this.taches.length;i++){
            if(this.taches[i].getIdentifiant() == id){
                for(int j=i;j<this.taches.length-1;j++){
                    this.taches[i]=this.taches[i+1];
                    i++; 
                                       
                }
                

               
                
            }          
        }
        this.taches = Arrays.copyOf(this.taches, this.taches.length-1);
    

        
        
        return false;
    }

    

    public Tache[] lister(){
                
        return this.taches;
    }

    public Tache[] lister(String etat){
        
        // for(int i=0;i<this.taches.length;i++){
        //     if(this.taches[i].getEtat().equals(etat)){
        //         this.taches[i] = new Tache(etat);
        //     }else{
        //         return this.taches;
        //     }
        // }
        return this.taches;
        
    }

}