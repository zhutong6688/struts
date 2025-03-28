/*
 * $Id$
 *
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
package org.apache.struts2.showcase.chat;

import org.apache.struts2.ActionSupport;

import java.util.Map;

import org.apache.struts2.action.SessionAware;

public class ChatLogoutAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private ChatService chatService;

	private Map<String, Object> session;


	public ChatLogoutAction(ChatService chatService) {
		this.chatService = chatService;
	}

	public String execute() throws Exception {

		User user = (User) session.get(ChatAuthenticationInterceptor.USER_SESSION_KEY);
		if (user != null) {
			chatService.logout(user.getName());
			session.remove(ChatAuthenticationInterceptor.USER_SESSION_KEY);
		}

		return SUCCESS;
	}


    @Override
    public void withSession(Map<String, Object> session) {
        this.session = session;
    }
}
