package incovid.db;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserLogged {
    private String username;

    public UserLogged(){WhoIsLogged();}

    private void WhoIsLogged(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            username = currentUserName;
        }
    }

    public String getUser(){return username;}
}
