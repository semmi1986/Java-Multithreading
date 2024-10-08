package task1619;

/* 
А без interrupt слабо?
Разберись, как работает программа.
Реализуй метод ourInterruptMethod таким образом, чтобы он прерывал нить TestThread. Исправь остальной код программы, если это необходимо. Нельзя использовать метод interrupt.


Requirements:
1. В классе Solution должен быть публичный статический метод ourInterruptMethod без параметров.
2. Метод run должен выводить надпись "he-he" каждые пол секунды, пока не будет вызван метод ourInterruptMethod.
3. Необходимо изменить условие цикла while в методе run.
4. Метод main должен создавать объект типа Thread передавая в конструктор объект типа TestThread.
5. Метод main должен вызывать метод start у объекта типа Thread.
6. Метод main должен вызывать метод ourInterruptMethod.*/

public class Solution {
    public static boolean isStop = true;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);

        ourInterruptMethod();
        t.join();
        System.out.println("Main end");
    }

    public static void ourInterruptMethod() {
        isStop = false;
        System.out.println("prervan");
    }

    public static class TestThread implements Runnable {
        public void run() {
            while (isStop) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
