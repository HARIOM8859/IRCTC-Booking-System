import java.util.HashMap;
import java.util.Map;

public class UserServices {
    private Map<String,User> userMap = new HashMap<>();
    private User currentuser = null;

    public boolean registerUser(String username, String password, String fullname, String Contact){
        if(userMap.containsKey(username)){
            System.out.println("Username already exists please choose different");
            return false;
        }
        User user = new User(username, password, fullname, Contact);
        userMap.put(username,user);
        System.out.println("Registration successfull");
        return true;
    }

    public boolean LoginUser(String username, String Password){
        if(!userMap.containsKey(username)){
            System.out.println("Entered Incorrect Username");
            return false;
        }

        User user = userMap.get(username);
        if(!user.getPassword().equals(Password)){
            System.out.println("Incorrect password");
            return false;
        }
        currentuser = user;
        System.out.println("Welcome : "+currentuser.getFullName()+ "!");
        return true;
    }

    public void logoutuser(){
        if(currentuser != null){
            System.out.println("Loggedd Out "+ currentuser.getFullName());
        }
        currentuser = null;
    }

    public  User getCurrentuser(){
        return currentuser;
    }
    public boolean isloggedin(){
        return currentuser!=null;
    }
}
