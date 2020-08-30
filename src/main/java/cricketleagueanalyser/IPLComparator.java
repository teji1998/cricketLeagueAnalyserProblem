package cricketleagueanalyser;

import java.util.Comparator;

public class IPLComparator {
   static Comparator<LeagueDAO> battingAverageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
   static Comparator<LeagueDAO> battingStrikeRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingStrikeRate);
   static Comparator<LeagueDAO> sixAndFourComparator = Comparator.comparing
           (iplFactSheet -> iplFactSheet.sixes * 6 + iplFactSheet.fours * 4);
   static Comparator<LeagueDAO> runsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.runs);
   static Comparator<LeagueDAO> bowlingAverageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
   static Comparator<LeagueDAO> economyComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.economyRate);
   static Comparator<LeagueDAO> bowlerStrikeRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingStrikeRate);
   static Comparator<LeagueDAO> fourAndFiveWicketsComparator = Comparator.comparing
           (iplFactSheet -> iplFactSheet.fourWicket + iplFactSheet.fiveWicket);
   static Comparator<LeagueDAO> wicketsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.wicket);
   static Comparator<LeagueDAO> centuryComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.hundred);
   static Comparator<LeagueDAO> minimumHalfCenturyAndCenturyComparator = Comparator.comparing
           (iplFactSheet -> iplFactSheet.hundred * 100 + iplFactSheet.fifty * 50 == 0);
}
