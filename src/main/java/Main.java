import dal.IUserDAO;
import dal.UserDAOImpls185014;
import dal.dto.IUserDTO;
import dal.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IUserDAO.DALException {

        UserDAOImpls185014 myUserDAO = new UserDAOImpls185014();
        IUserDTO user;

        // CREATES INSTANCE OF USER
        System.out.println("*** Create user with userId = 185014, userName = KaraldBruun, ini = habr, roles = Student;Programmer ***");
        UserDTO test = new UserDTO();
        // Creates array with roles (Not very beautiful, but it works)
        List<String> roles = new ArrayList<String>();
        roles.add("Student;Programmer");
        //Inserts info
        test.setUserId(185014); test.setUserName("KaraldBruun"); test.setIni("habr"); test.setRoles(roles);
        myUserDAO.createUser(test);

        // GETS USER
        user = myUserDAO.getUser(185014);
        System.out.println("*** INFO FOR USERID: " + user.getUserId()+ " ***");
        System.out.println(user.getUserId()+"; "+user.getUserName()+"; "+user.getIni()+"; "+user.getRoles());


        System.out.println("*** Updating name as there's a spelling mistake in username ***");
        test.setUserName("HaraldBruun");
        myUserDAO.updateUser(test);
        user = myUserDAO.getUser(185014);
        // Now that I've corrected the username, I can receive

        // GETS USERNAMELIST
        System.out.println("*** GET USERNAMELIST WITH ID: " + user.getUserId()+ " ***");
        List<IUserDTO> users = myUserDAO.getUserList();
        for(int i=0;i<users.size();i++){
            System.out.println(users.get(i).getUserName());
        }
        // Deletes user and all its info.
        myUserDAO.deleteUser(185014);
        System.out.println("*** USERID: " + user.getUserId() + " HAS BEEN DELETED ***");
        }
}