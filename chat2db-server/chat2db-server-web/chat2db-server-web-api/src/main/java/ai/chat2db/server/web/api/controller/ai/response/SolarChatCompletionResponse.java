package ai.chat2db.server.web.api.controller.ai.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
public class SolarChatCompletionResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 4968922211204353592L;
    private ChatCompletionResponse result;
}
