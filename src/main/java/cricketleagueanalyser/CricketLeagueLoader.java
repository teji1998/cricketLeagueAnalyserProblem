package cricketleagueanalyser;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class CricketLeagueLoader {

	public Map<String, LeagueDAO> loadLeagueData(CricketLeagueAnalyser.CricketerSkill cricketerSkill, String... csvFilePath) throws CricketLeagueAnalyserException {
		if (cricketerSkill.equals(CricketLeagueAnalyser.CricketerSkill.BATTING))
			return this.loadLeagueData(IPLMostRunsCSV.class, csvFilePath);
		else if (cricketerSkill.equals(CricketLeagueAnalyser.CricketerSkill.BATTING))
			return this.loadLeagueData(IPLMostWicketsCSV.class, csvFilePath);
		else throw new CricketLeagueAnalyserException("Invalid cricketer skill", CricketLeagueAnalyserException.ExceptionType.NOT_A_VALID_CRICKETER_SKILL);
	}

	public <E> Map loadLeagueData(Class<E> leagueClass, String... csvFilePath) throws CricketLeagueAnalyserException {
		Map<String, LeagueDAO> leagueMap = new HashMap<>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]));
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, leagueClass);
			Iterable<E> csvIterable = () -> csvFileIterator;
			if (leagueClass.getName().equals("cricketleagueanalyser.IPLMostRunsCSV")) {
				StreamSupport.stream(csvIterable.spliterator(), false)
						  .map(IPLMostRunsCSV.class::cast)
						  .forEach(iplRunsDataCSV -> leagueMap.put(iplRunsDataCSV.player, new LeagueDAO(iplRunsDataCSV)));
			} else if (leagueClass.getName().equals("cricketleagueanalyser.IPLMostWicketsCSV")) {
				StreamSupport.stream(csvIterable.spliterator(), false)
						  .map(IPLMostWicketsCSV.class::cast)
						  .forEach(iplWicketsCSV -> leagueMap.put(iplWicketsCSV.player, new LeagueDAO(iplWicketsCSV)));
			}
			return leagueMap;
		} catch (IOException e) {
			throw new CricketLeagueAnalyserException(e.getMessage(),
					  CricketLeagueAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		} catch (RuntimeException e) {
			throw new CricketLeagueAnalyserException(e.getMessage(),
					  CricketLeagueAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER);
		} catch (CSVBuilderException e) {
			throw new CricketLeagueAnalyserException(e.getMessage(), e.type.name());
		}
	}
}
