
import java.util.concurrent.ThreadLocalRandom;

public class Motor implements Runnable {

    private final int numero;
    private int potencia_actual = 0;
    private volatile int potencia_objectiu = 0;

    public Motor(int numero) {
        this.numero = numero;
    }

    public void setPotencia(int p) {
        potencia_objectiu = p;
    }

    @Override 
    public void run() {
        while (potencia_actual != potencia_objectiu) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 2001));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            int objectiu = potencia_objectiu;
            if (potencia_actual == objectiu) {
                continue;
            }

            boolean incrementa = potencia_actual < objectiu;
            if (incrementa) {
                potencia_actual++;
            } else {
                potencia_actual--;
            }

            String accio = potencia_actual == objectiu
                ? "FerRes"
                : incrementa ? "Incre." : "Decre.";
            System.out.println("Motor " + numero + ": " + accio
                + " Objectiu: " + objectiu + " Actual: " + potencia_actual);
        }
    }
}
