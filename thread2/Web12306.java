package cn.com.thread;

public class Web12306 implements Runnable{
    private int ticketsNums = 100;
    @Override
    public void run() {
        while(true) {
            if (ticketsNums < 0) {
                break;
            }
            try {
                Thread.sleep(200); //模拟网络延时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+ticketsNums--);
        }
    }

    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"小明").start();
        new Thread(web,"小红").start();
        new Thread(web,"小黄").start();
    }
}
