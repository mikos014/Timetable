import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.LinkedList;

public class Main extends Application
{
    private Stage window;
    private static Text linia1, linia2, linia3, linia4, linia5,
                        stacja1, stacja2, stacja3, stacja4, stacja5,
                        odjazd1, odjazd2, odjazd3, odjazd4, odjazd5;

    public static void main(String[] args)
    {
        Zajezdnia zajezdnia = new Zajezdnia();

        new Thread(new Bus(zajezdnia,"11", "Metro Młociny", 1)).start();
        new Thread(new Bus(zajezdnia,"11", "Metro Młociny", 4)).start();
        new Thread(new Bus(zajezdnia,"11", "Metro Młociny", 7)).start();
        new Thread(new Bus(zajezdnia,"11", "Metro Młociny", 10)).start();
        new Thread(new Bus(zajezdnia,"26", "Osiedle Górczewska", 1)).start();
        new Thread(new Bus(zajezdnia,"26", "Osiedle Górczewska", 3)).start();
        new Thread(new Bus(zajezdnia,"26", "Osiedle Górczewska", 5)).start();
        new Thread(new Bus(zajezdnia,"26", "Osiedle Górczewska", 7)).start();
        new Thread(new Bus(zajezdnia,"26", "Osiedle Górczewska", 9)).start();
        new Thread(new Bus(zajezdnia,"28", "Osiedle Górczewska", 2)).start();
        new Thread(new Bus(zajezdnia,"28", "Osiedle Górczewska", 4)).start();
        new Thread(new Bus(zajezdnia,"28", "Osiedle Górczewska", 9)).start();
        new Thread(new Bus(zajezdnia,"28", "Osiedle Górczewska", 14)).start();
        new Thread(new Bus(zajezdnia,"23", "Nowe Bemowo", 1)).start();
        new Thread(new Bus(zajezdnia,"23", "Nowe Bemowo", 3)).start();
        new Thread(new Bus(zajezdnia,"23", "Nowe Bemowo", 5)).start();
        new Thread(new Bus(zajezdnia,"23", "Nowe Bemowo", 7)).start();
        new Thread(new Bus(zajezdnia,"23", "Nowe Bemowo", 9)).start();
        new Thread(new Bus(zajezdnia,"23", "Nowe Bemowo", 11)).start();
        new Thread(new Bus(zajezdnia,"23", "Nowe Bemowo", 13)).start();
        new Thread(new Bus(zajezdnia,"24", "Nowe Bemowo", 2)).start();
        new Thread(new Bus(zajezdnia,"24", "Nowe Bemowo", 5)).start();
        new Thread(new Bus(zajezdnia,"24", "Nowe Bemowo", 8)).start();
        new Thread(new Bus(zajezdnia,"24", "Nowe Bemowo", 11)).start();
        new Thread(new Bus(zajezdnia,"35", "Zajezdnia Żoliborz", 1)).start();
        new Thread(new Bus(zajezdnia,"35", "Zajezdnia Żoliborz", 6)).start();
        new Thread(new Bus(zajezdnia,"35", "Zajezdnia Żoliborz", 11)).start();
        new Thread(new Bus(zajezdnia,"35", "Zajezdnia Żoliborz", 16)).start();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;

        Scene scene = new Scene(createScene());

        primaryStage.setTitle("Przystanek autobusowy");
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    private Parent createScene()
    {
        Text headerLinia = new Text("Linia");
        headerLinia.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text headerStacja = new Text("Stacja końcowa");
        headerStacja.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text headerOdjazd = new Text("Odjazd za");
        headerOdjazd.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));


        linia1 = new Text();
        stacja1 = new Text();
        odjazd1 = new Text();

        linia2 = new Text();
        stacja2 = new Text();
        odjazd2 = new Text();

        linia3 = new Text();
        stacja3 = new Text();
        odjazd3 = new Text();

        linia4 = new Text();
        stacja4 = new Text();
        odjazd4 = new Text();

        linia5 = new Text();
        stacja5 = new Text();
        odjazd5 = new Text();

        GridPane root = new GridPane();

        root.setMinSize(700,500);
        root.setPadding(new Insets(10,10,10,10));
        root.setHgap(35);
        root.setVgap(5);
        root.setAlignment(Pos.TOP_CENTER);

        root.add(headerLinia, 0, 0);
        root.add(headerStacja, 1, 0);
        root.add(headerOdjazd, 2, 0);


        root.add(linia1, 0, 1);
        root.add(stacja1, 1, 1);
        root.add(odjazd1, 2, 1);

        root.add(linia2, 0, 2);
        root.add(stacja2, 1, 2);
        root.add(odjazd2, 2, 2);

        root.add(linia3, 0, 3);
        root.add(stacja3, 1, 3);
        root.add(odjazd3, 2, 3);

        root.add(linia4, 0, 4);
        root.add(stacja4, 1, 4);
        root.add(odjazd4, 2, 4);

        root.add(linia5, 0, 5);
        root.add(stacja5, 1, 5);
        root.add(odjazd5, 2, 5);


        return root;
    }

    public void setView(LinkedList<Bus> list)
    {
        System.out.println("Linia         Stacja           Czas");

        for (int i = 0; i < Math.min(list.size(), 5); i++)
        {
            System.out.println(list.get(i).getNumer() + "       " + list.get(i).getOstatniaStacja() + "         "  + list.get(i).getCzas());
        }

        System.out.println("");


        try {
            Platform.runLater(() -> {
                for (int i = 1; i <= Math.min(list.size(), 5); i++)
                {

                    switch (i)
                    {
                        case 1:
                            linia1.setText(list.get(i).getNumer());
                            stacja1.setText(list.get(i).getOstatniaStacja());

                            String s1 = "" + list.get(i).getCzas();
                            odjazd1.setText(s1);
                        case 2:
                            linia2.setText(list.get(i).getNumer());
                            stacja2.setText(list.get(i).getOstatniaStacja());

                            String s2 = "" + list.get(i).getCzas();
                            odjazd2.setText(s2);
                        case 3:
                            linia3.setText(list.get(i).getNumer());
                            stacja3.setText(list.get(i).getOstatniaStacja());

                            String s3 = "" + list.get(i).getCzas();
                            odjazd3.setText(s3);
                        case 4:
                            linia4.setText(list.get(i).getNumer());
                            stacja4.setText(list.get(i).getOstatniaStacja());

                            String s4 = "" + list.get(i).getCzas();
                            odjazd4.setText(s4);
                        case 5:
                            linia5.setText(list.get(i).getNumer());
                            stacja5.setText(list.get(i).getOstatniaStacja());

                            String s5 = "" + list.get(i).getCzas();
                            odjazd5.setText(s5);
                        default:
                    }
                }
            });
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
