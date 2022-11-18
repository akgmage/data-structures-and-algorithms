/*
  There's an algorithms tournament taking place in which teams of programmers
  compete against each other to solve algorithmic problems as fast as possible.
  Teams compete in a round robin, where each team faces off against all other
  teams. Only two teams compete against each other at a time, and for each
  competition, one team is designated the home team, while the other team is the
  away team. In each competition there's always one winner and one loser; there
  are no ties. A team receives 3 points if it wins and 0 points if it loses. The
  winner of the tournament is the team that receives the most amount of points.

  Given an array of pairs representing the teams that have competed against each
  other and an array containing the results of each competition, write a
  function that returns the winner of the tournament. The input arrays are named
  competitions and results, respectively. The competitions  array has elements in the
  form of [homeTeam, awayTeam], where each team is a string of at most 30
  characters representing the name of the team.


*/
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