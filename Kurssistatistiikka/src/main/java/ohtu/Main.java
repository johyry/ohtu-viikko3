package ohtu;

import com.google.gson.Gson;
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

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);

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
        
        System.out.println("Opiskelijanumero: " + studentNr);
        for (Submission submission : subs) {
            if (submission.getCourse().equals("ohtu2018")) {
                System.out.println(submission);
            }
        }
        
        

    }
}
