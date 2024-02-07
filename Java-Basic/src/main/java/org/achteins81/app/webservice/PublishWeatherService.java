package org.achteins81.app.webservice;

import org.achteins81.app.webservice.impl.WeatherServiceImpl;

import javax.xml.ws.Endpoint;

public class PublishWeatherService {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8085/ws_server/weather", new WeatherServiceImpl());
        System.out.println("天气服务发布成功！");
    }
}
