def DiskStacking(disks):
    # Sort the disks based on their height
    disks.sort(key=lambda x: x[2])
    
    # Initialize arrays to store heights and sequences
    heights = [disk[2] for disk in disks]  # Heights of each disk
    sequences = [-1 for _ in disks]  # Index sequence for each disk
    
    # Loop through each disk and calculate the maximum height
    for i in range(1, len(disks)):
        current_disk = disks[i]
        for j in range(i):
            other_disk = disks[j]
            # Check if the dimensions of the other_disk are valid for stacking
            if are_valid_dimensions(other_disk, current_disk):
                # Update the height and sequence if the condition is met
                if heights[i] <= current_disk[2] + heights[j]:
                    heights[i] = current_disk[2] + heights[j]
                    sequences[i] = j
    
    # Find the index of the maximum height
    max_index = heights.index(max(heights))
    
    # Build and return the sequence of disks for the maximum height
    sequence = build_sequence(disks, sequences, max_index)
    return sequence

def are_valid_dimensions(other_disk, current_disk):
    # Check if the dimensions of other_disk allow current_disk to be stacked on top
    return other_disk[0] < current_disk[0] and other_disk[1] < current_disk[1] and other_disk[2] < current_disk[2]

def build_sequence(disks, sequences, index):
    sequence = []
    # Build the sequence of disks for the maximum height
    while index != -1:
        sequence.append(disks[index])
        index = sequences[index]
    sequence.reverse()  # Reverse the sequence to maintain the correct order
    return sequence
