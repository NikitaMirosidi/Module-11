public class Task2 {
    int digit = 0;
    boolean incrementDone = false;

    public void function(int capacity) {

        Thread counter = new Thread(() -> {
            while (digit < capacity) {
                if (!incrementDone) {
                    digit++;
                    incrementDone = true;
                }
            }
        });

        Thread a = new Thread(() -> {
            while (digit < capacity) {
                if (incrementDone) {
                    fizz(digit);
                }
            }
        });

        Thread b = new Thread(() -> {
            while (digit < capacity) {
                 if (incrementDone) {
                     buzz(digit);
                 }
            }
        });

        Thread c = new Thread(() -> {
            while (digit < capacity) {
                if (incrementDone) {
                    fizzbuzz(digit);
                }
            }
        });

        Thread d = new Thread(() -> {
            while (digit < capacity) {
                if (incrementDone) {
                    number(digit);
                }
            }
        });

        counter.start();
        a.start();
        b.start();
        c.start();
        d.start();
    }

    public void fizz(int digit) {
        if (digit % 3 == 0 && digit % 5 != 0) {
            System.out.print("fizz");
            incrementDone = false;
        }
    }

    public void buzz(int digit) {
        if (digit % 5 == 0 && digit % 3 != 0) {
            System.out.print("buzz");
            incrementDone = false;
        }
    }

    public void fizzbuzz(int digit) {
        if (digit % 3 == 0 && digit % 5 == 0) {
            System.out.print("fizzbuzz");
            incrementDone = false;
        }
    }

    public void number(int digit) {
        if (digit % 3 != 0 && digit % 5 != 0) {
            System.out.print(digit);
            incrementDone = false;
        }
    }
}