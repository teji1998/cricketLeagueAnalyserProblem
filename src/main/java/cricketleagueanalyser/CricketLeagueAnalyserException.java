package cricketleagueanalyser;

public class CricketLeagueAnalyserException extends Exception {
	enum ExceptionType {
		CENSUS_FILE_PROBLEM,
		INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER,
		NO_CRICKET_DATA,
		NOT_A_VALID_CRICKETER_SKILL
	}

	ExceptionType type;

	public CricketLeagueAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public CricketLeagueAnalyserException(String message, ExceptionType type, Throwable cause) {
		super(message, cause);
		this.type = type;
	}

	public CricketLeagueAnalyserException(String message, String name) {
		super(message);
		this.type = ExceptionType.valueOf(name);
	}
}

