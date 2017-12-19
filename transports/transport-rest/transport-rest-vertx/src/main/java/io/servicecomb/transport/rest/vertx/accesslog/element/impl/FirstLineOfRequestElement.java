/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.transport.rest.vertx.accesslog.element.impl;

import io.servicecomb.transport.rest.vertx.accesslog.AccessLogParam;
import io.servicecomb.transport.rest.vertx.accesslog.element.AccessLogElement;

public class FirstLineOfRequestElement implements AccessLogElement {
  private static final MethodElement METHOD_ELEMENT = new MethodElement();

  private static final UriPathOnlyElement URI_PATH_ONLY_ELEMENT = new UriPathOnlyElement();

  private static final VersionOrProtocolElement VERSION_OR_PROTOCOL_ELEMENT = new VersionOrProtocolElement();

  @Override
  public String getFormattedElement(AccessLogParam accessLogParam) {
    StringBuilder result = new StringBuilder(64)
        .append("\"")
        .append(METHOD_ELEMENT.getFormattedElement(accessLogParam))
        .append(" ")
        .append(URI_PATH_ONLY_ELEMENT.getFormattedElement(accessLogParam))
        .append(" ")
        .append(VERSION_OR_PROTOCOL_ELEMENT.getFormattedElement(accessLogParam))
        .append("\"");

    return result.toString();
  }
}