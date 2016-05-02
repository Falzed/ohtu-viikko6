package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

//        Matcher m = new And( new HasAtLeast(10, "goals"),
//                             new HasAtLeast(10, "assists"),
//                             new PlaysIn("PHI")
//        );
//        
//        for (Player player : stats.matches(m)) {
//            System.out.println( player );
//        }
//        Matcher m2 = new Or( new HasAtLeast(30, "goals"),
//                             new HasAtLeast(50, "assists"),
//                             new PlaysIn("PHI")
//        );
//        
//        for (Player player : stats.matches(m2)) {
//            System.out.println( player );
//        }
//        Matcher m4 = new And( new HasFewerThan(5, "goals"));
//        
//        for (Player player : stats.matches(m4)) {
//            System.out.println( player );
//        }
//        Matcher m3 = new And(new Not(new HasAtLeast(10, "goals"))
//        );
//
//        for (Player player : stats.matches(m3)) {
//            System.out.println(player);
//        }
        QueryBuilder query = new QueryBuilder();

        Matcher m = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();

        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(50, "points").build();

        Matcher m6 = query.Or(m1, m2).build();
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        
        for (Player player : stats.matches(m1)) {
            System.out.println(player);
        }
        for (Player player : stats.matches(m2)) {
            System.out.println(player);
        }
        for (Player player : stats.matches(m6)) {
            System.out.println(player);
        }
    }
}
