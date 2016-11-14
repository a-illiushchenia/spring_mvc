package Illiushchenia.springMVC;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 13.11.2016.
 */
public class SpitterService {
    public Object getRecentSpittles(int defaultSpittlesPerPage) {
        return null;
    }

    public Spitter getSpinner(String username) {
        return new Spitter();
    }

    public List<Spittle> getSpittlesForSpitter(String username) {
        List<Spittle> result = new ArrayList<Spittle>();
        result.add(new Spittle());
        return result;
    }
}
