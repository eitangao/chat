
package ai.chat2db.server.web.api.controller.ai.rest.client;

import ai.chat2db.server.domain.api.model.Config;
import ai.chat2db.server.domain.api.service.ConfigService;
import ai.chat2db.server.web.api.util.ApplicationContextUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author moji
 * @version : RestAIClient.java
 */
@Slf4j
public class RestAIClient {

    /**
     * AI SQL选择的接口来源
     */
    public static final String AI_SQL_SOURCE = "ai.sql.source";

    /**
     * 自定义AI接口地址
     */
    public static final String REST_AI_URL = "rest.ai.url";

    /**
     * 自定义AI接口模型名称
     */

    public static final String REST_AI_MODEL = "rest.ai.model";


    /**
     * 自定义AI接口请求方法
     */
    public static final String REST_AI_STREAM_OUT = "rest.ai.stream";

    private static RestAiStreamClient REST_AI_STREAM_CLIENT;

    public static RestAiStreamClient getInstance() {
        if (REST_AI_STREAM_CLIENT != null) {
            return REST_AI_STREAM_CLIENT;
        } else {
            return singleton();
        }
    }

    private static RestAiStreamClient singleton() {
        if (REST_AI_STREAM_CLIENT == null) {
            synchronized (RestAIClient.class) {
                if (REST_AI_STREAM_CLIENT == null) {
                    refresh();
                }
            }
        }
        return REST_AI_STREAM_CLIENT;
    }

    /**
     * 刷新客户端
     */
    public static void refresh() {
        String apiUrl = "";
        Boolean stream = Boolean.FALSE;
        String model = "atom";
        ConfigService configService = ApplicationContextUtil.getBean(ConfigService.class);
        Config apiHostConfig = configService.find(REST_AI_URL).getData();
        if (apiHostConfig != null) {
            apiUrl = apiHostConfig.getContent()+"openai/v1/chat/completions";
        }
        Config config = configService.find(REST_AI_STREAM_OUT).getData();
        if (config != null) {
            stream = Boolean.valueOf(config.getContent());
        }
        Config modelConfig = configService.find(REST_AI_MODEL).getData();
        if(config!=null){
            model = modelConfig.getContent();
        }
        stream=true;
        REST_AI_STREAM_CLIENT = new RestAiStreamClient(apiUrl, stream,model);
    }

}
