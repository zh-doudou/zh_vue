package com.zhanghui.vue;

//龟兔赛跑
public class Race implements Runnable {
    //胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息
       /*     if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0  ) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
            //判断比赛是否结束
            boolean flag = gameOver(i);
            //比赛结束停止
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--跑了" + i + "步");
        }
    }

    private Boolean gameOver(int steps) {
        if (winner != null) {
            //已经有胜利者产生
            return true;
        } else {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("胜利者为：" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
