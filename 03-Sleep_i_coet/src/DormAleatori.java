import java.sql.Time;
import java.time.LocalDateTime;

public class DormAleatori implements Runnable {

    String nom;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    } 

    public DormAleatori(String nom) {
        super();
        this.nom = nom;
    }

    long num_iteracio = System.currentTimeMillis()/1000;

    long interval_aleatori = Time.sleep(System.currentTimeMillis());
    
    @Override 
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println( nom + "(" + i + ")" + " a dormir " + num_iteracio + " ms total " + System.currentTimeMillis() );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    
}
