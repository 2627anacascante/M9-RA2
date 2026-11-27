

public class Administració {

    public double num_poblacio_activa = 50;

    public double poblacio_activa = 50;

    public double sou_anual_brut;

    public double edat_inici_treball;

    public double edat_fi_treball;

    public double edat_actual;

    public float cobrat;

    public static void main(String[] args) {
        Administració administració = new Administració();
        administració.Ciutada(25000, 20, 65, 0, 0.0f);
    }
        
    

    public void Ciutada (double sou_anual_brut, double edat_inici_treball, double edat_fi_treball, double edat_actual, float cobrat){
        this.sou_anual_brut = 25000;
        this.edat_inici_treball = 20;
        this.edat_fi_treball = 65;
        this.edat_actual = 0;
        this.cobrat = 0.0f;

        Thread treballador = new Thread(new Treballador(25000, 20, 65, 0, 0.0f));
        treballador.start();

        try {
            treballador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return;
        }
    }

}
