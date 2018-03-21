package com.arnold.JavaConcurrencyInPractice.chapter5;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.*;

public class Memoizer2 <A, V> implements Computable<A, V> {
	private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
	public V compute(A arg) throws InterruptedException {
        Future<V> result = cache.get(arg);
        //result 是一个future，可能还没执行完。
        if (result == null) {

			Callable<V> eval = new Callable<V>() {
				@Override
				public V call() throws Exception {
					return c.compute(arg);
				}
			};

			FutureTask<V> futureTask = new FutureTask<>(eval);
			result = futureTask;

			//原子操作
			result = cache.putIfAbsent(arg,futureTask);
			futureTask.run();
        }
		try {
			return result.get();
		} catch (ExecutionException e) {
			throw LaunderThrowable.launderThrowable(e.getCause());
		}
    }
}

interface Computable <A, V> {
	V compute(A arg) throws InterruptedException;
}

class ExpensiveFunction
		implements Computable<String, BigInteger> {
	@Override
	public BigInteger compute(String arg) {
		// after deep thought...
		return new BigInteger(arg);
	}
}

class LaunderThrowable {

	/**
	 * Coerce an unchecked Throwable to a RuntimeException
	 * <p/>
	 * If the Throwable is an Error, throw it; if it is a
	 * RuntimeException return it, otherwise throw IllegalStateException
	 */
	public static RuntimeException launderThrowable(Throwable t) {
		if (t instanceof RuntimeException) {
			return (RuntimeException) t;
		} else if (t instanceof Error) {
			throw (Error) t;
		} else {
			throw new IllegalStateException("Not unchecked", t);
		}
	}
}