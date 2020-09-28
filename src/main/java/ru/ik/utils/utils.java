package ru.ik.utils;

import ru.ik.PIkNlgVFilesMain;
import ru.inversion.fxadm.App;

import java.io.File;
import java.io.IOException;

/**
 * @author XDWeloper
 * @created 28 Сентябрь 2020 - 13:57
 * @project nlg_change
 */

public class utils {

    /**получаем номер сборки*/
     public static String getVersion() {
        //Получение номера версии ----------------------------------------------------------------------------------------------
        //Вот таким мягко говоря странным путем удалось получить номер версии из Manifesta
        //Нужно потом переделать
        String version = "";
        try {

            String appId = App.APP().getAppID() + ".jar";
            File pto = new File(utils.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String a_path = pto.getAbsolutePath();
            a_path = a_path.substring(0,a_path.lastIndexOf("\\") + 1);

            String s = PIkNlgVFilesMain.readManifest(a_path + appId);
            String l_version = s.substring(s.indexOf("Implementation-Build") + 21 ,s.indexOf("\n",s.indexOf("Implementation-Build") + 21) - 1);
            l_version = l_version.replace("/", " от ");
            version = "(" + l_version + ")";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return version;
    }
}
