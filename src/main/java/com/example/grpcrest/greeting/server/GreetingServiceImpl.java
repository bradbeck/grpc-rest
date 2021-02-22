/*
 * Copyright (c) 2021-present Brad Beck, All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.example.grpcrest.greeting.server;

import com.example.grpcrest.greeting.proto.GreeterGrpc.GreeterImplBase;
import com.example.grpcrest.greeting.proto.HelloRequest;
import com.example.grpcrest.greeting.proto.HelloResponse;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl
    extends GreeterImplBase
{
  @Override
  public void sayHello(
      final HelloRequest request,
      final StreamObserver<HelloResponse> responseObserver)
  {
    responseObserver.onNext(HelloResponse.newBuilder()
        .setMessage("Hello: " + request.getName())
        .build());
    responseObserver.onCompleted();
  }
}
