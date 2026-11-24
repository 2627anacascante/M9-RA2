
public class Coet {

            private final Motor motor1 = new Motor(0);
            private final Motor motor2 = new Motor(1);
            private final Motor motor3 = new Motor(2);
            private final Motor motor4 = new Motor(3);

         public void passaAPotencia (int p){
                if (p < 0 || p > 10) {

                throw new IllegalArgumentException("La potencia ha d'estar entre 0 i 10");
                }
                    System.out.println("Passant a potència " + p);
                    motor1.setPotencia(p);
                    motor2.setPotencia(p);
                    motor3.setPotencia(p);
                    motor4.setPotencia(p);
                }

        public static void main(String[] args) {
            Coet coet = new Coet();
            coet.passaAPotencia(7);

            Thread m1 = new Thread(coet.motor1);
            Thread m2 = new Thread(coet.motor2);
            Thread m3 = new Thread(coet.motor3);
            Thread m4 = new Thread(coet.motor4);   
            
            m1.start();
            m2.start();
            m3.start();
            m4.start();

        try {
            m1.join();
            m2.join();
            m3.join();
            m4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return;
        }
    }
    
}
