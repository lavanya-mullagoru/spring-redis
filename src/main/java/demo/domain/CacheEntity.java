package demo.domain;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash
public class CacheEntity {

    private String id;
    private String statusCode;
    private String message;
    private String processingTime;
    private String totalResultCount;
    private String deviceModelSpecs;
    private String lastModified;
}
