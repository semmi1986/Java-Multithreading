package task1709;

/* 
Предложения
Не используя synchronized сделай так, чтобы количество сделанных и принятых предложений было одинаковым.


Requirements:
1. Класс Solution должен содержать нить MakeProposal.
2. Класс Solution должен содержать нить AcceptProposal.
3. Класс Solution должен содержать публичную статическую переменную int proposal.
4. Программа не должна содержать synchronized методов или synchronized блоков.
5. Переменная int proposal не должна находится в локальном кэше.
*/

import java.util.concurrent.Exchanger;

public class Solution {
    public static int proposal = 0;
    private static Exchanger<Integer> exchanger = new Exchanger<>();

    public static void main(String[] args) throws InterruptedException {
        new AcceptProposal().start();
        new MakeProposal().start();

    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
           while (proposal < 10) {
                System.out.println("Сделано предложение №" + (proposal + 1));
                proposal++;
                try {
                    Thread.sleep(100);
                    exchanger.exchange(proposal);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (thisProposal < 10) {
                try {
                    int acceptedProposal = exchanger.exchange(0);
                    System.out.println("Принято предложение №" + acceptedProposal);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
