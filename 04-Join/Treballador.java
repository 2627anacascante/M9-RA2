import java.util.Random;

public class Treballador implements Runnable {

    public double sou_anual_brut;

    public double edat_inici_treball;

    public double edat_fi_treball;

    public double edat_actual;

    public float cobrat;

    Random rnd = new Random();

    public Treballador(double sou_anual_brut, double edat_inici_treball, double edat_fi_treball, double edat_actual, float cobrat){
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.edat_actual = edat_actual;
        this.cobrat = cobrat;
    }

    public float getCobrat() {
        return cobrat;
    }

    public float totalCobrat(){
       float total = 0.0f;
       total += getCobrat();
       return total; 
    }

    public double getEdat_actual() {
        return edat_actual;
    }

    public float cobra(double sou_anual_brut){
        
    float estalvis = (float) (totalCobrat() + (totalCobrat()/ 12.0));

    return estalvis;
    }

    public float paga(double sou_anual_brut){

    float impostos = (float) (totalCobrat() - (totalCobrat()* 0.24));
    
    return impostos;
    }

    public float cobratNet(double sou_anual_brut){

    float sou_net = (float) (cobra(sou_anual_brut)-paga(sou_anual_brut));

    return sou_net;
    }

    @Override 
    public void run() {
    
    for (double i = edat_inici_treball; i<edat_fi_treball; i++ ){        
    cobrat += (float) (sou_anual_brut * 0.76);
    System.out.printf("Ciutada: %.0f -> edat: %.0f / total: %.2f%n",
            i, edat_fi_treball, cobrat);
    long esperaMs = 1000 + rnd.nextInt(2000);
            try {
                Thread.sleep(esperaMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
    
}
