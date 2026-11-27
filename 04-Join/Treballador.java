public class Treballador implements Runnable {

    private final int ciutadà;
    
    public double sou_anual_brut;

    public double edat_inici_treball;

    public double edat_fi_treball;

    public double edat_actual;

    public float cobrat;

    public Treballador(int ciutadà, double sou_anual_brut, double edat_inici_treball, 
        double edat_fi_treball, double edat_actual, float cobrat){
        this.ciutadà = ciutadà;
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.edat_actual = edat_actual;
        this.cobrat = cobrat;
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getCiutadà() {
        return ciutadà;
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

    @Override 
    public void run() {
        for (double edat = edat_inici_treball; edat < edat_fi_treball; edat++) {
            cobrat += (float) (sou_anual_brut * 0.76);
        }

    }
    
}
