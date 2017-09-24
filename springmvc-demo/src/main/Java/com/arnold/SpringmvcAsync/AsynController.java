package com.arnold.SpringmvcAsync;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * springmvc 异步的两种方式：
 *    一种是返回DeferredResult，线程我们自己管理,自己将结果放入DeferredResult。
 *    另一种是返回WebAsyncTask(也可以直接返回Callable)，
 */
@RestController
public class AsynController {
    @RequestMapping(value = "/asyn", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public DeferredResult<String> asyncTask() {
        //final DeferredResult<String> deferredResult = new DeferredResult<String>();
        //设置超时时间
        final DeferredResult<String> deferredResult = new DeferredResult<String>(4000l);
        System.out.println("/asynctask 调用！thread id is : " + Thread.currentThread().getId());
        LongTimeAsyncCallService service = new LongTimeAsyncCallService();
        service.makeRemoteCallAndUnknownWhenFinish(new LongTermTaskCallback() {
            public void callback(Object result) {
                System.out.println("异步调用执行完成, thread id is : " + Thread.currentThread().getId());
                deferredResult.setResult(result.toString());
            }
        });
        System.out.println("controller执行结束");
        // 超时处理
        deferredResult.onTimeout(new Runnable() {
            @Override
            public void run() {
                System.out.println("异步调用执行超时！thread id is : " + Thread.currentThread().getId());
                deferredResult.setResult("异步调用执行超时");
            }
        });

        return deferredResult;
    }

    //@RequestMapping(value = "/spirngasyn", method = RequestMethod.GET)
    //解决返回中午乱码问题
    @RequestMapping(value = "/spirngasyn" , produces="text/plain;charset=UTF-8")
    public WebAsyncTask<String> longTimeTask() {
        System.out.println("/spirngasyn被调用 thread id is : " + Thread.currentThread().getId());
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(3000); // 假设是一些长时间任务
                System.out.println("执行成功 thread id is : " + Thread.currentThread().getId());
                return "spirngasyn,调用结束!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
            }
        };
        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(1000, callable);
        // 超时处理
        webAsyncTask.onTimeout(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "异步线程处理超时了异步线程处理超时了异步线程处理超时了异步线程处理超时了";
            }
        });
        System.out.println("controller执行结束");
        return webAsyncTask;
    }

}