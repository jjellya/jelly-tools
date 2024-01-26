package edu.dev.backend.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Create By  @林俊杰
 * 2022/3/18 19:38
 *
 * @version 1.0
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
