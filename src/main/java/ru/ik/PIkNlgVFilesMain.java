package ru.ik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import ru.inversion.fx.form.ViewContext;
import ru.inversion.fx.app.BaseApp;
import ru.inversion.fx.form.FXFormLauncher;
import ru.inversion.tc.TaskContext;

/**
 *
 * @author  XDWeloper
 * @since   Mon Sep 28 11:27:44 MSK 2020
 */
public class PIkNlgVFilesMain extends BaseApp 
{
    
    @Override
    protected void showMainWindow () 
    {
        showViewIkNlgVFiles (getPrimaryViewContext (), new TaskContext (), Collections.emptyMap ());
    }

    @Override
    public String getAppID () 
    {
        return "nlg";
    }
    
    public static void main (String[] args) 
    {
        launch (args);
    }

    public static void showViewIkNlgVFiles (ViewContext vc, TaskContext tc, Map<String, Object> p) 
    {
        new FXFormLauncher<> (tc, vc, ViewIkNlgVFilesController.class)
            .initProperties (p)
            .show ();
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
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
        }

        return stringBuilder.toString().trim() + System.lineSeparator();
    }
    
}

