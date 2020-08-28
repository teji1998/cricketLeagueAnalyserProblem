package cricketleagueanalyser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyserTest {
	private static final String IPL_MOST_RUN_CENSUS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
	private static final String IPL_MOST_WICKETS_CENSUS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWickets.csv";

	//Test case to check number of record in IPL most runs CSV file
	@Test
	public void givenIPLMostRunsCSVFileReturnsCorrectRecords() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			int numberOfRecords = cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BATTING, IPL_MOST_RUN_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(100,numberOfRecords);
		} catch (CricketLeagueAnalyserException e) { }
	}

	//Test case to check number of record in IPL most wickets CSV file
	@Test
	public void givenIPLMostWicketsCSVFileReturnsCorrectRecords() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			int numOfRecords = cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(99,numOfRecords);
		} catch (CricketLeagueAnalyserException e) { }
	}

	// Test case for finding the Batting average in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedByBattingAverage_shouldReturnSortedResult() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BATTING, IPL_MOST_RUN_CENSUS_CSV_FILE_PATH);
			String sortedIPLData = cricketLeagueAnalyser.getBattingAverageWiseSortedIPLData();
			IPLMostRunsCSV[] iplCSV =  new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
			Assert.assertEquals("MS Dhoni", iplCSV[0].player);
		} catch (CricketLeagueAnalyserException e ) { }
	}

	// Test case for finding the Strike Rate in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedByStrikeRate_shouldReturnSortedResult() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BATTING, IPL_MOST_RUN_CENSUS_CSV_FILE_PATH);
			String sortedIPLData = cricketLeagueAnalyser.getStrikeRateAverageWiseSortedIPLData();
			IPLMostRunsCSV[] iplCSV =  new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
			Assert.assertEquals("Ishant Sharma", iplCSV[0].player);
		} catch (CricketLeagueAnalyserException e ) { }
	}

}

