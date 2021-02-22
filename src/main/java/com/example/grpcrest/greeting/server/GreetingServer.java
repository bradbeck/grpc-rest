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

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingServer
{
  private static final Logger LOG = LoggerFactory.getLogger(GreetingServer.class);

  public static void main(String[] args) throws Exception {
    LOG.info("Starting Greeting gRPC Server");

    // Plain-text server
    Server server = ServerBuilder.forPort(50051)
        .addService(new GreetingServiceImpl())
        .addService(ProtoReflectionService.newInstance())
        .build();

    server.start();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      LOG.info("Received shutdown request");
      server.shutdown();
      LOG.info("Shutdown successful");
    }));

    server.awaitTermination();
  }
}
