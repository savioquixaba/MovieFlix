package movieflix.service;

import lombok.RequiredArgsConstructor;
import movieflix.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
}
