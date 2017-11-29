package net.uk.interconnect;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * Created by mshaulskiy on 31/12/2016.
 */
public class DecoratorParrten implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String name = "sampleSerialzedObject.gz";
        ObjectInputStream ois = null;

        try {
            // 1. Serialize this object
            // TODO: add code to serialize and zip this object

            // 2. Restore the serialized object
            ois = new ObjectInputStream(
                    new GZIPInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(name)
                            )
                    )
            );

            Object obj = ois.readObject();
//            assert(obj.getClass().equals(DecoratorParrten.class));

        } finally {
            ois.close();
        }

    }
}
