package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

/**
 * User entity managed by Ebean (TODO: switch to Hibernate)
 */
@Entity 
@Table(name="account")
public class AdminUser extends Model {

    private static final long serialVersionUID = 1L;

	@Id
    @Constraints.Required
    @Formats.NonEmpty
    public String email;
    
    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String password;
    
    // -- Queries
    
    public static Model.Finder<String,AdminUser> find = new Model.Finder<String,AdminUser>(String.class, AdminUser.class);
    
    /**
     * Retrieve all users.
     */
    public static List<AdminUser> findAll() {
        return find.all();
    }

    /**
     * Retrieve a User from email.
     */
    public static AdminUser findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }
    
    /**
     * Authenticate a User.
     */
    public static AdminUser authenticate(String email, String password) {
        return find.where()
            .eq("email", email)
            .eq("password", password)
            .findUnique();
    }
    
    // --
    
    public String toString() {
        return "AdminUser(" + email + ")";
    }

}

