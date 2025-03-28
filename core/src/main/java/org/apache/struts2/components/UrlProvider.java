/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.struts2.components;

import org.apache.struts2.util.ValueStack;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Implementations of this interface can be used to build a URL
 */
public interface UrlProvider {
    /**
     * The includeParams attribute may have the value 'none', 'get' or 'all'.
     * It is used when the url tag is used without a value attribute.
     * Its value is looked up on the ValueStack
     * If no includeParams is specified then 'get' is used.
     * none - include no parameters in the URL
     * get  - include only GET parameters in the URL (default)
     * all  - include both GET and POST parameters in the URL
     */
    String NONE = "none";
    String GET = "get";
    String ALL = "all";

    boolean isPutInContext();

    String getVar();

    String getValue();

    String findString(String value);

    void setValue(String string);

    String getUrlIncludeParams();

    String getIncludeParams();

    Map<String, Object> getParameters();

    HttpServletRequest getHttpServletRequest();

    String getAction();

    ExtraParameterProvider getExtraParameterProvider();

    String getScheme();

    String getNamespace();

    String getMethod();

    HttpServletResponse getHttpServletResponse();

    boolean isIncludeContext();

    boolean isEncode();

    boolean isForceAddSchemeHostAndPort();

    boolean isEscapeAmp();

    String getPortletMode();

    String getWindowState();

    String determineActionURL(String action, String namespace, String method, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Map<String, ?> parameters, String scheme, boolean includeContext, boolean encode, boolean forceAddSchemeHostAndPort, boolean escapeAmp);

    String determineNamespace(String namespace, ValueStack stack, HttpServletRequest req);

    String getAnchor();

    String getPortletUrlType();

    ValueStack getStack();

    void setUrlIncludeParams(String urlIncludeParams);

    void setHttpServletRequest(HttpServletRequest req);

    void setHttpServletResponse(HttpServletResponse res);

    void setUrlRenderer(UrlRenderer urlRenderer);

    void setExtraParameterProvider(ExtraParameterProvider provider);

    void setIncludeParams(String includeParams);

    void setScheme(String scheme);

    void setAction(String action);

    void setPortletMode(String portletMode);

    void setNamespace(String namespace);

    void setMethod(String method);

    void setEncode(boolean encode);

    void setIncludeContext(boolean includeContext);

    void setWindowState(String windowState);

    void setPortletUrlType(String portletUrlType);

    void setAnchor(String anchor);

    void setEscapeAmp(boolean escapeAmp);

    void setForceAddSchemeHostAndPort(boolean forceAddSchemeHostAndPort);

    void putInContext(String result);
}
