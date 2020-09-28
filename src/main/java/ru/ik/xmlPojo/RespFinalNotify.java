package ru.ik.xmlPojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XDWeloper
 * @created 21 Сентябрь 2020 - 13:12
 * @project pdlFill
 * Структура файла квитанции на заключительный (технологический) файл
 */
@Data
public class RespFinalNotify {
    private String owner;                                   /** Отправитель файла */
    private String result;                                  /** Результат обработки */

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Account> accounts = new ArrayList<>();     /** Информация о счетах, которые были поданы с начала дня до текущего момента */
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<RespAccount> roots = new ArrayList<>();    /** Информация о корешках, которые были получены с начала дня до текущего момента */
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Account> accountsWait = new ArrayList<>(); /** Информация о счетах, которые были поданы ранее и не обработаны до текущего момента */

}
