/*
The Shortest Job First (SJF) scheduling algorithm is a non-preemptive scheduling algorithm that selects the process with the shortest burst time for execution. In this algorithm, the process that requires the least amount of time to complete its execution is given the CPU first.

Algorithm Description:

When a process enters the ready queue, the scheduler compares its burst time with the burst times of all other processes in the queue.

The process with the shortest burst time is selected to run next. If two processes have the same shortest burst time, the one that arrived first is chosen.

The selected process runs on the CPU until it completes its execution, enters a waiting state (e.g., I/O operation), or its time quantum (if there is a time-sharing system) expires.

Once the currently running process finishes, the CPU scheduler again selects the process with the shortest remaining burst time for execution.

This process of selecting and executing processes continues until all processes have completed.

Example:
Let's use your example with three processes: P1, P2, and P3, with arrival times and burst times as follows:

Process P1: Arrival time = 0 ms, Burst time = 7 ms
Process P2: Arrival time = 2 ms, Burst time = 3 ms
Process P3: Arrival time = 4 ms, Burst time = 8 ms
Here's how SJF will schedule and execute these processes:

Initially, the ready queue is empty.

Process P1 arrives first, so it is added to the ready queue:

Ready Queue: [P1]
P1 has the shortest burst time (7 ms), so it is selected to run:

Execution: P1 (7 ms)
Ready Queue: []
Process P2 arrives next, with a shorter burst time than P3, so it is added to the ready queue:

Ready Queue: [P2]
P2 has the shortest burst time (3 ms), so it is selected to run:

Execution: P2 (3 ms)
Ready Queue: []
Finally, process P3 arrives and is added to the ready queue:

Ready Queue: [P3]
P3 has the shortest burst time (8 ms), so it is selected to run:

Execution: P3 (8 ms)
Ready Queue: []
The order of execution in SJF is P1 -> P2 -> P3. SJF aims to minimize the average waiting time for processes, making it an effective algorithm when you have information about the burst times of processes. However, it can suffer from starvation if a long job continually arrives after shorter jobs.
*/

#include <stdio.h>
#include <stdlib.h>

// Struct for the info of each process
typedef struct 
{

  int process_id;
  int arrival_time;
  int burst_time;

} process;


int main() {

  // Number of processes
  int number=3;

  // Size of the array which will show the order of execution of the processes
  process *arr;
  arr = malloc(number * sizeof(process));

  // Initialize for our example 
  arr[0].process_id = 1;
  arr[0].arrival_time = 0;
  arr[0].burst_time = 7;
  
  arr[1].process_id = 2;
  arr[1].arrival_time = 2;
  arr[1].burst_time = 3;
  
  arr[2].process_id = 3;
  arr[2].arrival_time = 4;
  arr[2].burst_time = 8;

  //Sorting the struct by arrival time
  process temp;
  for(int i=0; i<number; i++)
  {
	  for(int j=0; j<number; j++)
	  {
      //if shorter swap
	    if(arr[i].arrival_time < arr[j].arrival_time)
		  {
			  temp = arr[j];
			  arr[j] = arr[i];
			  arr[i] = temp;
	    }
    }
  }

  //Variables for index,time and minimum burst time
  int k=1,time=0,min;

  //Sorting to create a correct priority
  for (int i=0; i<number; i++)
  {
    
    time = time + arr[i].burst_time; //Add arrival time to time
    min = arr[k].burst_time; //Set minimum burst time
    
    for (int j=k; j<number; j++)
    {
      //If time more than or equal to arrival time 
      //And burst time less than or equal to minimum
      //Then swap
      if (time >= arr[j].arrival_time && arr[j].burst_time <= min)
      {
        temp = arr[k];
        arr[k] = arr[j];
        arr[j] = temp;
      }
    }
    k++; //increase index
  }

  //Variable for the sum of burst time 
  int sum_of_burst_time=0;

  //Calculate sum of burst time
  for (int i=0; i<number; i++)
  {
    sum_of_burst_time = sum_of_burst_time + arr[i].burst_time;
  }

  //Create an array to save the processesfor gnatt chart
  int *A = malloc( sum_of_burst_time * sizeof(int) );

  //index for array A
  int count=0;
  
  //Save the id in cells of A
  for (int i=0; i<number; i++)
  {
    //Put process id in arr[i].burst_time cells of A
    for (int j=0; j<arr[i].burst_time; j++)
    {
      A[count]=arr[i].process_id;//save id
      count++; //increase index
    }
    
  }

  //Print A (Gnatt chart)
  for (int i=0; i<sum_of_burst_time; i++)
  {
    printf("%d\n",A[i]);
  }

  return 0; 
  
}