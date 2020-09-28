package ru.ik.pojo;

import java.math.BigDecimal;
import java.sql.*;
import java.time.*;
import java.io.Serializable;
import javax.persistence.*;
import ru.inversion.dataset.mark.*;
import ru.inversion.db.entity.ProxyFor;

/**
@author  XDWeloper
@since   2020/09/28 11:27:26
*/
@Entity (name="ru.ik.pojo.PIkNlgVFiles")
@Table (name="IK_NLG_V_FILES")
public class PIkNlgVFiles extends IDMarkable implements Serializable
{
    private static final long serialVersionUID = 28_09_2020_11_27_26l;

    private Long ID;
    private String FILENAME;
    private LocalDate DDATE;
    private String CTYPE;

    public PIkNlgVFiles(){}

    @Id 
    @Column(name="ID",nullable = false,length = 0)
    public Long getID() {
        return ID;
    }
    public void setID(Long val) {
        ID = val; 
    }
    @Column(name="FILENAME",nullable = false,length = 16)
    public String getFILENAME() {
        return FILENAME;
    }
    public void setFILENAME(String val) {
        FILENAME = val; 
    }
    @Column(name="DDATE",nullable = false)
    public LocalDate getDDATE() {
        return DDATE;
    }
    public void setDDATE(LocalDate val) {
        DDATE = val; 
    }
    @Column(name="CTYPE",length = 255)
    public String getCTYPE() {
        return CTYPE;
    }
    public void setCTYPE(String val) {
        CTYPE = val; 
    }
    @Transient
    @Override
    public Long getMarkLongID() {
        return getID();
    }
    @Override
    public boolean isMark() {
        return super.isMark();
    }
}