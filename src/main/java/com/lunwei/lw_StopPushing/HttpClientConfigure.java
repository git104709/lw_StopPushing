package com.lunwei.lw_StopPushing;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:    HttpClientConfigure
 * Package:    com.lunwei.lw_StopPushing
 * Description: 接收配置信息
 * Datetime:    2020/1/13   14:41
 * Author:   zhoukaishun
 */
@Component
@ConfigurationProperties(prefix="httpclientconfigure")
@Data
public class HttpClientConfigure {

    private Map<String, String> mapPath = new HashMap<>();

    private String scheme;

    private String host;

    private Integer port;

}
