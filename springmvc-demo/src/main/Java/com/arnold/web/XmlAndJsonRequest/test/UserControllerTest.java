package com.arnold.web.XmlAndJsonRequest.test;

import com.arnold.web.XmlAndJsonRequest.domain.User;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class UserControllerTest {


        @Test
    public void testhandle13WithXml() {
        RestTemplate restTemplate = buildRestTemplate();

        User user = new User();
        user.setUserName("tom");

        HttpHeaders entityHeaders = new HttpHeaders();
        entityHeaders.setContentType(MediaType.valueOf("application/xml;UTF-8"));
        entityHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        HttpEntity<User> requestEntity = new HttpEntity<User>(user, entityHeaders);


        ResponseEntity<User> responseEntity = restTemplate.exchange(
                "http://localhost:8080/user/handle13",
                HttpMethod.POST, requestEntity, User.class);

        User responseUser = responseEntity.getBody();
        Assert.assertNotNull(responseUser);
        Assert.assertEquals("1000", responseUser.getUserId());
        Assert.assertEquals("tom", responseUser.getUserName());
        //Assert.assertEquals("汤姆11111", responseUser.getRealName());
    }

    @Test
    public void testJson() {
        RestTemplate restTemplate = buildRestTemplate();

        User user = new User();
        user.setUserName("tom");

        HttpHeaders entityHeaders = new HttpHeaders();
        entityHeaders.setContentType(MediaType.valueOf("application/json;UTF-8"));
        entityHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> requestEntity = new HttpEntity<User>(user, entityHeaders);


        ResponseEntity<User> responseEntity = restTemplate.exchange(
                "http://localhost:8080/user/handle13",
                HttpMethod.POST, requestEntity, User.class);

        User responseUser = responseEntity.getBody();
        Assert.assertNotNull(responseUser);
        Assert.assertEquals("1000", responseUser.getUserId());
        Assert.assertEquals("tom", responseUser.getUserName());
        //Assert.assertEquals("汤姆11111", responseUser.getRealName());
    }



    private RestTemplate buildRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        //①创建MarshallingHttpMessageConverter
        XStreamMarshaller xmlMarshaller = new XStreamMarshaller();
        xmlMarshaller.setStreamDriver(new StaxDriver());
        xmlMarshaller.setAnnotatedClasses(new Class[]{User.class});

        MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
        xmlConverter.setMarshaller(xmlMarshaller);
        xmlConverter.setUnmarshaller(xmlMarshaller);
        restTemplate.getMessageConverters().add(xmlConverter);


        //②创建MappingJacksonHttpMessageConverter
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(jsonConverter);
        return restTemplate;
    }


    @Test
    public void testhandle91() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("userName", "tom");
        form.add("password", "12345");
        form.add("birthday", "1980-01-01");
        form.add("salary", "4,500.00");
        String html = restTemplate.postForObject(
                "http://localhost:8080/user/handle91", form, String.class);
        Assert.assertNotNull(html);
        Assert.assertTrue(html.indexOf("tom") > -1);
    }


}
