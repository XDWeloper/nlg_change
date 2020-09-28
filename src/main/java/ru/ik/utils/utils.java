package ru.ik.utils;

import ru.ik.PIkNlgVFilesMain;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author XDWeloper
 * @created 28 Сентябрь 2020 - 13:57
 * @project nlg_change
 */

public class utils {

    /**
     * получаем номер сборки
     */
    public static String getVersion() {
        //Получение номера версии ----------------------------------------------------------------------------------------------
        //Вот таким мягко говоря странным путем удалось получить номер версии из Manifesta
        //Нужно потом переделать
        try {
            String appId = PIkNlgVFilesMain.APP().getAppID() + ".jar";
            File pto = new File(utils.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String a_path = pto.getAbsolutePath();
            a_path = a_path.substring(0, a_path.lastIndexOf("\\") + 1);

            String s = readManifest(a_path + appId).replaceAll("\\r\\n","");
            String l_version = s.substring(s.indexOf("Implementation-Build") + 21, s.indexOf("Class-Path") );
            return l_version;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String readManifest(String sourceJARFile) throws IOException
    {
        ZipFile zipFile = new ZipFile(sourceJARFile);
        Enumeration entries = zipFile.entries();

        while (entries.hasMoreElements())
        {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().equals("META-INF/MANIFEST.MF"))
            {
                return toString(zipFile.getInputStream(zipEntry));
            }
        }
        throw new IllegalStateException("Manifest not found");
    }

    private static String toString(InputStream inputStream) throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line.trim());
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim() + System.lineSeparator();
    }
}
