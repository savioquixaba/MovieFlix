package movieflix.service;

import lombok.RequiredArgsConstructor;
import movieflix.entity.Category;
import movieflix.entity.Streaming;
import movieflix.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public List<Streaming> findAll(){
        return streamingRepository.findAll();
    }

    public Streaming save(Streaming streaming){
        return streamingRepository.save(streaming);
    }

    public Optional<Streaming> findById(Long id){
        return streamingRepository.findById(id);
    }

    public void delete(Long id){
        streamingRepository.deleteById(id);
    }
}
