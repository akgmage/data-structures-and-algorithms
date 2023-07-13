package main

func OneEdit(stringOne string, stringTwo string) bool {
	lengthOne := len(stringOne)
	lengthTwo := len(stringTwo)
	if abs(lengthOne-lengthTwo) > 1 {
		return false
	}
	for i := 0; i < min(lengthOne, lengthTwo); i++ {
		if stringOne[i] != stringTwo[i] {
			if lengthOne > lengthTwo {
				return stringOne[i+1:] == stringTwo[i:]
			} else if lengthTwo > lengthOne {
				return stringTwo[i+1:] == stringOne[i:]
			} else {
				return stringOne[i+1:] == stringTwo[i+1:]
			}
		}
	}
	return true
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
