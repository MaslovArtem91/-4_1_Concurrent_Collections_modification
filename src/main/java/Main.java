public class Main {

    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        Thread operator1 = new Thread(null, callCenter::takeTheCall, "Оператор 1");
        Thread operator2 = new Thread(null, callCenter::takeTheCall, "Оператор 2");
        Thread operator3 = new Thread(null, callCenter::takeTheCall, "Оператор 3");
        Thread operator4 = new Thread(null, callCenter::takeTheCall, "Оператор 4");


        operator1.start();
        operator2.start();
        operator3.start();
        operator4.start();

        new Thread(null, callCenter::call, "№ ").start();
    }
}
