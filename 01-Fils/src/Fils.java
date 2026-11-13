
public class Fils implements Runnable {

    String nom;


    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Fils(String nom) {
        super();
        this.nom = nom;
    }

    @Override 
    public void run() {
        for (int i = 0; i<1000; i++){
            System.out.println( nom + " " + i );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    System.out.println("Termina el fil " + nom);
}
}

    //prioritat
    //scheduler
