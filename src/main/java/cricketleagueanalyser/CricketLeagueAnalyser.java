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
		if (leagueMap  == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.average);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getStrikeRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap  == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.strikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumSixesAndFoursWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap  == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> iplComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.sixes * 6 + iplFactSheet.fours * 4);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(iplComparator, leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumSixesAndFoursWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap  == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> sixesAndFoursComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.sixes * 6 + iplFactSheet.fours * 4);
		Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.strikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(sixesAndFoursComparator.thenComparing(strikingRateComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}

	public String getGreatAverageWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
		if (leagueMap  == null || leagueMap .size() == 0) {
			throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CRICKET_DATA);
		}
		Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.average);
		Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.strikeRate);
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream().collect(Collectors.toList());
		leagueDAOList = sortingInDescendingOrder(strikingRateComparator.thenComparing(averageComparator), leagueDAOList);
		return new Gson().toJson(leagueDAOList);
	}



	private static <LeagueDAO> List<LeagueDAO> sortingInDescendingOrder(Comparator<LeagueDAO> iplComparator, List<LeagueDAO> iplList) {
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

