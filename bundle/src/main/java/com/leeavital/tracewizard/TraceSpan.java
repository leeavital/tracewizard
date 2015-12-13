package com.leeavital.tracewizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.jaxrs.json.annotation.JSONP;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Optional;

import java.util.UUID;

/**
 * Created by lee on 11/8/15.
 */
public final class TraceSpan {

    private final UUID spanId;
    private final Optional<UUID> parentId;

    public TraceSpan(
            @JsonProperty("spanId") String spanId,
            @JsonProperty("parentId") Optional<String> parentId) {

        this.spanId = UUID.fromString(spanId);
        this.parentId = parentId.transform(UUID::fromString);
    }

    public UUID getSpanId() {
        return spanId;
    }

    public Optional<UUID> getParentId() {
        return parentId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("spanId", spanId)
                .add("parentId", parentId)
                .toString();
    }

}
