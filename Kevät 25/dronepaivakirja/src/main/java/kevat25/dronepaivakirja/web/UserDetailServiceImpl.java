package kevat25.dronepaivakirja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kevat25.dronepaivakirja.domain.Kayttaja;
import kevat25.dronepaivakirja.domain.KayttajaRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	
	@Autowired
	KayttajaRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	Kayttaja curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getSalasanaHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
} 



