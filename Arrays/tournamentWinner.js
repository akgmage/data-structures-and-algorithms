//? https://www.algoexpert.io/questions/Tournament%20Winner
//! O(n) time | O(k) space , k is the number of teams
const HOME_TEAM_WON = 1;

function tournamentWinner(competitions, results) {
	// let currentBestTeam = ''; 
	// const scores = {[currentBestTeam]: 0};
	// console.log(scores);
	  const scores = {};
  	  let currentBestTeam = '';
  	  scores[currentBestTeam] = 0;

	for(let i = 0; i < competitions.length; i++) {
		let [homeTeam, awayTeam] = competitions[i];
		let result = results[i];
		const winningTeam = result == HOME_TEAM_WON ? homeTeam : awayTeam;

		updateScores(winningTeam, 3, scores);

		if(scores[winningTeam] > scores[currentBestTeam])  {
			currentBestTeam = winningTeam;
		}
	}
	console.log(scores);
	console.log(currentBestTeam);
	 return currentBestTeam;
}

function updateScores(team, points, scores) {
	if(!(team in scores)) {
		scores[team] = 0;
	}
	scores[team] += points;
}

const competitions = [
	["HTML", "C#"],
	["C#", "Python"],
	["Python", "HTML"]
]
const results = [0, 0, 1];


console.log(tournamentWinner(competitions, results));