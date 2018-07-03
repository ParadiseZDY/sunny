package com.sunny.demo;

import com.google.common.collect.Lists;
import com.sunny.common.DateFormatConstant;
import com.sunny.rpc.IStudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dongyangz
 * @date 2018/6/27
 */
public class StudentServiceTest extends CommonTest{

    @Autowired
    private IStudentService studentService;

    private static final ExecutorService executor = Executors.newFixedThreadPool(3);
    private static final ExecutorService EXECUTOR_SERVICE = new
            ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS,new LinkedBlockingDeque<>(5));

    @Test
    public void testMongo(){
//        Integer save = studentService.saveStudent();
//        System.out.println(save);
//        Integer update = studentService.updateStudent();
//        System.out.println(update);
        Integer query = studentService.queryStudent();
        System.out.println(query);
    }

    @Test
    public void testSimpleDateFormat() throws Exception{
        long start = System.currentTimeMillis();
        System.out.println("------------------------");
        List<String> list = null;
        try {
            list = Lists.newArrayList();
            for (int i = 0; i < 10000; i++) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
                        String format = sdf.format(new Date());
                        System.out.println(Thread.currentThread().getName() + ":" + format);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(list.size());
            System.out.println("speed=" + (System.currentTimeMillis() - start));
        }
    }

    @Test
    public void testSimpleDateFormat2() throws Exception{
        long start = System.currentTimeMillis();
        List<String> list = null;
        try {
            list = Lists.newArrayList();
            for (int i = 0; i < 10000; i++) {
                Future<String> future = executor.submit(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
                        String format = sdf.format(new Date());
                        System.out.println(Thread.currentThread().getName() + ":" + format);
                        return format;
                    }
                });
                list.add(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(list.size());//10000
            System.out.println("speed=" + (System.currentTimeMillis() - start));//441
        }
    }

    @Test
    public void testSimpleDateFormat3() throws Exception{
        long start = System.currentTimeMillis();
        List<String> list = null;
        try {
            list = Lists.newArrayList();
            for (int i = 0; i < 10000; i++) {
                Future<String> future = EXECUTOR_SERVICE.submit(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
                        String format = sdf.format(new Date());
                        System.out.println(Thread.currentThread().getName() + ":" + format);
                        return format;
                    }
                });
                list.add(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(list.size());//10000
            System.out.println("speed=" + (System.currentTimeMillis() - start));//468
        }
    }

    @Test
    public void testSimpleDateFormat4() throws Exception{
        long start = System.currentTimeMillis();
        List<String> list = null;
        try {
            list = Lists.newArrayList();
            for (int i = 0; i < 10000; i++) {
                Future<String> future = executor.submit(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        String format = DateFormatConstant.yMdHms.get().format(new Date());
                        System.out.println(Thread.currentThread().getName() + ":" + format);
                        return format;
                    }
                });
                list.add(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(list.size());//10000
            System.out.println("speed=" + (System.currentTimeMillis() - start));//316
        }
    }
}
