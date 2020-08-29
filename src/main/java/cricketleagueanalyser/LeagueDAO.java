package cricketleagueanalyser;

public class LeagueDAO {


	public double bowlerStrikeRate;
	public int fifty;
	public int hundred;
	public int wicket;
	public int fiveWicket;
	public int fourWicket;
	public double economyRate;
	public double bowlingAverage;
	public int runs;
	public int fours;
	public int sixes;
	public double battingStrikeRate;
	public String player;
	public double battingAverage;

	public LeagueDAO(IPLMostRunsCSV iplMostRunsCSV) {
		player = iplMostRunsCSV.player;
		battingAverage = iplMostRunsCSV.averageRun;
		battingStrikeRate = iplMostRunsCSV.strikeRate;
		fours = iplMostRunsCSV.fours;
		sixes = iplMostRunsCSV.sixes;
		runs = iplMostRunsCSV.runs;
		hundred = iplMostRunsCSV.hundred;
		fifty = iplMostRunsCSV.fifty;
	}

	public LeagueDAO(IPLMostWicketsCSV iplMostWicketsCSV){
		player = iplMostWicketsCSV.player;
		bowlingAverage = iplMostWicketsCSV.bowlingAverage;
		bowlerStrikeRate = iplMostWicketsCSV.strikeRate;
		economyRate = iplMostWicketsCSV.economyRate;
		fourWicket = iplMostWicketsCSV.fourWicket;
		fiveWicket = iplMostWicketsCSV.fiveWicket;
		wicket = iplMostWicketsCSV.wicket;
	}

	@Override
	public String toString() {
		return "FactSheetDAO{" +
				  "fifty=" + fifty +
				  ", hundred=" + hundred +
				  ", wicket=" + wicket +
				  ", fiveWicket=" + fiveWicket +
				  ", fourWicket=" + fourWicket +
				  ", economyRate=" + economyRate +
				  ", bowlingAverage=" + bowlingAverage +
				  ", runs=" + runs +
				  ", fours=" + fours +
				  ", sixes=" + sixes +
				  ", strikeRate=" + battingStrikeRate +
				  ", player='" + player + '\'' +
				  ", battingAverage=" + battingAverage +
				  '}';
	}
}