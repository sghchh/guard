package org.starstudio.loser.gurad.tab.weather.model.bean;

import java.util.List;

/**
 * Created by loser on 2017/9/9.
 * 获取当前的天气状况
 */

public class WeatherNowBean {
    /*{
 "results": [{
 "location": {
     "id": "C23NB62W20TF",
     "name": "西雅图",
     "country": "US",
     "timezone": "America/Los_Angeles",
     "timezone_offset": "-07:00"
 },
 "now": {
     "text": "多云", //天气现象文字
     "code": "4", //天气现象代码
     "temperature": "14", //温度，单位为c摄氏度或f华氏度
     "feels_like": "14", //体感温度，单位为c摄氏度或f华氏度
     "pressure": "1018", //气压，单位为mb百帕或in英寸
     "humidity": "76", //相对湿度，0~100，单位为百分比
     "visibility": "16.09", //能见度，单位为km公里或mi英里
     "wind_direction": "西北", //风向文字
     "wind_direction_degree": "340", //风向角度，范围0~360，0为正北，90为正东，180为正南，270为正西
     "wind_speed": "8.05", //风速，单位为km/h公里每小时或mph英里每小时
     "wind_scale": "2", //风力等级，请参考：http://baike.baidu.com/view/465076.htm
     "clouds": "90", //云量，范围0~100，天空被云覆盖的百分比 #目前不支持中国城市#
     "dew_point": "-12" //露点温度，请参考：http://baike.baidu.com/view/118348.htm #目前不支持中国城市#
 },
 "last_update": "2015-09-25T22:45:00-07:00" //数据更新时间（该城市的本地时间）
 }]
}*/
    private List<Data> results;

    public List<Data> getResults() {
        return results;
    }

    public void setResults(List<Data> results) {
        this.results = results;
    }

    public class Data{
        private Location location;
        private Now now;
        private String last_update;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Now getNow() {
            return now;
        }

        public void setNow(Now now) {
            this.now = now;
        }

        public String getLast_update() {
            return last_update;
        }

        public void setLast_update(String last_update) {
            this.last_update = last_update;
        }
    }

    public class Location{
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getTimezone_offset() {
            return timezone_offset;
        }

        public void setTimezone_offset(String timezone_offset) {
            this.timezone_offset = timezone_offset;
        }

        private String country;
        private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        private String timezone;
        private String timezone_offset;
    }
    public class Now{
        private String text;//天气描述
        private String code;//天气现象代码
        private String temperature;//温度

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        /*private String feels_like;
        private String pressure;//气压
        private String humidity;//相对湿度
        private String visibility;//能见度
        private String wind_direction;//风向
        private String wind_direction_degree;
        private String wind_speed;//风速
        private String wind_scale;//风力
        private String clouds;
        private String dew_point;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getFeels_like() {
            return feels_like;
        }

        public void setFeels_like(String feels_like) {
            this.feels_like = feels_like;
        }

        public String getPressure() {
            return pressure;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getVisibility() {
            return visibility;
        }

        public void setVisibility(String visibility) {
            this.visibility = visibility;
        }

        public String getWind_direction() {
            return wind_direction;
        }

        public void setWind_direction(String wind_direction) {
            this.wind_direction = wind_direction;
        }

        public String getWind_direction_degree() {
            return wind_direction_degree;
        }

        public void setWind_direction_degree(String wind_direction_degree) {
            this.wind_direction_degree = wind_direction_degree;
        }

        public String getWind_speed() {
            return wind_speed;
        }

        public void setWind_speed(String wind_speed) {
            this.wind_speed = wind_speed;
        }

        public String getWind_scale() {
            return wind_scale;
        }

        public void setWind_scale(String wind_scale) {
            this.wind_scale = wind_scale;
        }

        public String getClouds() {
            return clouds;
        }

        public void setClouds(String clouds) {
            this.clouds = clouds;
        }

        public String getDew_point() {
            return dew_point;
        }

        public void setDew_point(String dew_point) {
            this.dew_point = dew_point;
        }*/
    }
}
