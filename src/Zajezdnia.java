import java.util.Collections;
import java.util.LinkedList;

public class Zajezdnia
{
    private LinkedList<Bus> lista = new LinkedList<>();
    private Main m = new Main();

    public synchronized void przekaz(Bus bus, int ktoryBus)
    {
        boolean czyIstnieje = false;            //czy byl wczesniej w liscie

        for(int i = 0; i < lista.size(); i++)
        {
            if(lista.get(i).getKtoryBus() == ktoryBus)
            {
                lista.set(i, bus);
                czyIstnieje = true;
                break;
            }
            if(lista.get(i).getCzas() == -1)
            {
                lista.remove(i);
            }

            if(bus.equals(lista.get(i)))
            {
                lista.remove(bus);
            }
        }


        if (!czyIstnieje)
        {
            lista.add(bus);
        }

        Collections.sort(lista, new Sortowanie());

        m.setView(lista);

        notifyAll();
    }
}
