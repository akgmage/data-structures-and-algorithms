package main

import "fmt"

const HOME_TEAM_WON = 1
const AWAY_TEAM_WON = 0

func TournamentWinner(competitions [][]string, results []int) string {
	// Write your code here.
	mp := make(map[string]int)
	winner := ""
	max := 0
	for i := 0; i < len(results); i++ {
		if results[i] == HOME_TEAM_WON {
			mp[competitions[i][0]]++
			if mp[competitions[i][0]] > max {
				max = mp[competitions[i][0]]
				winner = competitions[i][0]
			}
		} else {
			mp[competitions[i][1]]++
			if mp[competitions[i][1]] > max {
				max = mp[competitions[i][1]]
				winner = competitions[i][1]
			}
		}
	}
	return winner
}

func main() {
	competitions := [][]string{{"HTML", "C#"}, {"C#", "Python"}, {"Python", "HTML"}}
	result := []int{0, 0, 1}
	msg := TournamentWinner(competitions, result)
	fmt.Println(msg)

}