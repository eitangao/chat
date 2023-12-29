package ai.chat2db.server.web.api.controller.ai.rest.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author moji
 * @version RestAiCompletion.java, v 0.1 2023年05月27日 14:00 moji Exp $
 * @date 2023/05/27
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RestAiCompletion {

    /**
     * 提示语
     */
    private String prompt;

    private List<Message> messages;

    @Builder.Default
    private double temperature = 0.2;

    private String model;

    @JsonProperty("top_p")
    @Builder.Default
    private Double topP = 1d;


    /**
     * 为每个提示生成的完成次数。
     */
    @Builder.Default
    private Integer n = 1;


    /**
     * 是否流式输出.
     * default:false
     *
     * @see com.unfbx.chatgpt.OpenAiStreamClient
     */
    @Builder.Default
    private boolean stream = false;
    /**
     * 停止输出标识
     */
    private List<String> stop;
    /**
     * 最大支持4096
     */
    @JsonProperty("max_tokens")
    @Builder.Default
    private Integer maxTokens = 2048;


    @JsonProperty("presence_penalty")
    @Builder.Default
    private double presencePenalty = 0;

    /**
     * -2.0 ~~ 2.0
     */
    @JsonProperty("frequency_penalty")
    @Builder.Default
    private double frequencyPenalty = 0;

    @JsonProperty("logit_bias")
    private Map logitBias;
    /**
     * 用户唯一值，确保接口不被重复调用
     */
    private String user;

}
