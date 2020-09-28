package ru.ik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import lombok.SneakyThrows;
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
    
    @SneakyThrows
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

    public static void showViewIkNlgVFiles (ViewContext vc, TaskContext tc, Map<String, Object> p) throws IOException {

        new FXFormLauncher<> (tc, vc, ViewIkNlgVFilesController.class)
            .initProperties (p)
            .show ();
    }

}

