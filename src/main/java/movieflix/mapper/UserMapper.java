package movieflix.mapper;

import lombok.experimental.UtilityClass;
import movieflix.controller.request.UserRequest;
import movieflix.controller.response.UserResponse;
import movieflix.entity.User;


@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request ){
        return User.builder()
                .email(request.email())
                .name(request.name())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .id(user.getId())
                .build();
    }
}

