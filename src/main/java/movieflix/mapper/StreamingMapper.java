package movieflix.mapper;

import lombok.experimental.UtilityClass;
import movieflix.controller.request.StreamingRequest;
import movieflix.controller.response.StreamingResponse;
import movieflix.entity.Streaming;

@UtilityClass
public class StreamingMapper {
    public static Streaming toStreaming(StreamingRequest streamingRequest){
        return Streaming.builder()
                .name(streamingRequest.name())
                .build();
    }
    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse.builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
