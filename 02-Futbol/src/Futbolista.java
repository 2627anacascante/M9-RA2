import java.util.Random;

public class Futbolista implements Runnable {

    int ngols = 0;

    int ntirades = 0;

    final String nom;

    public final int NUM_JUGADORS = 11;

    public final int NUM_TIRADES = 20;

    public final float PROBABILITAT = 0.5f;

    private static int golsTotals = 0;

    public Futbolista(String nom){
        this.nom = nom;
    }

    private static void sumarGols(int gols) {
        golsTotals += gols;
    }

    public static int getGolsTotals() {
        return golsTotals;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (ntirades = 0; ntirades < NUM_TIRADES; ntirades++) {
            if (random.nextFloat() < PROBABILITAT) {
                ngols++;
            }
        }

        sumarGols(ngols);
    }

}

