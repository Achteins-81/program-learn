package org.achteins81.app.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WeatherService {
    @WebMethod
    String getWeatherByCityName(String cityName);
}
