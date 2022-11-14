import java.util.Date;
public class Tache{
    private int identifiant;
    private String etat;
    private String titre;
    private Date date_de_creation;
    private static int dernierId = 1;
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        // this.etat = etat;
        if(etat.equals("EN_COURS") || etat.equals("TERMINE") || etat.equals("PREVU"))
            this.etat = etat;
        else
            this.etat =" ";
        
    }    

    public Tache(String titre){                   
            this.titre = titre;
            this.identifiant = Tache.dernierId;
            this.etat = "PREVU";
            this.date_de_creation = new Date();
            Tache.dernierId++;                
    }

    public Tache(String titre,String etat){
        
        this.titre = titre;
        this.identifiant = Tache.dernierId;
        this.etat = etat;
        this.date_de_creation = new Date();
        Tache.dernierId++;
    }

    public Tache(String titre,String etat,Date dateCreation){
        
        this.titre = titre;
        this.identifiant = Tache.dernierId;
        this.etat = etat;
        this.date_de_creation = dateCreation;
        Tache.dernierId++;
    }

    public String toString(){
        return "Tache "+this.identifiant+"\nTitre :"+this.titre+"\nEtat :"+this.etat+"\nDate de creation :"+this.date_de_creation;
          }

   



}