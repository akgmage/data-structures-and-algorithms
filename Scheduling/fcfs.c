/*

The First-Come, First-Served (FCFS) scheduling algorithm is one of the simplest process scheduling algorithms used in operating systems. It follows the principle of serving processes in the order they arrive in the ready queue. In FCFS, the process that arrives first will be the first one to be executed, and it continues until the process completes its execution or enters a waiting state.

Algorithm Description:

When a process enters the ready queue, it is added to the end of the queue (at the "tail" of the queue).

The CPU scheduler selects the process at the front of the queue (the "head" of the queue) for execution.

The selected process runs on the CPU until it completes its execution, enters a waiting state (e.g., I/O operation), or its time quantum (if there is a time-sharing system) expires.

Once the currently running process finishes, the CPU scheduler selects the process at the front of the queue as the next process to run. This process will continue until it completes or enters a waiting state, and so on.

This process of selecting and executing processes continues until all processes in the queue have executed.

Example:
Let's illustrate the FCFS algorithm with a simple example. Consider three processes, P1, P2, and P3, with their respective burst times (the time they need to complete execution):

Process P1: Burst time = 2 ms
Process P2: Burst time = 7 ms
Process P3: Burst time = 4 ms
Here's how FCFS will schedule and execute these processes:

Initially, the ready queue is empty.

Process P1 arrives first, so it is added to the ready queue:

Ready Queue: [P1]
Execution: P1 (2 ms)
Process P1 completes its execution. Now, process P2 is selected because it's at the front of the queue:

Ready Queue: [P2]
Execution: P2 (7 ms)
Process P2 completes its execution. Finally, process P3 is selected:

Ready Queue: [P3]
Execution: P3 (4 ms)
Process P3 completes its execution.

The order of execution in FCFS is P1 -> P2 -> P3. FCFS is non-preemptive, meaning once a process starts execution, it continues until it finishes or enters a waiting state. It can suffer from the "convoy effect," where a long process at the head of the queue can block shorter processes behind it.

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
  arr[0].burst_time = 2;

  arr[1].process_id = 2;
  arr[1].arrival_time = 1;
  arr[1].burst_time = 7;
  
  arr[2].process_id = 3;
  arr[2].arrival_time = 3;
  arr[2].burst_time = 4;

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

  //Variable for the sum of burst time 
  int sum_of_burst_time=0;

  //Calculate sum of burst time for helping us know the size of A
  for (int i=0; i<number; i++)
  {
    sum_of_burst_time = sum_of_burst_time+arr[i].burst_time;
  }

  //Create an array to save the processes for gnatt chart
  int *A = malloc( sum_of_burst_time * sizeof(int) );

  //index for array A
  int count=0;

  //Save the id in cells of A
  for (int i=0; i<number; i++)
  {
    //Put process id in arr[i].burst_time cells of A
    for (int j=0; j<arr[i].burst_time; j++)
    {
      A[count]=arr[i].process_id; //save id
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