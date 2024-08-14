package task1618;

/* 
Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().


Requirements:
1. Класс TestThread должен быть унаследован от Thread.
2. Класс TestThread должен иметь public void метод run.
3. Метод main должен создавать объект типа TestThread.
4. Метод main должен вызывать метод start у объекта типа TestThread.
5. Метод main должен вызывать метод interrupt у объекта типа TestThread.*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        System.out.println("Main start");
        TestThread tt = new TestThread();
        tt.start();
        Thread.sleep(10);
        tt.interrupt();
        tt.join();
        System.out.println("Main stop");
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        public void run(){
            for (int i = 0; i < 1000; i++) {
                System.out.println("eto TestThread " + i);
                if (isInterrupted()){
                    System.out.println("Potok prervan");
                    return;
                }
            }

            }
    }
}