/*
The Shortest Remaining Time First (SRTF) scheduling algorithm is a preemptive scheduling algorithm that is an extension of the Shortest Job First (SJF) algorithm. SRTF selects the process with the shortest remaining burst time for execution. If a new process arrives with a shorter burst time than the currently executing process, the CPU is preempted, and the new process is executed. SRTF aims to minimize the waiting time for processes.

Algorithm Description:

When a process enters the ready queue, the scheduler compares its burst time with the remaining burst times of all other processes in the queue.

The process with the shortest remaining burst time is selected to run. If two processes have the same shortest remaining time, the one that arrived first is chosen.

The selected process runs on the CPU for a time quantum or until it completes its execution, enters a waiting state (e.g., I/O operation), or a process with a shorter remaining time arrives.

If a new process with a shorter remaining time arrives while another process is executing, the CPU scheduler preempts the currently executing process and allows the new process to run.

This process of selecting and executing processes continues until all processes have completed.

Example:
Let's use your example with three processes: P1, P2, and P3, with arrival times and burst times as follows:

Process P1: Arrival time = 0 ms, Burst time = 7 ms
Process P2: Arrival time = 2 ms, Burst time = 3 ms
Process P3: Arrival time = 4 ms, Burst time = 8 ms
Here's how SRTF will schedule and execute these processes:

Initially, the ready queue is empty.

Process P1 arrives first, so it is added to the ready queue:

Ready Queue: [P1]
P1 has the shortest remaining burst time (7 ms), so it is selected to run:

Execution: P1 (7 ms)
Ready Queue: []
Process P2 arrives next, with a shorter burst time than P1, so it preempts the execution of P1:

Ready Queue: [P1]
Execution: P2 (3 ms)
Ready Queue: [P1]
P2 completes its execution, and P1 resumes because it has the shortest remaining burst time:

Execution: P1 (4 ms)
Ready Queue: []
Finally, process P3 arrives and is added to the ready queue:

Ready Queue: [P3]
P1 has the shortest remaining burst time (4 ms), so it continues to run:

Execution: P1 (4 ms)
Ready Queue: [P3]

Process P1 has a shorter remaining burst time (4 ms vs. 8 ms), so it preempts the execution of P3:

Ready Queue: [P3]
Execution: P1 (4 ms)
Ready Queue: [P3]
P1 completes its execution, and P3 resumes because it has the shortest remaining burst time:

Execution: P3 (8 ms)
Ready Queue: []

The order of execution in SRTF is P1 -> P2 -> P1 -> P3. SRTF provides optimal turnaround times but may suffer from frequent context switches due to its preemptive nature.
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
  for (int i=0; i<number; i++)
  {
    for (int j=0; j<number; j++)
    {
      //if shorter swap
      if (arr[i].arrival_time < arr[j].arrival_time)
      {
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
  }

  //Variable for the sum of burst time 
  int sum_of_burst_time=0;

  //Calculate sum of burst time
  for (int i=0; i<number; i++)
  {
    sum_of_burst_time=sum_of_burst_time+arr[i].burst_time;
  }

  //Create an array to save the processesfor gnatt chart
  int *A = malloc( sum_of_burst_time * sizeof(int) );

  //Variables for minimum position,time and "completed" which check if processes are completed
  int min_position;
  int time=0;
  int completed=0;

  //Dont stop until completed=n
  while (completed!=number)
  {
    int min=1000; //Set minimum a high number 
    
    //Find minimum and minimum position
    for (int i=0; i<number; i++)
    {
      
      if (arr[i].burst_time<min && arr[i].burst_time!=0 && arr[i].arrival_time<=time)
      {
        
        min = arr[i].burst_time;
        min_position=i;
        
      }
      
    }

    //Save the id in a cell of A
    A[time]=arr[min_position].process_id;

    //Decrease burst time of minimum 
    arr[min_position].burst_time--;

    //If a process is finished increase "completed"
    if (arr[min_position].burst_time==0)
    {
      completed++;
    }

    //Increase time
    time++;
    
  }

  //Print A (Gnatt chart)
  for (int i=0; i<sum_of_burst_time; i++)
  {
    printf("%d\n",A[i]);
  }


    return 0; 
}