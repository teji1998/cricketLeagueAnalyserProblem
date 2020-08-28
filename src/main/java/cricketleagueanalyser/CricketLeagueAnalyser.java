package cricketleagueanalyser;

import java.util.Map;

public class CricketLeagueAnalyser {

	public enum CricketerSkill { BATTING, BOWLING }
	Map<String, LeagueDAO> leagueMap;

	public int loadLeagueData( CricketerSkill cricketerSkill, String... csvFilePath ) throws CricketLeagueAnalyserException {
		leagueMap = new CricketLeagueLoader().loadLeagueData( cricketerSkill, csvFilePath );
		return leagueMap.size();
	}
}
