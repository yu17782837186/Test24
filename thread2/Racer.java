package cn.com.thread;

public class Racer implements Runnable{
    private String winner;
    @Override
    public void run() {
        for (int step = 0; step <= 100 ; step++) {
            if (Thread.currentThread().getName().equals("兔子") && step %20 ==0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->"+step);
            //比赛是否结束
            boolean flag = gameOver(step);
            if (flag) {
                break;
            }
        }
    }
    private boolean gameOver(int step) {
        if (winner != null) {//有胜利者
            return true;
        }else {
            if (step == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner===>"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer= new Racer();
        new Thread(racer,"乌龟").start();
        new Thread(racer,"兔子").start();
    }
}
