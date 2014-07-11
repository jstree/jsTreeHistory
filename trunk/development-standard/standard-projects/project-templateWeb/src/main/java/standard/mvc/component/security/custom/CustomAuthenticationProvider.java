package standard.mvc.component.security.custom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 *  Class Name : CustomAuthenticationProvider.java
 *  Description : security 3.0.1b 간소화 설정으로 확장 커스터 마이징 불가 하며 확장성에 대한 검토가 필요하다. (3dr part 인증 정보 체크 - ldap 등등) 
 *  Modification Information
 * 
 *  @author 최대열
 *  @since 2014.07.10
 *  @version 1.0
 *  @see
 *
 *  <pre>
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.10                 최대열		   최초 생성
 *
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication){
	       String name = authentication.getName();
	        String password = authentication.getCredentials().toString();
	 
	        // use the credentials to try to authenticate against the third party system
	        if (authenticatedAgainstThirdPartySystem()) {
	            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
	            return new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
	        } else {
	        	return null;
	        }
	}

	private boolean authenticatedAgainstThirdPartySystem() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
