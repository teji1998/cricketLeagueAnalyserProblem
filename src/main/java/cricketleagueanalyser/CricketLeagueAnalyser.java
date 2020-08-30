package cricketleagueanalyser;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

	Map<String, LeagueDAO> leagueMap = new HashMap<>();

	public int loadLeagueData(IplEnumCollection.CricketerSkill cricketerSkill, String... csvFilePath)
			  throws CricketLeagueAnalyserException {
		leagueMap = new CricketLeagueLoader().loadLeagueData(cricketerSkill, csvFilePath);
		return leagueMap.size();
	}

	public String getBattingAverageWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.battingAverageComparator.reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getStrikeRateWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.battingStrikeRateComparator.reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumSixesAndFoursWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.sixAndFourComparator.reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumSixesAndFoursWithBestStrikingRateWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.sixAndFourComparator.thenComparing(IPLComparator.battingStrikeRateComparator).reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getGreatAverageWithBestStrikingRateWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.battingStrikeRateComparator.thenComparing(IPLComparator.battingAverageComparator).reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumRunsWithBestAverageWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.runsComparator.thenComparing(IPLComparator.battingAverageComparator).reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlingAverageWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.bowlingAverageComparator.reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlerEconomyRateWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.economyComparator.reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlerStrikingRateWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.bowlerStrikeRateComparator.reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getFourWicketsAndFiveWicketsWithBestStrikingRateWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.fourAndFiveWicketsComparator.thenComparing(IPLComparator.bowlerStrikeRateComparator).reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlersHavingGreatAverageWithBestStrikingRateWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.bowlingAverageComparator.thenComparing(IPLComparator.bowlerStrikeRateComparator).reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getBestBowlerAndBestBatterWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.battingAverageComparator.thenComparing(IPLComparator.bowlingAverageComparator).reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getBowlersTakingMaximumWicketsWithBestBowlingAverageWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.wicketsComparator.thenComparing(IPLComparator.bowlingAverageComparator).reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getAllRounderWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.runsComparator.thenComparing(IPLComparator.wicketsComparator).reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getMaximumHundredAndBattingAverageWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.centuryComparator.thenComparing(IPLComparator.battingAverageComparator).reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}

	public String getMinimumHundredAndMinimumFiftyWithBestBattingAverageWiseSortedIPLData() {
		List<LeagueDAO> leagueDAOList = leagueMap.values().stream()
				  .sorted(IPLComparator.minimumHalfCenturyAndCenturyComparator.thenComparing(IPLComparator.battingAverageComparator).reversed())
				  .collect(Collectors.toList());
		return new Gson().toJson(leagueDAOList);
	}
}
