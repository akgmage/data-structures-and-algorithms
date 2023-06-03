<?php  
  
function getMax($a, $n) {  
  $max = $a[0];  
  for($i = 1; $i < $n; $i++) {  
      if($a[$i] > $max)  
         $max = $a[$i];  
  }  
  return $max; //maximum element from the array  
}  
  
function countSort(&$a, $n) // function to perform counting sort  
{  
    $LeftArray = array($n + 1);  
   $max = getMax($a, $n);  
   $count = array($max + 1); //create count array with size [max+1]  
  
  for ($i = 0; $i <= $max; ++$i)   
  {  
    $count[$i] = 0; // Initialize count array with all zeros  
  }  
    
  for ($i = 0; $i < $n; $i++) // Store the count of each element  
  {  
    $count[$a[$i]]++;  
  }  
  
   for($i = 1; $i<=$max; $i++)   
      $count[$i] += $count[$i-1]; //find cumulative frequency  
  
  /* This loop will find the index of each element of the original array in    
count array, and  
   place the elements in output array*/  
  for ($i = $n - 1; $i >= 0; $i--) {  
    $output[$count[$a[$i]] - 1] = $a[$i];  
    $count[$a[$i]]--; // decrease count for same numbers  
}  
  
   for($i = 0; $i<$n; $i++) {  
      $a[$i] = $output[$i]; //store the sorted elements into main array  
   }  
}  
  
/* Function to print the array elements */  
function printArray($a, $n)  
{  
    for($i = 0; $i < $n; $i++)    
    {    
        print_r($a[$i]);    
        echo " ";    
    }        
}  
  
    $a = array( 9, 28, 22, 5, 29, 14, 37, 28, 9 );    
    $n = count($a);  
    echo "Before sorting array elements are - <br>";    
    printArray($a, $n);  
    countSort($a,$n);  
    echo "<br> After sorting array elements are - <br>";    
    printArray($a, $n);  
  
?>  