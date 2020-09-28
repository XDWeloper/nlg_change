package ru.ik.xmlPojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XDWeloper
 * @created 21 Сентябрь 2020 - 13:09
 * @project pdlFill
 * Структура заключительного (технологического) файла
 */

@Data
public class FinalNotify {
    private String owner;                                   /** Отправитель  файла */
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Account> accounts = new ArrayList<>();     /** Информация о счетах, которые были отправлены с начала дня до текущего момента */
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<RespAccount> roots = new ArrayList<>();    /** Информация о корешках, которые были получены с начала дня до текущего момента */
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Account> accountsWait = new ArrayList<>(); /** Информация о счетах, которые были поданы ранее и не обработаны до текущего момента */
}
