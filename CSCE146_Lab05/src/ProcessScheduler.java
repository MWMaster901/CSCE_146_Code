/*
 * By Christopher Schweninger
 */
public class ProcessScheduler 
{
	//TODO Everything
	QueueI<Process> Processes;//This is the queue of upcoming process
	Process currentProcess;//This process is not part of the queue(because it is currently running)
	public ProcessScheduler()//Initilizer
	{
		Processes = new LLQueue<Process>();
	}
	public Process getCurrentProcess()//This returns the currently running process
	{
		return currentProcess;
	}
	public void addProcess(Process aProcess)//This adds the new process...
	{
		if(aProcess == null)//...nowhere if the given process is null
			return;
		else if(currentProcess == null)//...straight to the front since there is no current process(or queue)
		{
			currentProcess = new Process(aProcess.getName(), aProcess.getCompletionTime());
		}
		else//...or at the end on the queue
			Processes.enqueue(aProcess);
	}
	public void runNextProcess()//This shifts the current process out and immediately goes to the next process.
	{
		currentProcess = Processes.dequeue();
	}
	public void cancelCurrentProcess()//This does the same as runNextProcess, but first cancels the current process(by setting it to null)
	{
		currentProcess = null;
		this.runNextProcess();
	}
	public void printProcessQueue()//This prints the upcoming queue
	{
		Processes.print();
	}
}
