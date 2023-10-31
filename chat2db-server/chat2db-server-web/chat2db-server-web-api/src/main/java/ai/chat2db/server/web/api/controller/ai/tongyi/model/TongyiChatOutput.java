// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
package ai.chat2db.server.web.api.controller.ai.tongyi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The representation of a single prompt completion as part of an overall completions request. Generally, `n` choices
 * are generated per provided prompt with a default value of 1. Token limits and other settings may limit the number of
 * choices generated.
 */
@Data
public final class TongyiChatOutput {

    /*
     * The generated text for a given completions prompt.
     */
    @JsonProperty(value = "text")
    private String text;

    /*
     * Reason for finishing
     */
    @JsonProperty(value = "finish_reason")
    private String finishReason;

    /**
     * Creates an instance of Choice class.
     *
     * @param text the text value to set.
     * @param finishReason the finishReason value to set.
     */
    @JsonCreator
    private TongyiChatOutput(
            @JsonProperty(value = "text") String text,
            @JsonProperty(value = "finish_reason") String finishReason) {
        this.text = text;
        this.finishReason = finishReason;
    }
}
