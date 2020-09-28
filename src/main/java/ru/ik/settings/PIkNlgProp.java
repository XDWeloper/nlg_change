package ru.ik.settings;

import java.math.BigDecimal;
import java.sql.*;
import java.time.*;
import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import ru.inversion.dataset.mark.*;
import ru.inversion.db.entity.ProxyFor;

/**
@author  XDWeloper
@since   2020/09/28 12:14:26
*/
@Entity (name="ru.ik.settings.PIkNlgProp")
@Table (name="IK_NLG_PROP")
public class PIkNlgProp implements Serializable
{
    private static final long serialVersionUID = 28_09_2020_12_14_26l;

    private BigDecimal ID;
    private String INPUT_DIR;
    private String OUTPUT_DIR;
    private String XSD_DIR;
    private String ARCH_DIR;


    public PIkNlgProp(){}

    @Id
    @Column(name="ID",nullable = false,length = 0)
    public BigDecimal getID() {
        return ID;
    }
    public void setID(BigDecimal val) {
        ID = val;
    }
    @Column(name="INPUT_DIR",length = 255)
    public String getINPUT_DIR() {
        return INPUT_DIR;
    }
    public void setINPUT_DIR(String val) {
        INPUT_DIR = val;
    }
    @Column(name="OUTPUT_DIR",length = 255)
    public String getOUTPUT_DIR() {
        return OUTPUT_DIR;
    }
    public void setOUTPUT_DIR(String val) {
        OUTPUT_DIR = val;
    }
    @Column(name="XSD_DIR",length = 255)
    public String getXSD_DIR() {
        return XSD_DIR;
    }
    public void setXSD_DIR(String val) {
        XSD_DIR = val;
    }
    @Column(name="ARCH_DIR",length = 255)
    public String getARCH_DIR() {return ARCH_DIR;}
    public void setARCH_DIR(String val) {ARCH_DIR = val;}

}