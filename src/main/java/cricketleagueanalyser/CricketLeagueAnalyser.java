package cricketleagueanalyser;

import com.google.gson.Gson;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

	public enum CricketerSkill { BATTING, BOWLING }
	Map<String, LeagueDAO> leagueMap;

	public int loadLeagueData( CricketerSkill cricketerSkill, String... csvFilePath ) throws CricketLeagueAnalyserException {
		leagueMap = new CricketLeagueLoader().loadLeagueData( cricketerSkill, csvFilePath );
		return leagueMap.size();
	}

	public String getBattingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.average);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getStrikeRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.strikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumSixesAndFoursWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.sixes * 6 + iplFactSheet.fours * 4);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumSixesAndFoursWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> sixesAndFoursComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.sixes * 6 + iplFactSheet.fours * 4);
		Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.strikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(sixesAndFoursComparator.thenComparing(strikingRateComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getGreatAverageWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.average);
		Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.strikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(strikingRateComparator.thenComparing(averageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumRunsWithBestAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.average);
		Comparator<LeagueDAO> runsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.runs);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(runsComparator.thenComparing(averageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap  == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlerEconomyRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.economy);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlerStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.strikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getFourWicketsAndFiveWicketsWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> fourAndFiveWicketsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.fourWickets + iplFactSheet.fiveWickets);
		Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.strikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(fourAndFiveWicketsComparator.thenComparing(strikingRateComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlersHavingGreatAverageWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
		Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.strikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(averageComparator.thenComparing(strikingRateComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBestBowlerAndBestBatterWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> battingAverageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.average);
		Comparator<LeagueDAO> bowlingAverageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(battingAverageComparator.thenComparing(bowlingAverageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlersTakingMaximumWicketsWithBestBowlingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> wicketsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.wickets);
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(wicketsComparator.thenComparing(averageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getAllRounderWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> wicketsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.wickets);
		Comparator<LeagueDAO> runsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.runs);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(runsComparator.thenComparing(wicketsComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumHundredAndBattingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> centuryComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.centuries);
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.average);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(centuryComparator.thenComparing(averageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMinimumHundredAndMinimumFiftyWithBestBattingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Cricket Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> minimumHalfCenturyAndCenturyComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.centuries * 100 + iplFactSheet.halfCenturies * 50 == 0);
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.average);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(minimumHalfCenturyAndCenturyComparator.thenComparing(averageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	private static List<LeagueDAO> sortingInDescendingOrder(Comparator<LeagueDAO> iplComparator, List<LeagueDAO> iplList) {
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

