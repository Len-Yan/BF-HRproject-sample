package com.beaconfire.springsecurityauth.dao;

import com.beaconfire.springsecurityauth.domain.RegistrationToken;
import com.beaconfire.springsecurityauth.domain.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository("userAuthDao")
public class UserDao  extends AbstractHibernateDAO<User> {

//    public UserDao() {
//        setClazz(User.class);
//    }


    // should be stored in the database
    // user table,permission table
//    private final List<User> users = Arrays.asList(
//            new User("Oliver", "Oliver", Arrays.asList("read")),
//            new User("Tracy", "Tracy", Arrays.asList("write")),
//            new User("Zack", "Zack", Arrays.asList("delete", "read", "update", "write"))
//    );
//
    public Optional<User> loadUserByUsername(String username){

        Query query = getCurrentSession().createQuery("from User u join fetch u.roleSet where u.username = :username");
        query.setParameter("username", username);
        List<User> userList = query.getResultList();
        return Optional.ofNullable(userList.get(0));
//        return users.stream().filter(user -> username.equals(user.getUsername())).findAny();
    }

    //create account
    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    public String getTokenByEmail(String email) {
        Query query = getCurrentSession().createQuery("from RegistrationToken rt where rt.email = :email");
        query.setParameter("email", email);
        List<RegistrationToken> tokenList = query.getResultList();
//        System.out.println("aaaaaaaa" + tokenList.get(0).getToken());
//        System.out.println(tokenList);
        return (tokenList == null || tokenList.size() == 0) ? "NULL" : tokenList.get(0).getToken();
    }

    //generate token
    public void addToken(RegistrationToken token) {
        getCurrentSession().save(token);
    }

}
