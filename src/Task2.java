import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public volatile int digit = 0;
    public volatile boolean incrementDone = false;
    public List<String> line = new ArrayList<>();

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

        try {
            counter.join();
            a.join();
            b.join();
            c.join();
            d.join();
        } catch (InterruptedException e) {
            System.out.println("Ошибочка прерывания");
        }

        System.out.println(line.stream()
                .collect(Collectors.joining(", ")));
    }

    public void fizz(int digit) {
        if (digit % 3 == 0 && digit % 5 != 0) {
            line.add("fizz");
            incrementDone = false;
        }
    }

    public void buzz(int digit) {
        if (digit % 5 == 0 && digit % 3 != 0) {
            line.add("buzz");
            incrementDone = false;
        }
    }

    public void fizzbuzz(int digit) {
        if (digit % 3 == 0 && digit % 5 == 0) {
            line.add("fizzbuzz");
            incrementDone = false;
        }
    }

    public void number(int digit) {
        if (digit % 3 != 0 && digit % 5 != 0) {
            line.add(Integer.toString(digit));
            incrementDone = false;
        }
    }
}