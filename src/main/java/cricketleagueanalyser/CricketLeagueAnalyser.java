package cricketleagueanalyser;

import com.google.gson.Gson;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

	Map<String, LeagueDAO> leagueMap = new HashMap<>();

	public int loadLeagueData(IplEnumCollection.CricketerSkill cricketerSkill, String... csvFilePath ) throws CricketLeagueAnalyserException {
		leagueMap = new CricketLeagueLoader().loadLeagueData(cricketerSkill, csvFilePath );
		return leagueMap.size();
	}

	public String getBattingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getStrikeRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingStrikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumSixesAndFoursWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.sixes * 6 + iplFactSheet.fours * 4);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumSixesAndFoursWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> sixesAndFoursComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.sixes * 6 + iplFactSheet.fours * 4);
		Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingStrikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(sixesAndFoursComparator.thenComparing(strikingRateComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getGreatAverageWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
		Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingStrikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(strikingRateComparator.thenComparing(averageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumRunsWithBestAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
		Comparator<LeagueDAO> runsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.runs);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(runsComparator.thenComparing(averageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlerEconomyRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.economyRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlerStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingStrikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getFourWicketsAndFiveWicketsWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> fourAndFiveWicketsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.fourWicket + iplFactSheet.fiveWicket);
		Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingStrikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(fourAndFiveWicketsComparator.thenComparing(strikingRateComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlersHavingGreatAverageWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
		Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingStrikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(averageComparator.thenComparing(strikingRateComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBestBowlerAndBestBatterWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> battingAverageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
		Comparator<LeagueDAO> bowlingAverageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(battingAverageComparator.thenComparing(bowlingAverageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlersTakingMaximumWicketsWithBestBowlingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> wicketsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.wicket);
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(wicketsComparator.thenComparing(averageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getAllRounderWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> wicketsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.wicket);
		Comparator<LeagueDAO> runsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.runs);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(runsComparator.thenComparing(wicketsComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumHundredAndBattingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> centuryComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.hundred);
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(centuryComparator.thenComparing(averageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMinimumHundredAndMinimumFiftyWithBestBattingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		Comparator<LeagueDAO> minimumHalfCenturyAndCenturyComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.hundred * 100 + iplFactSheet.fifty * 50 == 0);
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(minimumHalfCenturyAndCenturyComparator.thenComparing(averageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	private static List<LeagueDAO> sortingInDescendingOrder(Comparator<LeagueDAO> iplComparator, List<LeagueDAO> iplList) throws CricketLeagueAnalyserException {
		if (iplList == null || iplList .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		for (int i = 0; i < iplList.size()-1; i++) {
			for (int j =0; j< iplList.size() -i -1; j++) {
				LeagueDAO cricketer1 = iplList.get(j);
				LeagueDAO cricketer2 = iplList.get(j+1);
				if (iplComparator.compare(cricketer1, cricketer2) < 0){
					iplList.set(j, cricketer2);
					iplList.set(j+1, cricketer1);
				}
			}
		}
		return iplList;
	}
}
