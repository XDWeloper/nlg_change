package ru.ik.xmlPojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XDWeloper
 * @created 21 Сентябрь 2020 - 12:56
 * @project pdlFill
 * Структура файла уведомлений
 */
@Data
public class Notification {
    private String owner;                               /** Получатель файла  */
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Account> accounts = new ArrayList<>(); /** Информация о счетах */
}
