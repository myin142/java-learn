package root.concur;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// thread - smallest unit of execution
// process - group of thread in same shared environment
// shared environment - thread in same progress share memory space and can communicate with one another
// task - single unit of work performed by thread
//
// Thread Types:
// 		system thread - created by JVM, runs in background
// 		user-defined thread - created by application to do specific task
// 		NOT OCP:
// 		daemon thread - marked as daemon, JVM will still exit if only daemon thread
//
// Thread Concurrency: exec. multiple thread/process at same time
// 	OS use thread scheduler to determine which thread to use
// 		round-robin schedule - each thread get same number of CPU cycles to execute, with thread visited in circular order
// 		context switch - if thread time complete but work not done -> save state and restore later
// 		supersede - thread has higher priority -> interrupts another thread
// 		thread priority - numeric value
//
// thread pool - group of reusable thread Executors factory class
//
public class Concurrency extends RecursiveTask<String> implements Runnable{

	// Functional Interface:
	//		public interface Runnable { void run(); }
	//		public interface Callable<V> { V call() throws Exception }
	//
	// Ambiguous lambda expression: Cannot show the difference between Supplier and Callable
	//		Can be fixed by casting
	//
	// Create Thread: order of execution not often guaranteed
	//		| Runnable or lambda to Thread Constructor
	//		| Create Thread subclass and override run()
	//		After creation -> start with start()

	public void run(){
		// Polling - intermittently checking data at some fixed interval
		// Thread.sleep(long millis) throws InterruptedException
		try{
			Thread.sleep(1000);
			System.out.println("Runnable Class running...");
		} catch (InterruptedException e){}
	}

	public static void init(){ try { main(); } catch (Exception e) { System.out.println(e); } }

	public static void main() throws InterruptedException, ExecutionException, TimeoutException, BrokenBarrierException{
		(new Thread(new Concurrency())).start();
		(new SubThread()).start();

		// ExecutorService:
		// 		ExecutorService Executors.newSingleThreadExecutor()							Single-Thread
		// 		ScheduledExecutorService Executors.newSingleThreadScheduledExecutor()		Single-Thread schedulable
		//		ExecutorService Executors.newCachedThreadPool()								Dynamic Thread Pool
		//		ExecutorService Executors.newFixedThreadPool(int)							Fixed Thread Pool
		//		ScheduledExecutorService Executors.newScheduledThreadPool(int)				(~Fixed) Thread Pool schedulable
		//
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		//
		// Submitting Task:
		//		void execute(Runnable)
		//		Future<?> submit(Runnable)		- 	Future value will always be null
		//		Future<T> submit(Callable<T>)	-	distinguish between Runnable by returning something
		//		List<Future<T>> invokeAll(Collection<? extends Callable<T>>) throws InterruptedException 			execute synchronously, return Collection of Future in same order
		//		T invokeAny(Collection<? extends Callable<T>>) throws InterruptedException, ExecutionException 		execute synchronously, return result of one finished task, cancelling any unfinished tasks
		//
		Future<String> result1 = service.submit(() -> { System.out.println("Executing Service"); return "Success"; });
		//
		// Schedule Task: additional methods for ScheduledExecutorService (all returns ScheduledFuture<V>)
		//		schedule(Callable<V>, long, TimeUnit)
		//		schedule(Runnable, long, TimeUnit)
		//		scheduleAtFixedRate(Runnable, long initial, long period, TimeUnit)		create new after every period
		//		scheduleAtFixedDelay(Runnable, long initial, long delay, TimeUnit)		create new after finished and delay
		//
		ScheduledFuture<String> result2 = service.schedule(() -> { System.out.println("Executing Scheduled Service"); return "Success"; }, 5, TimeUnit.SECONDS);
		//
		// Shutdown:
		//		void shutdown()						shutdown Executor -> when new task -> RejectedExecutionException
		//		List<Runnable> shutdownNow()		attempt to stop all tasks, return list of task that were not executed
		//		boolean isShutdown()				if shutdown() called
		//		boolean isTerminated()				if shutdown and no task executing
		//
		service.shutdown();
		//
		// Await Termination:
		//		boolean awaitTermination(long, TimeUnit) throws InterruptedException
		//
		service.awaitTermination(1, TimeUnit.MINUTES); // InterruptedException
		if(service.isTerminated()){
			System.out.println("Servive terminated");
		}else{
			System.out.println("Some Tasks still running");
		}
		// 
		// ScheduledFuture: same as Future + getDelay(TimeUnit) - get remaining delay
		//
		System.out.println("Remaining Delay of scheduled service: " + result2.getDelay(TimeUnit.SECONDS) + "s");
		//
		// TimeUnit: NANOSECONDS | MICROSECONDS | MILLISECONDS | SECONDS | MINUTES | HOURS | DAYS
		//
		// Future:
		//		isDone()					true if completed, threw exception or cancelled
		//		isCancelled()				true if cancelled before completely normally
		//		cancel()					attempts to cancel execution of task
		//		V get()						get result of task, waiting endlessly if not yet available | throws InterruptedException, ExecutionException
		//		V get(long, TimeUnit)		same as get(), with timeout -> TimeoutException
		//
		System.out.println("Result 1: " + result1.get(5, TimeUnit.SECONDS)); // Interrupted-, Execution-, TimeoutException

		//	CyclicBarrier: new CyclicBarrier(int, Runnable) -> await() - waiting until this method called int times, Runnable optional
		//		await() throws InterruptedException, BrokenBarrierException
		//		CyclicBarrier limit <= Thread Pool size
		CyclicBarrier barrier = new CyclicBarrier(1, () -> System.out.println("Past Barrier"));
		barrier.await(); // Interrupted-, BrokenBarrierException

		// Fork/Join Framework: (split up to additional tasks)
		//		Recursion: task calls itself to solve problem
		//		Base case: non-recursive method, used to terminate recursive path
		//		Recursive case: recursive method, call itself one or multiple times
		//			Create ForkJoinTask
		//			Create ForkJoinPool
		//			Start ForkJoinTask
		//
		// abstract class RecursiveAction { protected abstract void compute(); }	/ extends ForkJoinTask
		// abstract class RecursiveTask<T> { protected abstract T compute(); }		/
		//
		// RecursiveAction -> invokeAll(ForkJoinTask...), never calls compute on his own and has no return
		// RecursiveTask -> fork() -> return task.compute() + otherTask.join()
		// ForkJoinPool -> invoke(ForkJoinTask)
		//
		// Fork/Join Issues:
		// 		Class should extends RecursiveAction or RecursiveTask
		// 		RecursiveAction - override protected void compute()
		// 		RecursiveTask - override protected T compute()
		// 		invokeAll() - two instance of fork/join and no return
		// 		fork() - submit new task, like thread executor submit()
		// 		join() - called after fork(), curr. thread wait for result
		// 		Calling compute() within compute() -> task wait for result
		// 		fork() called before curr. thread perform compute() with join()
		// 		compute() no arguments -> often constructor used
		//
		ForkJoinTask<String> task = new Concurrency(10);
		ForkJoinPool pool = new ForkJoinPool();
		System.out.println(pool.invoke(task));

		// Threading Problems:
		// 		Understanding Liveness: ability of app. to exec. in timely manner
		// 			Deadlock: two or more thread blocked forever, waiting each other
		// 			Starvation: single thread denied access to shared resource
		// 			Livelock: still active, but blocked to complete their task
		// 		Managing Race Conditions:
		// 			Both continue -> invalid data
		// 			Both get error -> at least no invalid data
		// 			One continue, One get error -> best possible outcome
	}

	private static String result = "";
	private int tasks;

	Concurrency(){}
	Concurrency(int task){
		this.tasks = task;
	}

	protected String compute(){
		if(tasks < 1){
			System.out.println("Returning result: " + result);
			return result;
		}else{
			result += tasks + ",";
			System.out.println("Appending to result: " + result);
			RecursiveTask<String> otherTask = new Concurrency(tasks-1);
			otherTask.fork();

			return otherTask.join();
		}
	}

}

// Extending Thread is less common
class SubThread extends Thread{
	public void run(){
		System.out.println("Thread Class running...");
	}
}