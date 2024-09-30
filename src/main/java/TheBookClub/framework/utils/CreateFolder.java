package TheBookClub.framework.utils;

import java.io.File;

public class CreateFolder {

    public static void createDirectory(String path){
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("A pasta foi criada!");
        }
    }
}