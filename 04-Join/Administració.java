

public class Administració {

    public int num_poblacio_activa = 50;

    public int poblacio_activa =50;

    public static void main(String[] args) {
        Administració administració = new Administració();
        administració.Ciutada(25000, 20, 65, 0, 0.0f);
    }

    public void Ciutada (double sou_anual_brut, double edat_inici_treball, 
        double edat_fi_treball, double edat_actual, float cobrat){
            
        Thread[] treballadors = new Thread[num_poblacio_activa];

        Treballador[] ciutadans = new Treballador[poblacio_activa];

        for (int i = 0; i < num_poblacio_activa; i++) {

            ciutadans[i] = new Treballador(
                    i, sou_anual_brut, edat_inici_treball, edat_fi_treball, edat_actual, cobrat);

            treballadors[i] = new Thread(ciutadans[i]);
            
            treballadors[i].start();
        }

        for (Thread treballador : treballadors) {
            try {
                treballador.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        for (Treballador ciutadà : ciutadans) {
            System.out.printf("Ciutada: %d -> edat: %.0f / total: %.2f%n",
                    ciutadà.getCiutadà(), ciutadà.getEdat(), ciutadà.getCobrat());
        }
    }
}
