import java.sql.Time;
import java.time.LocalDateTime;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    long num_iteracio = System.currentTimeMillis();

    long interval_aleatori = ThreadLocalRandom.current().nextLong(1000, 5001);
    
    @Override 
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println( nom + "(" + i + ")" + " a dormir " + interval_aleatori + " ms total " + num_iteracio );
        try {
            Thread.sleep(interval_aleatori);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    
}
