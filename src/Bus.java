public class Bus implements Runnable
{
    private Zajezdnia zajezdnia;
    private String numer;
    private String ostatniaStacja;
    private int czas;
    private static int ileBusow = 0;
    private int ktoryBus;

    Bus(Zajezdnia zajezdnia, String numer, String ostatniaStacja, int czas)
    {
        this.zajezdnia = zajezdnia;
        this.numer = numer;
        this.ostatniaStacja = ostatniaStacja;
        this.czas = czas;
        ktoryBus = ileBusow;
        ileBusow++;
    }

    public String getNumer()
    {
        return numer;
    }

    public String getOstatniaStacja()
    {
        return ostatniaStacja;
    }

    public int getCzas()
    {
        return czas;
    }

    public int getKtoryBus()
    {
        return ktoryBus;
    }


    @Override
    public void run()
    {
        while(czas >= 0)
        {
            zajezdnia.przekaz(this, ktoryBus);

            try
            {
                Thread.sleep(4000);

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            finally
            {
                czas--;
            }
        }
    }
}
