package com.qun.googleplay.downmanager;

import android.os.AsyncTask;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Qun on 2017/7/16.
 */

public class ThreadPoolManager {

    private ThreadPoolExecutor mThreadPoolExecutor = null;

    private ThreadPoolManager() {

        if (mThreadPoolExecutor == null) {
            //线程池创建
            int CPU_COUNT = Runtime.getRuntime().availableProcessors();
            // We want at least 2 threads and at most 4 threads in the core pool,
            // preferring to have 1 less than the CPU count to avoid saturating
            // the CPU with background work
            int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));

            int coreSize = 3;//核心线程数，线程池一创建开启多少线程
            int maxSize = 10;//最大线程数，最大同时可以运行多少个
            long keepTime = 5;//存活时间
            LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(Integer.MAX_VALUE);//队列
            //new ThreadPoolExecutor.AbortPolicy()这个线程池的策略
            mThreadPoolExecutor = new ThreadPoolExecutor(coreSize, maxSize, keepTime, TimeUnit.MINUTES, blockingQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            /**
             * 1.开启核心线程数
             * 2.把后面的线程加入到队列中
             * 3.判断最大线程数是否满，如果没满，直接开启
             * 4.如果队列与最大的线程数都满了，就去查看线程池策略
             */

            
        }
    }

    private static ThreadPoolManager sThreadPoolManager = new ThreadPoolManager();

    public static ThreadPoolManager getInstance() {
        return sThreadPoolManager;
    }

    //加入线程
    public void addRunnable(Runnable runnable){
        //加入线程池不一定开启线程
        mThreadPoolExecutor.execute(runnable);
    }
}
