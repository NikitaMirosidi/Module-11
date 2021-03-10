public class Task1 {
    static int count = 0; // переменная времени

    public static void threads(int howLong) {
        System.out.println("Время пошло");

        Thread timeCounter = new Thread(() -> { // поток ежескундно меняющий переменную времени
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.currentThread().sleep (1000);
                    count++;
                    System.out.println("Прошло секунд: " + count);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        Thread everyFiveSec = new Thread(() -> { // поток выводящий сообщение каждые 5 сек
            while (!Thread.currentThread().isInterrupted()) {
                if (count != 0 && count % 5 == 0) {
                    System.out.println("Прошло 5 секунд");
                }
                try {
                    Thread.currentThread().sleep (1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        timeCounter.start();
        everyFiveSec.start();

        try {
            Thread.currentThread().sleep(howLong);
            timeCounter.interrupt();
            everyFiveSec.interrupt();
            Thread.currentThread().sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Ошибочка");
        }
    }
}