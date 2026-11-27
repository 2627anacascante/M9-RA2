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

    public double getEdat_actual() {
        return edat_actual;
    }

    public float cobra(double sou_anual_brut){
        return (float) (sou_anual_brut + sou_anual_brut / 12.0);
    }

    public float paga(double sou_anual_brut){
        return (float) (sou_anual_brut * 0.24);
    }

    public float cobratNet(double sou_anual_brut) {
        float souBrutAmbPagaExtra = cobra(sou_anual_brut);
        return souBrutAmbPagaExtra - paga(souBrutAmbPagaExtra);
    }

    @Override 
    public void run() {
        for (double edat = edat_inici_treball; edat < edat_fi_treball; edat++) {
            cobrat += cobratNet(sou_anual_brut);
        }

    }
    
}
