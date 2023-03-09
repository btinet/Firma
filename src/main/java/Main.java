import entity.Angestellter;
import entity.Arbeiter;

public class Main {

    public static void main(String[] args) {

        // Angestellte erzeugen
        Angestellter officeOlaf = new Angestellter("Olaf","Office",3700);

        // Arbeiter erzeugen
        Arbeiter baustellenBernd = new Arbeiter("Bernd","Baustelle",1200);

        // Provisionen verteilen
        officeOlaf.setProvision(300);

        // Stundenlohn vereinbaren
        baustellenBernd.setStundenlohn(5);

        System.out.println("Lohn: " + baustellenBernd.getGehalt());

        // Arbeitszeit erfassen
        int arbeitszeit = 40;
        String output = String.format("Arbeiter %s arbeitete %s Stunden.",baustellenBernd.getFullName(),arbeitszeit);
        System.out.println(output);
        baustellenBernd.setStunden(arbeitszeit);
        System.out.println("Lohn: " + baustellenBernd.getGehalt());

        baustellenBernd.addStunden(10);
        System.out.println(baustellenBernd.getStunden());
        System.out.println("Lohn: " + baustellenBernd.getGehalt());

    }

}
