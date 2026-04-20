package movieflix.controller;

import lombok.RequiredArgsConstructor;
import movieflix.controller.request.StreamingRequest;
import movieflix.controller.response.StreamingResponse;
import movieflix.entity.Streaming;
import movieflix.mapper.StreamingMapper;
import movieflix.service.StreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> findAllCategories() {
        List<Streaming> categories = streamingService.findAll();
        List<StreamingResponse> list = categories.stream().map(streaming -> StreamingMapper.toStreamingResponse(streaming)).toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping()
    public ResponseEntity<StreamingResponse> saveCategory(@RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = streamingService.save(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getByCategoryId(@PathVariable Long id) {
        return streamingService.findById(id).map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming))).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        streamingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
