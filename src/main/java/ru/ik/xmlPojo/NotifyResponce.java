package ru.ik.xmlPojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XDWeloper
 * @created 21 Сентябрь 2020 - 13:04
 * @project pdlFill
 * Структура файла корешка уведомлений
 */
@Data
public class NotifyResponce {
    private String owner;                                   /** Получатель файла */
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<RespAccount> accounts = new ArrayList<>(); /** Информация о счетах */

}
