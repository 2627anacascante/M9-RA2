public class PrincipalIguals {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Fils("Pepe"));
        Thread t2 = new Thread(new Fils("Juan"));
        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
