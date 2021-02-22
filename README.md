<!--

    Copyright (c) 2021-present Brad Beck, All rights reserved.

    This program is licensed to you under the Apache License Version 2.0,
    and you may not use this file except in compliance with the Apache License Version 2.0.
    You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.

    Unless required by applicable law or agreed to in writing,
    software distributed under the Apache License Version 2.0 is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.

-->
# Table of Contents

* [Description](#description)
* [Usage](#usage)
* [References](#references)

## Description

An example using a transforming proxy in front of a gRPC service to allow both gRPC and REST traffic
over a single port.

## Usage

```bash
$ mvn clean package
$ docker compose up
```

HTTP REST usage example:
```bash
$ http :5000/say name=Barney
HTTP/1.1 200 OK
content-length: 32
content-type: application/json
date: Thu, 18 Mar 2021 18:44:50 GMT
grpc-accept-encoding: gzip
grpc-encoding: identity
grpc-status: 0
server: envoy
x-envoy-upstream-service-time: 4

{
    "message": "Hello: Barney"
}
```

Evans usage example:
```bash
$ evans -r -p 5000 repl
...
greet.Greeter@127.0.0.1:5000> call SayHello
name (TYPE_STRING) => Fred
{
  "message": "Hello: Fred"
}
```

## References

* <https://cloud.google.com/apis/design>
* <https://grpc.io>
* <https://github.com/salesforce/reactive-grpc>
* <https://github.com/ECF/grpc-osgi-generator>
* <https://www.envoyproxy.io>
* <https://github.com/ktr0731/evans>
* <https://github.com/uw-labs/bloomrpc>
