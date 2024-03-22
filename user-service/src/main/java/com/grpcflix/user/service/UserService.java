package com.grpcflix.user.service;

import com.example.grpcflix.common.Genre;
import com.example.grpcflix.user.UserGenreUpdateRequest;
import com.example.grpcflix.user.UserResponse;
import com.example.grpcflix.user.UserSearchRequest;
import com.grpcflix.user.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import com.example.grpcflix.user.UserServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void getUserGenre(UserSearchRequest request, StreamObserver<UserResponse> responseObserver) {
        UserResponse.Builder builder = UserResponse.newBuilder();
        this.userRepository.findById(request.getLoginId())
                .ifPresent(user -> {
                    builder.setName(user.getName())
                            .setLoginId(user.getLogin())
                            .setGenre(Genre.valueOf(user.getGenre().toUpperCase()));
                });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateUserGenre(UserGenreUpdateRequest request, StreamObserver<UserResponse> responseObserver) {
        super.updateUserGenre(request, responseObserver);
    }
}
