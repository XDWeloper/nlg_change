package ru.ik;

import javafx.fxml.FXML;
import ru.ik.EditIkNlgVFilesController;
import ru.ik.pojo.PIkNlgVFiles;
import ru.ik.settings.SettingsViewController;
import ru.ik.utils.utils;
import ru.inversion.dataset.IDataSet;
import ru.inversion.dataset.XXIDataSet;
import ru.inversion.dataset.fx.DSFXAdapter;
import ru.inversion.dataset.aggr.AggrFuncEnum;
import ru.inversion.fx.form.controls.dsbar.DSInfoBar;
import ru.inversion.fx.form.controls.table.toolbar.AggregatorType;

import ru.inversion.fx.form.*;
import ru.inversion.fx.form.controls.*;
import ru.inversion.icons.enums.FontAwesome;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author  XDWeloper
 * @since   Mon Sep 28 11:27:36 MSK 2020
 */
public class ViewIkNlgVFilesController extends JInvFXBrowserController 
{
    @FXML private JInvTable<PIkNlgVFiles> IK_NLG_V_FILES;   
    @FXML private JInvToolBar toolBar;
    @FXML private DSInfoBar IK_NLG_V_FILES$MARK;
 
    private final XXIDataSet<PIkNlgVFiles> dsIK_NLG_V_FILES = new XXIDataSet<> ();


    private void initDataSet () throws Exception
    {
        dsIK_NLG_V_FILES.setTaskContext (getTaskContext ());
        dsIK_NLG_V_FILES.setRowClass (PIkNlgVFiles.class);
    }
    @Override
    protected void init() throws Exception
    {

        setTitle (getBundleString ("VIEW.TITLE")  + "   " + utils.getVersion());
        initDataSet ();
        DSFXAdapter<PIkNlgVFiles> dsfx = DSFXAdapter.bind (dsIK_NLG_V_FILES, IK_NLG_V_FILES, null, true); 

        dsfx.setEnableFilter (true);
        IK_NLG_V_FILES$MARK.init (IK_NLG_V_FILES.getDataSetAdapter ());
        IK_NLG_V_FILES$MARK.addAggregator ("1", AggrFuncEnum.COUNT, AggregatorType.MARK, null, null);
 
        initToolBar ();
        doRefresh ();
    }



    private void doRefresh ()
    {
        IK_NLG_V_FILES.executeQuery ();
    }

    private void initToolBar ()
    {
        toolBar.setStandartActions (
                                    ActionFactory.ActionTypeEnum.VIEW,
                                    ActionFactory.ActionTypeEnum.UPDATE,
                                    ActionFactory.ActionTypeEnum.DELETE,
                                    ActionFactory.ActionTypeEnum.REFRESH);

        IK_NLG_V_FILES.setToolBar (toolBar);
        IK_NLG_V_FILES.setAction (ActionFactory.ActionTypeEnum.VIEW, (a) -> doOperation (FormModeEnum.VM_SHOW));
        IK_NLG_V_FILES.setAction (ActionFactory.ActionTypeEnum.UPDATE, (a) -> doOperation (FormModeEnum.VM_EDIT));
        IK_NLG_V_FILES.setAction (ActionFactory.ActionTypeEnum.DELETE, (a) -> doOperation (FormModeEnum.VM_DEL));
        IK_NLG_V_FILES.setAction (ActionFactory.ActionTypeEnum.REFRESH, (a) -> doRefresh ());
        toolBar.getItems().add(ActionFactory.createButton(FontAwesome.fa_wrench, getBundleString("PROPS"), (a) -> OpenSettings(), getBundleString("PROPS")));


//        toolBar.getItems ().add (ActionFactory.createButton(ActionFactory.ActionTypeEnum.SETTINGS, (a) -> JInvMainFrame.showSettingsPane ()));
    }

    /**Открыть окно настроек*/
    private void OpenSettings() {
        new FXFormLauncher<> (getTaskContext (), getViewContext (), SettingsViewController.class)
                .modal (true)
                .show ();
    }

    private void doOperation ( JInvFXFormController.FormModeEnum mode )
    {
        PIkNlgVFiles p = null;

        switch (mode) {
            case VM_INS:
                p = new PIkNlgVFiles ();
                break;
            case VM_EDIT:
            case VM_SHOW:
            case VM_DEL:
                p = dsIK_NLG_V_FILES.getCurrentRow ();
                break;
        }

        if (p != null) 
            new FXFormLauncher<PIkNlgVFiles> (getTaskContext (), getViewContext (), EditIkNlgVFilesController.class)
                .dataObject (p)
                .dialogMode (mode)
                .initProperties (getInitProperties ())
                .callback (this::doFormResult)    
                .modal (true)
                .show ();
    }

    private void doFormResult ( JInvFXFormController.FormReturnEnum ok, JInvFXFormController<PIkNlgVFiles> dctl )    
    {
        if (JInvFXFormController.FormReturnEnum.RET_OK == ok)
        {
            switch (dctl.getFormMode ()) 
            {
                case VM_INS:
                    dsIK_NLG_V_FILES.insertRow (dctl.getDataObject (), IDataSet.InsertRowModeEnum.AFTER_CURRENT, true);
                    break;
                case VM_EDIT:                
                    dsIK_NLG_V_FILES.updateCurrentRow (dctl.getDataObject ());
                    break;
                case VM_DEL:
                    dsIK_NLG_V_FILES.removeCurrentRow ();
                    break;
                default:
                    break;
            }                
        }    

        IK_NLG_V_FILES.requestFocus ();
    }        

}

