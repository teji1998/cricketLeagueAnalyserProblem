package cricketleagueanalyser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CricketLeagueAnalyserTest {

	public CricketLeagueAnalyser cricketLeagueAnalyser;

	private static final String IPL_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
	private static final String IPL_MOST_WICKETS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWickets.csv";

	@Before
	public void initialSetUp() {
		cricketLeagueAnalyser = new CricketLeagueAnalyser();
	}

	//Test case to check number of record in IPL most runs CSV file
	@Test
	public void givenIPLMostRunsCSVFile_whenCheckedForRecords_shouldReturnCorrectRecords() throws CricketLeagueAnalyserException {
		int numberOfRecords = cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
		Assert.assertEquals(100,numberOfRecords);
	}

	//Test case to check number of record in IPL most runs CSV file
	@Test
	public void givenIPLMostRunsCSVFile_whenCheckedForRecords_shouldReturnIncorrectRecords() throws CricketLeagueAnalyserException {
		int numberOfRecords = cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
		Assert.assertNotEquals(10,numberOfRecords);
	}

	//Test case to check number of correct records in IPL most wickets CSV file
	@Test
	public void givenIPLMostWicketsCSVFile_whenCheckedForRecords_shouldReturnCorrectRecords() throws CricketLeagueAnalyserException {
		int numOfRecords = cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
		Assert.assertEquals(99,numOfRecords);
	}

	//Test case to check number of incorrect records in IPL most wickets CSV file
	@Test
	public void givenIPLMostWicketsCSVFile_whenCheckedForRecords_shouldReturnIncorrectRecords() throws CricketLeagueAnalyserException {
		int numOfRecords = cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
		Assert.assertNotEquals(546,numOfRecords);
	}

	// Test case for finding the Batting average in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedByBattingAverage_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getBattingAverageWiseSortedIPLData();
		IPLMostRunsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
		Assert.assertEquals("MS Dhoni", iplCSV[0].player);
	}

	// Test case for finding the Strike Rate in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedByStrikeRate_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getStrikeRateWiseSortedIPLData();
		IPLMostRunsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
		Assert.assertEquals("Ishant Sharma", iplCSV[0].player);
	}

	// Test case for finding the maximum sixes and fours in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedBySixesAndFours_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getMaximumSixesAndFoursWiseSortedIPLData();
		IPLMostRunsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
		Assert.assertEquals("Andre Russell", iplCSV[0].player);
	}

	// Test case for finding the maximum sixes and fours with top striking rate in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedBySixesAndFoursWithStrikingRate_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getMaximumSixesAndFoursWithBestStrikingRateWiseSortedIPLData();
		IPLMostRunsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
		Assert.assertEquals("Andre Russell", iplCSV[0].player);
	}

	// Test case for finding the top striking rate with great average in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedByBestStrikingRateWithGreatAverage_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getGreatAverageWithBestStrikingRateWiseSortedIPLData();
		IPLMostRunsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
		Assert.assertEquals("Ishant Sharma", iplCSV[0].player);
	}

	// Test case for finding the maximum runs with great average in descending order
	@Test
	public void givenMostRunsCSVFile_whenSortedByMaximumRunsWithGreatAverage_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getMaximumRunsWithBestAverageWiseSortedIPLData();
		IPLMostRunsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
		Assert.assertEquals("David Warner", iplCSV[0].player);
	}

	// Test case for finding the top bowling average in descending order
	@Test
	public void givenMostWicketsCSVFile_whenSortedByBowlingAverage_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getBowlingAverageWiseSortedIPLData();
		IPLMostWicketsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostWicketsCSV[].class);
		Assert.assertEquals("Krishnappa Gowtham", iplCSV[0].player);
	}

	// Test case for finding the top bowling striking rate in descending order
	@Test
	public void givenMostWicketsCSVFile_whenSortedByStrikingRate_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getBowlerStrikingRateWiseSortedIPLData();
		IPLMostWicketsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostWicketsCSV[].class);
		Assert.assertEquals("Krishnappa Gowtham", iplCSV[0].player);
	}

	// Test case for finding the top bowling economy rate in descending order
	@Test
	public void givenMostWicketsCSVFile_whenSortedByEconomyRate_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getBowlerEconomyRateWiseSortedIPLData();
		IPLMostWicketsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostWicketsCSV[].class);
		Assert.assertEquals("Ben Cutting", iplCSV[0].player);
	}

	// Test case for finding the top bowler having four and five wickets with best striking rates
	@Test
	public void givenMostWicketsCSVFile_whenSortedByFourAndFiveWicketsWithBestStrikingRate_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getFourWicketsAndFiveWicketsWithBestStrikingRateWiseSortedIPLData();
		IPLMostWicketsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostWicketsCSV[].class);
		Assert.assertEquals("Lasith Malinga", iplCSV[0].player);
	}

	// Test case for finding the top bowler great average with best striking rates
	@Test
	public void givenMostWicketsCSVFile_whenSortedByAverageWithBestStrikingRate_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getBowlersHavingGreatAverageWithBestStrikingRateWiseSortedIPLData();
		IPLMostWicketsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostWicketsCSV[].class);
		Assert.assertEquals("Krishnappa Gowtham", iplCSV[0].player);
	}

	// Test case for finding the bowler with maximum wickets with great average rates
	@Test
	public void givenMostWicketsCSVFile_whenSortedByWicketsWithBestAverageWise_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getBowlersTakingMaximumWicketsWithBestBowlingAverageWiseSortedIPLData();
		IPLMostWicketsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostWicketsCSV[].class);
		Assert.assertEquals("Imran Tahir", iplCSV[0].player);
	}

	// Test case for finding cricketer with best bowling average and batting average
	@Test
	public void givenMostRunsCSVFile_whenSortedByBowlingAndBattingAverageWise_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH, IPL_MOST_WICKETS_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getBestBowlerAndBestBatterWiseSortedIPLData();
		IPLMostRunsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
		Assert.assertEquals("MS Dhoni", iplCSV[0].player);
	}

	//To find all rounder
	@Test
	public void givenMostRunsCSVFile_whenSortedByRunsAndWicketWise_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH, IPL_MOST_WICKETS_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getAllRounderWiseSortedIPLData();
		IPLMostRunsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
		Assert.assertEquals("David Warner", iplCSV[0].player);
	}

	//To check cricketers with maximum hundred and best batting average
	@Test
	public void givenMostRunsCSVFile_whenSortedByMaximumHundredAndBestBattingAverageWise_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getMaximumHundredAndBattingAverageWiseSortedIPLData();
		IPLMostRunsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
		Assert.assertEquals("David Warner", iplCSV[0].player);
	}

	//To check cricketers with minimum hundreds and fifty and best batting average
	@Test
	public void givenMostRunsCSVFile_whenSortedByMinimumHundredsAndFiftyAndBestBattingAverageWise_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
		cricketLeagueAnalyser.loadLeagueData(IplEnumCollection.CricketerSkill.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
		String sortedIPLData = cricketLeagueAnalyser.getMinimumHundredAndMinimumFiftyWithBestBattingAverageWiseSortedIPLData();
		IPLMostRunsCSV[] iplCSV = new Gson().fromJson(sortedIPLData, IPLMostRunsCSV[].class);
		Assert.assertEquals("Marcus Stoinis", iplCSV[0].player);
	}
}
