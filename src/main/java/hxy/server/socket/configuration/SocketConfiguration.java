package hxy.server.socket.configuration;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import hxy.server.socket.entity.SslInfo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName SocketConfiguration
 * @Description Socket配置文件
 * @Author hxy
 * @Date 2020/4/8 17:26
 */
@Component
@ConfigurationProperties("socket.config")
public class SocketConfiguration {
    /**
     * 端口号
     */
    int port = 9090;

    /**
     * 协议格式
     */
    ProtocolType protocolType = ProtocolType.TEXT;

    /**
     * 启动boss线程数
     */
    int bossThreadCount = 2;

    /**
     * 启动work线程数
     */
    int workThreadCount = 4;

    /**
     * 未检测到心跳挂断时间（秒）
     */
    int heartTimeout = 5;

    /**
     * SSL相关配置
     */
    SslInfo sslInfo = new SslInfo();

    /**
     * json解析格式
     */
    JacksonPropertyNamingStrategy jacksonPropertyNamingStrategy = JacksonPropertyNamingStrategy.SNAKE_CASE;

    public SslInfo getSslInfo() {
        return sslInfo;
    }

    public void setSslInfo(SslInfo sslInfo) {
        this.sslInfo = sslInfo;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBossThreadCount() {
        return bossThreadCount;
    }

    public void setBossThreadCount(int bossThreadCount) {
        this.bossThreadCount = bossThreadCount;
    }

    public int getWorkThreadCount() {
        return workThreadCount;
    }

    public void setWorkThreadCount(int workThreadCount) {
        this.workThreadCount = workThreadCount;
    }

    public int getHeartTimeout() {
        return heartTimeout;
    }

    public void setHeartTimeout(int heartTimeout) {
        this.heartTimeout = heartTimeout;
    }

    public ProtocolType getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(ProtocolType protocolType) {
        this.protocolType = protocolType;
    }

    public JacksonPropertyNamingStrategy getJacksonPropertyNamingStrategy() {
        return jacksonPropertyNamingStrategy;
    }

    public void setJacksonPropertyNamingStrategy(JacksonPropertyNamingStrategy jacksonPropertyNamingStrategy) {
        this.jacksonPropertyNamingStrategy = jacksonPropertyNamingStrategy;
    }

    public enum ProtocolType {
        TEXT, BYTE
    }

    public enum JacksonPropertyNamingStrategy {
        SNAKE_CASE(PropertyNamingStrategy.SNAKE_CASE),
        UPPER_CAMEL_CASE(PropertyNamingStrategy.UPPER_CAMEL_CASE),
        LOWER_CAMEL_CASE(PropertyNamingStrategy.LOWER_CAMEL_CASE),
        LOWER_CASE(PropertyNamingStrategy.LOWER_CASE),
        KEBAB_CASE(PropertyNamingStrategy.KEBAB_CASE);

        private PropertyNamingStrategy propertyNamingStrategy;

        JacksonPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
            this.propertyNamingStrategy = propertyNamingStrategy;
        }

        public PropertyNamingStrategy getPropertyNamingStrategy() {
            return propertyNamingStrategy;
        }

        public void setPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
            this.propertyNamingStrategy = propertyNamingStrategy;
        }
    }
}

