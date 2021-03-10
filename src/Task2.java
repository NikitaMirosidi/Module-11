public class Task2 {
    int digit = 0;
    boolean counterDone = false;
    boolean aDone = true;
    boolean bDone = true;
    boolean cDone = true;
    boolean dDone = true;

    public void function(int capacity) {

        Thread counter = new Thread(() -> {
            while (digit < capacity) {
                if (!counterDone && aDone && bDone ) {
                    digit++;
                    counterDone = true;
                    aDone = bDone = cDone = dDone = false;
                }
            }
        });

        Thread a = new Thread(() -> {
            while (digit < capacity) {
                if (counterDone && !aDone) {
                    aDone = true;
                    fizz(digit);
                }
            }
        });

        Thread b = new Thread(() -> {
            while (digit < capacity) {
                if (counterDone && !bDone) {
                    bDone = true;
                    buzz(digit);
                }
            }
        });

        Thread c = new Thread(() -> {
            while (digit < capacity) {
                if (counterDone && !cDone) {
                    cDone = true;
                    fizzbuzz(digit);
                }
            }
        });

        Thread d = new Thread(() -> {
            while (digit < capacity) {
                if (counterDone && !dDone) {
                    dDone = true;
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
            System.out.println("fizz");
            booler();
        }
    }

    public void buzz(int digit) {
        if (digit % 5 == 0 && digit % 3 != 0) {
            System.out.println("buzz");
            booler();
        }
    }

    public void fizzbuzz(int digit) {
        if (digit % 3 == 0 && digit % 5 == 0) {
            System.out.println("fizzbuzz");
            booler();
        }
    }

    public void number(int digit) {
        if (digit % 3 != 0 && digit % 5 != 0) {
            System.out.println(digit);
            booler();
        }
    }

    public void booler() {
        aDone = bDone = cDone = dDone = true;
        counterDone = false;
    }
}