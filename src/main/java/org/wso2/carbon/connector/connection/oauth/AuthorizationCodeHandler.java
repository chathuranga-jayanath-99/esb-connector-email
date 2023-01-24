/*
 * Copyright (c) 2023, WSO2 LLC (http://www.wso2.com).
 *
 * WSO2 LLC licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
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

package org.wso2.carbon.connector.connection.oauth;

/**
 * This class is used to handle Authorization code grant oauth.
 */
public class AuthorizationCodeHandler extends OAuthHandler {

    private final String refreshToken;

    public AuthorizationCodeHandler(String username, String clientId, String clientSecret, String refreshToken,
                                    String tokenUrl, String tokenId) {
        super(username, clientId, clientSecret, tokenUrl, tokenId);
        this.refreshToken = refreshToken;
    }

    @Override
    protected String buildTokenRequestPayload() {
        return OAuthConstants.REFRESH_TOKEN_GRANT_TYPE +
                OAuthConstants.PARAM_CLIENT_ID + getClientId() +
                OAuthConstants.PARAM_CLIENT_SECRET + getClientSecret() +
                OAuthConstants.PARAM_REFRESH_TOKEN + refreshToken;
    }
}
