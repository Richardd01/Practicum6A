import java.util.ArrayList;
import java.util.Locale;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames = new ArrayList<>();

    public Persoon(String naam, double budget) {
        this.naam = naam;
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game game) {
        if(budget >= game.huidigeWaarde()) {
            for(Game mijnGame : mijnGames) {
                if(mijnGame.equals(game)) {
                    return false;
                }
            }
            budget -= game.huidigeWaarde();
            mijnGames.add(game);
            return true;
        }else{
            return false;
        }
    }

    public boolean verkoop(Game game, Persoon koper) {
        for (Game mijnGame : mijnGames) {
            if(mijnGame.equals(game)) {
                boolean verkocht = koper.koop(game);
                if(verkocht) {
                    mijnGames.remove(game);
                    budget += game.huidigeWaarde();
                }
                return verkocht;
            }
        }
        return false;
    }

    public String toString() {
        String infoString = String.format(Locale.GERMANY, "%s heeft een budget van €%.2f en bezit de volgende games:", naam, budget);
        for(Game game : mijnGames) {
            infoString += "\n" + game;
        }
        return infoString;
    }
}
