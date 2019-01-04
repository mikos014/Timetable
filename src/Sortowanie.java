import java.util.Comparator;

public class Sortowanie implements Comparator <Bus>
{

    @Override
    public int compare(Bus b1, Bus b2)
    {
        if(b1.getCzas() > b2.getCzas())
            return 1;
        else
            return -1;
    }
}
