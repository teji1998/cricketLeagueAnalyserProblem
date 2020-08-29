package cricketleagueanalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWicketsCSV{

		@CsvBindByName(column = "PLAYER", required = true)
		public String player;

		@CsvBindByName(column = "Avg", required = true)
		public double bowlingAverage;

		@CsvBindByName(column = "SR", required = true)
		public double strikeRate;

		@CsvBindByName(column = "Econ", required = true)
		public double economyRate;

		@CsvBindByName(column = "4w", required = true)
		public int fourWicket;

		@CsvBindByName(column = "5w", required = true)
		public int fiveWicket;

		@CsvBindByName(column = "Wkts", required = true)
		public int wicket;

		@Override
		public String toString() {
			return "IPLMostWicketsCSV{" +
					  "player='" + player + '\'' +
					  ", bowlingAverage=" + bowlingAverage +
					  ", strikeRate=" + strikeRate +
					  ", economyRate=" + economyRate +
					  ", fourWicket=" + fourWicket +
					  ", fiveWicket=" + fiveWicket +
					  ", wicket=" + wicket +
					  '}';
		}
	}
