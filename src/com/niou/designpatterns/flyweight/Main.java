package com.niou.designpatterns.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * <pre>
 * @ClassName Main.java
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/15 0:03<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/15 	niou		    		新建
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        BulletPool pool = new BulletPool();


        Random random = new Random(4);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    pool.setLive(random.nextInt());
                }
            }
        });
        thread.start();

        for (int i = 0; i < 100; i++){
            Bullet bullet = pool.getBullet();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(bullet);
        }
    }
}
class Bullet {
    UUID id = UUID.randomUUID();
    boolean islive = false;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                '}';
    }
}

class BulletPool {
    List<Bullet> pool = new ArrayList<>();

    {
        for (int i = 0; i < 5; i++) {
            pool.add(new Bullet());
        }
    }

    public Bullet getBullet(){
        for (Bullet b : pool){
            if(!b.islive){
                b.islive = true;
                return b;
            }
        }
        return new Bullet();
    }

    public void setLive(int i){
        if(i > 0 && i < pool.size()){
            if(pool.get(i).islive){
                pool.get(i).islive = false;
            }
        }
    }
}
