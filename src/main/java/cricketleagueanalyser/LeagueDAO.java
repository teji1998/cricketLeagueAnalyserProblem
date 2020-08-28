package cricketleagueanalyser;

public class LeagueDAO {
	public int pos;
	public String player;
	public int matches;
	public int innings;
	public int no;
	public int runs;
	public int highScore;
	public double average;
	public int bf;
	public double strikeRate;
	public int centuries;
	public int halfCenturies;
	public int fours;
	public int sixes;
	public double overs;
	public int wickets;
	public double bowlingAverage;
	public int bbi;
	public double economy;
	public double sr;
	public int fourWickets;
	public int fiveWickets;

	public LeagueDAO(IPLMostRunsCSV iplMostRunsCSV) {
		pos = iplMostRunsCSV.pos;
		player = iplMostRunsCSV.player;
		matches = iplMostRunsCSV.matches;
		innings = iplMostRunsCSV.innings;
		no = iplMostRunsCSV.no;
		runs = iplMostRunsCSV.runs;
		highScore = iplMostRunsCSV.highScore;
		average = iplMostRunsCSV.average;
		bf = iplMostRunsCSV.bf;
		strikeRate = iplMostRunsCSV.strikeRate;
		centuries = iplMostRunsCSV.centuries;
		halfCenturies = iplMostRunsCSV.halfCenturies;
		fours = iplMostRunsCSV.fours;
		sixes = iplMostRunsCSV.sixes;
	}

	public LeagueDAO(IPLMostWicketsCSV iplMostWicketsCSV) {
		pos = iplMostWicketsCSV.pos;
		player = iplMostWicketsCSV.player;
		matches = iplMostWicketsCSV.matches;
		innings = iplMostWicketsCSV.innings;
		overs = iplMostWicketsCSV.overs;
		runs = iplMostWicketsCSV.runs;
		wickets = iplMostWicketsCSV.wickets;
		bbi = iplMostWicketsCSV.bbi;
		bowlingAverage = iplMostWicketsCSV.bowlingAverage;
		economy = iplMostWicketsCSV.economy;
		sr = iplMostWicketsCSV.sr;
		fourWickets = iplMostWicketsCSV.fourWickets;
		fiveWickets = iplMostWicketsCSV.fiveWickets;
	}
}
