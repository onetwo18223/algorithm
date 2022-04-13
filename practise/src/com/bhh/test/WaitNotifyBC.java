package com.bhh.test;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author bhh
 * @description
 * 通过wait / notify实现消费者模型
 * @date Created in 2021-09-05 16:57
 * @modified By
 */
public class WaitNotifyBC {
    // 生产者
    static class Produce implements Runnable{

        private Queue<Integer> queue;
        private int maxSize;

        Produce(Queue<Integer> queue, int maxSize){
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    while (queue.size() == maxSize){
                        try {
                            System.out.println("队列已满");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int i = new Random().nextInt();
                    System.out.println("添加" + i);
                    queue.add(i);
                    queue.notify();
                }
            }

        }
    }
    static class Consumer implements Runnable{

        private Queue<Integer> queue;

        Consumer(Queue<Integer> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    while (queue.isEmpty()){
                        System.out.println("队列为空");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer remove = queue.remove();
                    System.out.println("移除的数据" + remove);
                    queue.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        Produce produce = new Produce(queue, 10);
        Consumer consumer = new Consumer(queue);
        new Thread(produce).start();
        new Thread(consumer).start();
    }
}
