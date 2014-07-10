package standard.mvc.component.security.custom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
//3dr part 인증 정보 체크 - ldap 등등
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
