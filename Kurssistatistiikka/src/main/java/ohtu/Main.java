package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        // MAKSIMIPISTEET, TEKEMÄTTÄ
        String url1 = "https://studies.cs.helsinki.fi/courses/courseinfo";
        String bodytext1 = Request.Get(url1).execute().returnContent().asString();

        // KAIKKIEN PALAUTUKSET
        // ohtu
        String url2 = "https://studies.cs.helsinki.fi/courses/ohtu2018/stats";
        String bodytext2 = Request.Get(url2).execute().returnContent().asString();

        // rails
        String url3 = "https://studies.cs.helsinki.fi/courses/rails2018/stats";
        String bodytext3 = Request.Get(url3).execute().returnContent().asString();

        int ohtuTehtavat = 0;
        int railsTehtavat = 0;
        int ohtuTunnit = 0;
        int railsTunnit = 0;

        System.out.println("Opiskelijanumero: " + studentNr);
        System.out.println("");
        System.out.println("Web-palvelinohjelmointi Ruby on Rails syksy 2018");
        for (Submission submission : subs) {
            if (submission.getCourse().equals("rails2018")) {
                System.out.println(submission);

                railsTehtavat += submission.getNumberOfExercises();
                railsTunnit += submission.getHours();
            }

        }

        System.out.println("Yhteensä tehtäviä tehty: " + railsTehtavat + " tehtävää ja " + railsTunnit + " tuntia.");
        System.out.println("");
        System.out.println("Ohjelmistotuotanto syksy 2018");

        for (Submission submission : subs) {
            if (submission.getCourse().equals("ohtu2018")) {
                System.out.println(submission);
                ohtuTehtavat += submission.getNumberOfExercises();
                ohtuTunnit += submission.getHours();
            }

        }

        System.out.println("Yhteensä tehtäviä tehty: " + ohtuTehtavat + " tehtävää ja " + ohtuTunnit + " tuntia.");

    }
}
