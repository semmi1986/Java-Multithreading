package task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
В методе main добавить в статический объект list 5 нитей. Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.


Requirements:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Класс SpecialThread изменять нельзя.*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<>(5);

    public static void main(String[] args) {
        //напишите тут ваш код
        SpecialThread sp1 = new SpecialThread();
        SpecialThread sp2 = new SpecialThread();
        SpecialThread sp3 = new SpecialThread();
        SpecialThread sp4 = new SpecialThread();
        SpecialThread sp5 = new SpecialThread();

        list.add(new Thread(sp1));
        list.add(new Thread(sp2));
        list.add(new Thread(sp3));
        list.add(new Thread(sp4));
        list.add(new Thread(sp5));

    }

    public static class SpecialThread implements Runnable {


        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
