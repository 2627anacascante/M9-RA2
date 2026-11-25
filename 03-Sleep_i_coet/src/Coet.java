
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

        private void executaMotors() throws InterruptedException {
            Thread[] fils = {
                new Thread(motor1),
                new Thread(motor2),
                new Thread(motor3),
                new Thread(motor4)
            };

            for (Thread fil : fils) {
                fil.start();
            }
            for (Thread fil : fils) {
                fil.join();
            }
        }

        public static void main(String[] args) {
            Coet coet = new Coet();

        try {
            for (int p = 7; p >= 0; p--) {
                coet.passaAPotencia(p);
                coet.executaMotors();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
    
}
