public class MainDemoFil {

    public static void main(String[] args) {
        String[] noms = {
            "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo",
            "Lewan", "Belli", "Arnau", "Aspas", "Messi", "Mbapé"
        };

        System.out.println("Inici dels xuts-------------");

        Futbolista[] jugadors = new Futbolista[noms.length];
        Thread[] fils = new Thread[noms.length];

        for (int i = 0; i < noms.length; i++) {
            jugadors[i] = new Futbolista(noms[i]);
            fils[i] = new Thread(jugadors[i]);
            fils[i].start();
        }

        for (Thread fil : fils) {
            try {
                fil.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Fi dels xuts---------------");
        System.out.println("----Estadístiques------");

        for (Futbolista jugador : jugadors) {
            System.out.println(jugador.nom + " -> "
                    + jugador.ngols + " gols" );
        }

        System.out.println("Gols totals: " + Futbolista.getGolsTotals());
    }
}
