package com.qun.googleplay.downmanager;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Qun on 2017/7/16.
 */

public class ThreadPoolManager {

    private ThreadPoolManager() {

        //线程池创建
        int coreSize = 3;//核心线程数，线程池一创建开启多少线程
        int maxSize = 10;//最大线程数，最大同时可以运行多少个
        long keepTime = 5;//存活时间
        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(100);//队列
        //new ThreadPoolExecutor.AbortPolicy()这个线程池的策略
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreSize, maxSize, keepTime, TimeUnit.MINUTES, blockingQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }

    private static ThreadPoolManager sThreadPoolManager = new ThreadPoolManager();

    public static ThreadPoolManager getInstance() {
        return sThreadPoolManager;
    }
}
