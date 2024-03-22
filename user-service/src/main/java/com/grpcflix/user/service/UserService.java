package com.grpcflix.user.service;

import net.devh.boot.grpc.server.service.GrpcService;
import com.example.grpcflix.user.UserServiceGrpc;

@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {
}
