package ru.ik.settings;

import javafx.event.Event;
import javafx.fxml.FXML;
import ru.inversion.bicomp.util.ParamMap;
import ru.inversion.dataset.SQLDataSet;
import ru.inversion.fx.form.JInvFXBrowserController;
import ru.inversion.fx.form.controls.JInvButton;
import ru.inversion.fx.form.controls.JInvTextField;
import ru.inversion.fx.form.controls.JInvWrapButton;
import ru.inversion.fx.form.lov.JInvDirectoryChooserLov;
import ru.inversion.fx.form.lov.JInvFileChooserLov;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XDWeloper
 * @created 28 Сентябрь 2020 - 12:03
 * @project nlg_change
 */

public class SettingsViewController extends JInvFXBrowserController {
@FXML JInvTextField INPUT_DIR;
@FXML JInvTextField OUTPUT_DIR;
@FXML JInvTextField XSD_DIR;
@FXML JInvTextField ARCH_DIR;



    private SQLDataSet<PIkNlgProp> data;
    private PIkNlgProp setings;


    @Override
    protected void init() throws Exception {
        super.init();
        setTitle(getBundleString("VIEW.TITLE"));

        initDataSet();

    }

    private void initDataSet() throws ru.inversion.dataset.DataSetException {
        data = populateDataSet (PIkNlgProp.class, null, "rownum = 1",null,0);
        data.executeQuery();
        setings = data.getRow(0);
        INPUT_DIR.setText(setings.getINPUT_DIR() != null ? setings.getINPUT_DIR(): "");
        OUTPUT_DIR.setText(setings.getOUTPUT_DIR() != null ? setings.getOUTPUT_DIR(): "");
        ARCH_DIR.setText(setings.getARCH_DIR() != null ? setings.getARCH_DIR(): "");
        XSD_DIR.setText(setings.getXSD_DIR() != null ? setings.getXSD_DIR(): "");

        INPUT_DIR.setInnerButton(new JInvButton(){{setText("...");setOnAction(e -> onClickDirButton(e));setId("INPUT_DIR");}});
        OUTPUT_DIR.setInnerButton(new JInvButton(){{setText("...");setOnAction(e -> onClickDirButton(e));setId("OUTPUT_DIR");}});
        XSD_DIR.setInnerButton(new JInvButton(){{setText("...");setOnAction(e -> onClickDirButton(e));setId("XSD_DIR");}});
        ARCH_DIR.setInnerButton(new JInvButton(){{setText("...");setOnAction(e -> onClickDirButton(e));setId("ARCH_DIR");}});

    }

    @Override
    protected boolean onOK() {
        saveSettings();
        return super.onOK();
    }

    private void saveSettings() {
    try{
        ParamMap pm = new ParamMap();
        pm.put("inpur_dir",INPUT_DIR.getText() != null ? INPUT_DIR.getText(): null);
        pm.put("output_dir",OUTPUT_DIR.getText() != null ? OUTPUT_DIR.getText(): null);
        pm.put("xsd_dir",XSD_DIR.getText() != null ? XSD_DIR.getText(): null);
        pm.put("arch_dir",ARCH_DIR.getText() != null ? ARCH_DIR.getText(): null);

        pm.exec(this.getTaskContext(),SettingsViewController.class,"SaveSettings");
    }catch (Exception e){
        e.printStackTrace();
    }
    }

    public void onClickDirButton(Event e){
        String buttonID = ((JInvWrapButton)e.getSource()).getInnerButton().getId();

        JInvDirectoryChooserLov chooseDir = new JInvDirectoryChooserLov();
        chooseDir.showChoiceList(getViewContext(),null,null);

        if(chooseDir.getValue() == null) return;
        String dirName = chooseDir.getValue().toString();

        switch (buttonID){
            case "INPUT_DIR":
                INPUT_DIR.setText(dirName);
                break;
            case "OUTPUT_DIR":
                OUTPUT_DIR.setText(dirName);
                break;
            case "XSD_DIR":
                XSD_DIR.setText(dirName);
                break;
            case "ARCH_DIR":
                ARCH_DIR.setText(dirName);
                break;
       }
    }
}
