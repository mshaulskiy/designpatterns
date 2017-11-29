package net.uk.interconnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by mshaulskiy on 21/02/2017.
 */
public class FacadePattern {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.doxydonkry.blogspost.in");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;

        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }

        reader.close();
    }
}
