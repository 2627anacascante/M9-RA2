public class Main {

    public static void main(String[] args) {

    Thread name1 = new Thread( new DormAleatori("Joan"));
    Thread name2 = new Thread( new DormAleatori("Pep"));

    name1.setPriority(Thread.MIN_PRIORITY);
    name2.setPriority(Thread.NORM_PRIORITY);
    name1.start();
    name2.start();

        try {
            name1.join();
            name2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
}

}
