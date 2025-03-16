package be.naaturel.letsmeet.core.helpers;

import java.util.UUID;

public class TokenGenerator {


    private static int length = 6;

    public static String generate(){
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }

}
