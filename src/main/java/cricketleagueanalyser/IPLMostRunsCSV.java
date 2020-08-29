package cricketleagueanalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRunsCSV {

	@CsvBindByName(column = "PLAYER", required = true)
	public String player;

	@CsvBindByName(column = "Avg", required = true)
	public double averageRun;

	@CsvBindByName(column = "SR", required = true)
	public double strikeRate;

	@CsvBindByName(column = "4s", required = true)
	public int fours;

	@CsvBindByName(column = "6s", required = true)
	public int sixes;

	@CsvBindByName(column = "Runs", required = true)
	public int runs;

	@CsvBindByName(column = "100", required = true)
	public int hundred;

	@CsvBindByName(column = "50", required = true)
	public int fifty;

	@Override
	public String toString() {
		return "IPLMostRunCSV{" +
				  "player='" + player + '\'' +
				  ", averageRun=" + averageRun +
				  ", strikeRate=" + strikeRate +
				  ", fours=" + fours +
				  ", sixes=" + sixes +
				  ", runs=" + runs +
				  ", hundred=" + hundred +
				  ", fifty=" + fifty +
				  '}';
	}
}

