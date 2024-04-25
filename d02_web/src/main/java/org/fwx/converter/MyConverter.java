package org.fwx.converter;

import org.fwx.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName MyConverter
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/25 8:33
 * @Version 1.0
 */
public class MyConverter implements HttpMessageConverter<Person> {
    @Override
    public List<MediaType> getSupportedMediaTypes(Class<?> clazz) {
        return MediaType.parseMediaTypes("application/x-my");
    }

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-my");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 自定义数据格式
        String data = person.getUserName() + "\t" + person.getAge() + "\t" + person.getBirth();
        // 写出数据
        outputMessage.getBody().write(data.getBytes());
    }
}
