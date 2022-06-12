package com.springboot.demo.function;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import java.io.*;
import java.net.*;

/**
 * 회원가입, 로그인 테스트
 * @author  https://github.com/SproutMJ
 * @exception IOException
 * @exception ParseException
 * @param
 * @return
 * @see
 * @serial
 * @serialData
 * @serialField
 * @since
 * @throws
 * @version
 */
@SpringBootTest
public class AuthTest {

    @Test
    public void registerTest() throws IOException {
        //GIVEN
        //컨넥션 만들기
        URL url = new URL("http://localhost:8080/auth/signup");
        HttpURLConnection registerUrl = (HttpURLConnection) url.openConnection();

        //헤더에 인자 얹기
        registerUrl.setRequestMethod("POST");
        //registerUrl.setRequestProperty("Content-Type","application/json/utf-8"); //415 에러 유발
        registerUrl.setRequestProperty("Content-Type","application/json"); // 없으면 400 에러 유발
        registerUrl.setRequestProperty("Accept", "application/json;");
        registerUrl.setDoOutput(true);
        /*registerUrl.setRequestProperty("username", "test123");
        registerUrl.setRequestProperty("password", "test");
        registerUrl.setRequestProperty("name", "kim");
        registerUrl.setRequestProperty("nickName", "kkim");*/ //400, 415 에러 유발
        registerUrl.setRequestProperty("charset", "UTF-8");

        //json 탑재 방법 1
        /*String jsonString = "{\"username\":\"test123\", \"password\":\"test\", \"name\":\"kim\", \"nickName\":\"kkim\"}";

        try(OutputStream os = registerUrl.getOutputStream()){
            byte[] input = jsonString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }*/ //없으면 415 에러 유발

        //json 탑재 방법 2
        JSONObject obj = new JSONObject();
        obj.put("username", "test123");
        obj.put("password", "test");
        obj.put("name", "kim");
        obj.put("nickName", "kkim");

        OutputStream os = registerUrl.getOutputStream();
        os.write(obj.toString().getBytes("UTF-8"));
        os.close(); //없으면 415 에러 유발. 위의 것도 작동 가능

        //when
        //컨넥션 오픈해서 반환값 받기
        //response code 201
        //then
        // ok
        assertThat(registerUrl.getResponseCode()).isEqualTo(HttpURLConnection.HTTP_CREATED);
    }

    @Test
    public void loginTest() throws IOException, ParseException {
        registerTest();
        URL url = new URL("http://localhost:8080/auth/signin");
        HttpURLConnection login = (HttpURLConnection) url.openConnection();

        //헤더에 인자 얹기
        login.setRequestMethod("POST");
        //login.setRequestProperty("Content-Type","application/json/utf-8"); //415 에러 유발
        login.setRequestProperty("Content-Type","application/json"); // 없으면 400 에러 유발
        login.setRequestProperty("Accept", "application/json;");
        login.setDoOutput(true);
        /*login.setRequestProperty("username", "test123");
        login.setRequestProperty("password", "test");
        login.setRequestProperty("name", "kim");
        login.setRequestProperty("nickName", "kkim");*/ //400, 415 에러 유발
        login.setRequestProperty("charset", "UTF-8");

        String jsonString = "{\"username\":\"test123\", \"password\":\"test\"}";

        try(OutputStream os = login.getOutputStream()){
            byte[] input = jsonString.getBytes("utf-8");
            os.write(input, 0, input.length);
        } //없으면 415 에러 유발

        //when
        //컨넥션 오픈해서 반환값 받기
        //response code 201
        //then
        // ok
        login.connect();
        StringBuffer sb = new StringBuffer();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(login.getInputStream(), "UTF-8"));
            while(br.ready()) {
                sb.append(br.readLine());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        JSONObject loginData = (JSONObject) new JSONParser().parse(sb.toString());
        JSONObject data = (JSONObject) ((JSONObject) loginData.get("result")).get("data");
        String token = (String) data.get("accessToken");

        URL getUrl = new URL("http://localhost:8080/demo/test");
        HttpURLConnection getTest = (HttpURLConnection) getUrl.openConnection();
        getTest.setRequestMethod("GET");
        getTest.setRequestProperty("Content-Type","application/json"); // 없으면 400 에러 유발
        getTest.setRequestProperty("Accept", "application/json;");
        getTest.setRequestProperty("charset", "UTF-8");
        getTest.setRequestProperty("Authorization","Bearer " + token);

        assertThat(getTest.getResponseCode()).isEqualTo(HttpURLConnection.HTTP_OK);
    }

    @Test
    public void logoutTest(){

    }
}
