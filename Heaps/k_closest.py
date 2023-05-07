class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        min_heap = []
        
        # For each point, find distance from origin
        for x,y in points:
            dist = sqrt(x**2 + y**2)
            min_heap.append([dist,x,y])
            
        # Pop 'k' smallest distances 
        heapify(min_heap)
        res = []
        for _ in range(k):
            _,x,y = heappop(min_heap)
            res.append([x,y])
            
        return res