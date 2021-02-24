package fcfs;

public class JobScheduler {
	
	public int [][] processes;
	public int length;
	
	public JobScheduler(int [][] processes){
		this.processes = processes;	
		this.length = processes.length;
	}
	
	public int[] completionTime(){
		int [] completion = new int[this.length];
		
		int lastExecutedTime=0; 
		for(int i=0;i<this.length;i++){
			
			if(this.processes[i][0] > lastExecutedTime)
			{
				lastExecutedTime = this.processes[i][0];
				
			}
			completion[i]=this.processes[i][1]+lastExecutedTime;
			lastExecutedTime+=this.processes[i][1];
		}
		
		return completion;
	}
	
	public int[] turnAroundTime()
	{
		int tatResult[]= new int[this.length];
		int lastExecutedTime=0;
		int completionTime;
		
		for(int i=0;i<this.length;i++)
		{
			if(this.processes[i][0]>lastExecutedTime)
			{
				lastExecutedTime=this.processes[i][0];
				
			}
			completionTime=this.processes[i][1]+lastExecutedTime;
			lastExecutedTime+=this.processes[i][1];
			tatResult[i]=completionTime-this.processes[i][0];
			
		}
		
		return tatResult;
		
	}
	

	public int[] waitingTime()
	{
		int waitingTimeResult[]=new int[this.length];
		int lastExecutedTime=0;
		int TurnAroundTime;
		int completionTime;
		for(int i=0;i<this.length;i++)
		{
			if(this.processes[i][0]>lastExecutedTime)
			{
				lastExecutedTime=this.processes[i][0];
				
			}
			completionTime=this.processes[i][1]+lastExecutedTime;
			lastExecutedTime+=this.processes[i][1];
			TurnAroundTime=completionTime-this.processes[i][0];
			waitingTimeResult[i]=TurnAroundTime-this.processes[i][1];
			
		}
		
		return waitingTimeResult;
		
	}
	
	public int averageWaitingTime()
	{
		int avgwait;
		int totalwait=0;
		int waitArray[]= this.waitingTime();
		for(int x:waitArray)
		{
			totalwait+=x;
		}
		
		avgwait=totalwait/this.length;
		
		return avgwait;
		
	}
	public int MaxWaitingTime()
	{
		int MaxWait=0;
		int waitArray[]= this.waitingTime();
		for(int x:waitArray)
		{
			MaxWait=Math.max(MaxWait, x);
		}
		
		return MaxWait;
		
	}
	
	public static void main(String[] args){
		
		int [][] processes = {{0,5},{10,20},{21,10}};
		
		JobScheduler p = new JobScheduler(processes);
		
		int [] c = p.completionTime();
		
		for(int i:c){
			System.out.println(i);
		}

	}

}
