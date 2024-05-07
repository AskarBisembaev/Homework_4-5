package Home_Works.Phaser;

import java.util.concurrent.Phaser;

public class Race_Phaser {
    private static final Phaser START = new Phaser(8);
    private static final int trackLength = 500000;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
            Thread.sleep(1000);
        }

        Thread.sleep(1000);
        System.out.println("На старт!");
        START.arriveAndDeregister();
        Thread.sleep(1000);
        System.out.println("Внимание!");
        START.arriveAndDeregister();
        Thread.sleep(1000);
        System.out.println("Марш!");
        START.arriveAndDeregister();
    }

    public static class Car implements Runnable {
        private int carNumber;
        private int carSpeed;

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @Override
        public void run() {
            System.out.printf("Автомобиль №%d подъехал к стартовой прямой.\n", carNumber);
            START.arriveAndAwaitAdvance();
            try {
                Thread.sleep(trackLength / carSpeed);
                System.out.printf("Автомобиль №%d финишировал!\n", carNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

