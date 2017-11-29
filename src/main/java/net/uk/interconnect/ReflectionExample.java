package net.uk.interconnect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mshaulskiy on 21/02/2017.
 */
public class ReflectionExample {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<String> list = new ArrayList<>();

        List onTheFlyList = (List) Class.forName("java.util.ArrayList").newInstance();
    }
}
