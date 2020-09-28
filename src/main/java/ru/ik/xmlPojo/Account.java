package ru.ik.xmlPojo;

import lombok.Data;

/**
 * @author XDWeloper
 * @created 21 Сентябрь 2020 - 12:59
 * @project pdlFill
 * Узел Accounts имеет следующую внутреннюю структуру
 */

@Data
public class Account {
    private String code;            /** Номер счета */
    private String kind;            /** Вид уведомления 1-открытие счета, 2-закрытие счета */
    private String type;            /** Реестр, которому принадлежит налоговый номер */
    private String stateCode;       /** Налоговый номер или серия и номер паспорта  */
    private String date;            /** Дата операции (дд.мм.гггг) */
    private String crncy;           /** Валюта (код). Допускаются следующие коды валют:RUB-рубль, UAH-гривна, USD-доллар, EUR -евро. */
    private String name;            /** Сокращенное название (фамилия, имя, отчество) клиента в соответствии с уведомлением */
    private String addr;            /** Налоговый адрес клиента согласно документу о взятии на учет налогоплательщика в органе налогов и сборов */
    private String gniCode;         /** Код органа налогов и сборов районного уровня, в котором зарегистрирован клиент  */

}
