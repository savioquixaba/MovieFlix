package movieflix.mapper;

import lombok.experimental.UtilityClass;
import movieflix.controller.request.MovieRequest;
import movieflix.controller.response.CategoryResponse;
import movieflix.controller.response.MovieResponse;
import movieflix.controller.response.StreamingResponse;
import movieflix.entity.Category;
import movieflix.entity.Movie;
import movieflix.entity.Streaming;

import java.util.List;

@UtilityClass
public class MovieMapper {
    public static Movie toMovie(MovieRequest request){

        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie){

        List<CategoryResponse> categories = movie.getCategories().stream()
                .map(category -> CategoryMapper.toCategoryResponse(category)).
                        toList();

        List<StreamingResponse> streamings = movie.getStreamings().stream()
                .map(streaming -> StreamingMapper.toStreamingResponse((streaming)))
                .toList();

        return MovieResponse.builder()
                 .id(movie.getId())
                 .title(movie.getTitle())
                 .description(movie.getDescription())
                 .rating(movie.getRating())
                 .releaseDate(movie.getReleaseDate())
                 .categories(categories)
                 .streamings(streamings)
                .build();
    }

}
