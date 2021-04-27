package Entity;
import java.util.ArrayList;
import java.util.Map;

public class Project_Rating {

    private int rate;
    private ArrayList<Integer> ratersIDs;
    private Map<Integer,Integer> rateDistribution;

    public Project_Rating() {}

    public Project_Rating(int rate, ArrayList<Integer> ratersIDs, Map<Integer,Integer> rateDistribution)
    {
        setRate(rate);
        setRatersIDs(ratersIDs);
        setRateDistribution(rateDistribution);
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public ArrayList<Integer> getRatersIDs() {
        return ratersIDs;
    }

    public void setRatersIDs(ArrayList<Integer> ratersIDs) {
        this.ratersIDs = ratersIDs;
    }

    public Map<Integer, Integer> getRateDistribution() {
        return rateDistribution;
    }

    public void setRateDistribution(Map<Integer, Integer> rateDistribution) {
        this.rateDistribution = rateDistribution;
    }
}
