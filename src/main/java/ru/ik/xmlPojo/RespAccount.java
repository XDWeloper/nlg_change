package ru.ik.xmlPojo;

import lombok.Data;

/**
 * @author XDWeloper
 * @created 21 Сентябрь 2020 - 13:05
 * @project pdlFill
 */

@Data
public class RespAccount {
    private String code;            /** Номер счета */
    private String kind;            /** Вид уведомления 1-открытие счета, 2-закрытие счета */
    private String date;            /** Дата операции (дд.мм.гггг) */
    private String crncy;           /** Валюта (код). Допускаются следующие коды валют:RUB-рубль, UAH-гривна, USD-доллар, EUR -евро. */
    private String DateReceive;     /** Дата получения ГКНС ЛНР уведомления (дд.мм.гггг) */
    private String DateSts;         /** Дата взятия на учет (отказа взятия на учет) счета в органе ГКНС ЛНР (дд.мм.гггг) */
    private String ReasonCode;      /** Код причины отказа во принятии на учет счета  */
    private String FileName;        /** Наименование файла уведомления, в котором была подана информация о счете  */
}
