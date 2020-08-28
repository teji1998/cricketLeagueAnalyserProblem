package cricketleagueanalyser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyserTest {
	private static final String IPL_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
	private static final String IPL_MOST_WICKETS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWickets.csv";

	//Test case to check number of record in IPL most runs CSV file
	@Test
	public void givenIPLMostRunsCSVFileReturnsCorrectRecords() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			int numberOfRecords = cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
			Assert.assertEquals(100,numberOfRecords);
		} catch (CricketLeagueAnalyserException e) { }
	}

	//Test case to check number of record in IPL most wickets CSV file
	@Test
	public void givenIPLMostWicketsCSVFileReturnsCorrectRecords() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			int numOfRecords = cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
			Assert.assertEquals(99,numOfRecords);
		} catch (CricketLeagueAnalyserException e) { }
	}

	// Test case for finding the Batting average in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedByBattingAverage_shouldReturnSortedResult() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
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
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
			String sortedIPLData = cricketLeagueAnalyser.getStrikeRateWiseSortedIPLData();
			IPLMostRunsCSV[] iplCSV =  new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
			Assert.assertEquals("Ishant Sharma", iplCSV[0].player);
		} catch (CricketLeagueAnalyserException e ) { }
	}

	// Test case for finding the maximum sixes and fours in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedBySixesAndFours_shouldReturnSortedResult() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
			String sortedIPLData = cricketLeagueAnalyser.getMaximumSixesAndFoursWiseSortedIPLData();
			IPLMostRunsCSV[] iplCSV =  new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
			Assert.assertEquals("Andre Russell", iplCSV[0].player);
		} catch (CricketLeagueAnalyserException e ) { }
	}

	// Test case for finding the maximum sixes and fours with top striking rate in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedBySixesAndFoursWithStrikingRate_shouldReturnSortedResult() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
			String sortedIPLData = cricketLeagueAnalyser.getMaximumSixesAndFoursWithBestStrikingRateWiseSortedIPLData();
			IPLMostRunsCSV[] iplCSV =  new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
			Assert.assertEquals("Andre Russell", iplCSV[0].player);
		} catch (CricketLeagueAnalyserException e ) { }
	}

	// Test case for finding the top striking rate with great average in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedByBestStrikingRateWithGreatAverage_shouldReturnSortedResult() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
			String sortedIPLData = cricketLeagueAnalyser.getGreatAverageWithBestStrikingRateWiseSortedIPLData();
			IPLMostRunsCSV[] iplCSV =  new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
			Assert.assertEquals("Ishant Sharma", iplCSV[0].player);
		} catch (CricketLeagueAnalyserException e ) { }
	}

	// Test case for finding the maximum runs with great average in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedByMaximumRunsWithGreatAverage_shouldReturnSortedResult() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
			String sortedIPLData = cricketLeagueAnalyser.getMaximumRunsWithBestAverageWiseSortedIPLData();
			IPLMostRunsCSV[] iplCSV =  new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
			Assert.assertEquals("David Warner", iplCSV[0].player);
		} catch (CricketLeagueAnalyserException e ) { }
	}

	// Test case for finding the top bowling average in descending order
	@Test
	public void givenMostWicketsCSVFile_whenSortedByBowlingAverage_shouldReturnSortedResult() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
			String sortedIPLData = cricketLeagueAnalyser.getBowlingAverageWiseSortedIPLData();
			IPLMostWicketsCSV[] iplCSV =  new Gson().fromJson(sortedIPLData, IPLMostWicketsCSV[].class);
			Assert.assertEquals("Krishnappa Gowtham", iplCSV[0].player);
		} catch (CricketLeagueAnalyserException e ) { }
	}

	// Test case for finding the top bowling striking rate in descending order
	@Test
	public void givenMostWicketsCSVFile_whenSortedByStrikingRate_shouldReturnSortedResult() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
			String sortedIPLData = cricketLeagueAnalyser.getBowlerStrikingRateWiseSortedIPLData();
			IPLMostWicketsCSV[] iplCSV =  new Gson().fromJson(sortedIPLData, IPLMostWicketsCSV[].class);
			Assert.assertEquals("Krishnappa Gowtham", iplCSV[0].player);
		} catch (CricketLeagueAnalyserException e ) { }
	}

	// Test case for finding the top bowling economy rate in descending order
	@Test
	public void givenMostWicketsCSVFile_whenSortedByEconomyRate_shouldReturnSortedResult() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
			String sortedIPLData = cricketLeagueAnalyser.getBowlerEconomyRateWiseSortedIPLData();
			IPLMostWicketsCSV[] iplCSV =  new Gson().fromJson(sortedIPLData, IPLMostWicketsCSV[].class);
			Assert.assertEquals("Ben Cutting", iplCSV[0].player);
		} catch (CricketLeagueAnalyserException e ) { }
	}

	// Test case for finding the top bowler having four and five wickets with best striking rates
	@Test
	public void givenMostWicketsCSVFile_whenSortedByFourAndFiveWicketsWithBestStrikingRate_shouldReturnSortedResult() {
		try {
			CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
			cricketLeagueAnalyser.loadLeagueData(CricketLeagueAnalyser.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
			String sortedIPLData = cricketLeagueAnalyser.getFourWicketsAndFiveWicketsWithBestStrikingRateWiseSortedIPLData();
			IPLMostWicketsCSV[] iplCSV =  new Gson().fromJson(sortedIPLData, IPLMostWicketsCSV[].class);
			Assert.assertEquals("Lasith Malinga", iplCSV[0].player);
		} catch (CricketLeagueAnalyserException e ) { }
	}
}

