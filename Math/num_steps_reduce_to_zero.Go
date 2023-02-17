func numberOfSteps(num int) int {
    var steps = 0
    for num != 0 {
        if num % 2 == 0 {
            num /= 2
            steps++
        } else {
            num -= 1
            steps++
        }
    }
    return steps
}
