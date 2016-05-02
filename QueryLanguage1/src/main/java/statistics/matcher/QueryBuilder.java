package statistics.matcher;

import java.util.ArrayList;
import statistics.Player;

public class QueryBuilder implements Matcher {

    private ArrayList<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList<Matcher>();
    }

    public QueryBuilder(Matcher matcher, ArrayList<Matcher> oldMatchers) {
        this.matchers = oldMatchers;
        this.matchers.add(matcher);
    }
    public QueryBuilder(ArrayList<Matcher> oldMatchers) {
        this.matchers = oldMatchers;
    }

    public QueryBuilder playsIn(String team) {
        ArrayList<Matcher> newList = new ArrayList<Matcher>();
        newList.addAll(this.matchers);
        return new QueryBuilder(new PlaysIn(team), newList);
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        ArrayList<Matcher> newList = new ArrayList<Matcher>();
        newList.addAll(this.matchers);
        return new QueryBuilder(new HasAtLeast(value, category), newList);
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        ArrayList<Matcher> newList = new ArrayList<Matcher>();
        newList.addAll(this.matchers);
        return new QueryBuilder(new HasFewerThan(value, category), newList);
    }

    public QueryBuilder Or(Matcher... matchers) {
        ArrayList<Matcher> newList = new ArrayList<Matcher>();
        newList.addAll(this.matchers);
        for(int i=0; i<matchers.length; i++) {
            newList.add(matchers[i]);
        }
        return new QueryBuilder(newList);
    }


    public QueryBuilder build() {
        System.out.println(this.matchers);
        return this;
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }
        return true;
    }
}
