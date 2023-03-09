import entity.Angestellter;
import entity.Arbeiter;

public class Main {

    public static void main(String[] args) {

        // Angestellte erzeugen
        Angestellter officeOlaf = new Angestellter("Olaf","Office",3700);

        // Arbeiter erzeugen
        Arbeiter baustellenBernd = new Arbeiter("Bernd","baustelle",1200);

        // Provisionen verteilen
        officeOlaf.setProvision(300);

        // Stundenlohn vereinbaren
        baustellenBernd.setStundenlohn(5);

        System.out.println("Lohn: " + baustellenBernd.getLohn());

        // Arbeitszeit erfassen
        System.out.println("Arbeiter erfasst Arbeitszeit");
        baustellenBernd.setStunden(40);

        System.out.println("Lohn: " + baustellenBernd.getLohn());

    }

}
