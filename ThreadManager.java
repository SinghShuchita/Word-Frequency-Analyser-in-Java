package tech.codingclub.utility;
import tech.codingclub.RunnableExample;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
    TaskManager taskManager = new TaskManager(100);
    public static void main(String[] args) {
        System.out.println("This is Shuchita Singh");
        System.out.println("Running TaskManager Example at " + new Date().getTime());
        TaskManager threadManager = new TaskManager(100);
        for(int i=0; i<10000; i++) {
            RunnableExample temp= new RunnableExample("THREAD-No.-"+i, 0, 500+i);
            threadManager.waitTillQueueIsFreeAndAddTask(temp);
        }
        System.out.println("############################################");
    }
}

