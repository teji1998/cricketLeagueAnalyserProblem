package cricketleagueanalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWicketsCSV {

	@CsvBindByName(column = "POS", required = true)
	public int pos;

	@CsvBindByName(column = "PLAYER", required = true)
	public String player;

	@CsvBindByName(column = "Mat", required = true)
	public int matches;

	@CsvBindByName(column = "Inns", required = true)
	public int innings;

	@CsvBindByName(column = "Ov", required = true)
	public double overs;

	@CsvBindByName(column = "Runs", required = true)
	public int runs;

	@CsvBindByName(column = "Wkts", required = true)
	public int wickets;

	@CsvBindByName(column = "BBI", required = true)
	public int bbi;

	@CsvBindByName(column = "Avg", required = true)
	public double bowlingAverage;

	@CsvBindByName(column = "Econ", required = true)
	public double economy;

	@CsvBindByName(column = "SR", required = true)
	public double sr;

	@CsvBindByName(column = "4w", required = true)
	public int fourWickets;

	@CsvBindByName(column = "5w", required = true)
	public int fiveWickets;

	@Override
	public String toString() {
		return "IPLMostWicketsCSV{" +
				  "pos=" + pos +
				  ", player='" + player + '\'' +
				  ", matches=" + matches +
				  ", innings=" + innings +
				  ", overs=" + overs +
				  ", runs=" + runs +
				  ", wickets=" + wickets +
				  ", bbi=" + bbi +
				  ", bowlingAverage=" + bowlingAverage +
				  ", economy=" + economy +
				  ", SR=" + sr +
				  ", fourWickets=" + fourWickets +
				  ", fiveWickets=" + fiveWickets +
				  '}';
	}
}

