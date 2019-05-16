package com.example.demo.async;


import org.springframework.stereotype.Component;

/**
 * 描述：Async测试
 * @author wangyu
 * @date 2019/5/16
 */

@Component
public class Async {
    public static  int flag = 0 ;

    public void task() {
        long time ;
        try{
            long startTime = System.currentTimeMillis() ;
            System.out.println("开始执行任务------");
            for (int i = 0; i < 999999999; i++) {

            }
            long endTime = System.currentTimeMillis() ;
            time = endTime - startTime;
            System.out.println("任务完成花费时间---："+time);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.springframework.scheduling.annotation.Async
    public  void  taskAsync() {
        long time ;
        try{
            long startTime = System.currentTimeMillis() ;
            System.out.println("开始执行任务------");
            for (int i = 0; i < 999999999; i++) {

            }
            long endTime = System.currentTimeMillis() ;
            time = endTime - startTime;
            System.out.println("任务完成花费时间---："+time);
        }catch (Exception e) {
            e.printStackTrace();
        }
        flag++ ;
    }

}
