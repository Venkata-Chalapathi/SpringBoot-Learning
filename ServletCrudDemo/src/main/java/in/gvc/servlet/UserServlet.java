package in.gvc.servlet;

import in.gvc.model.User;
import in.gvc.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    public void doGet(HttpServletRequest httpServletRequest,
                      HttpServletResponse httpServletResponse) throws IOException {

        String idParam = httpServletRequest.getParameter("id");

        if(idParam == null){
            // GET ALL USERS
            List<User> users = userService.getAllUsers();
            // return users;
            httpServletResponse.setStatus(200);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(userToJson((User) users));
            return;
        }

        Integer id = Integer.parseInt(idParam);

        User userResp = userService.getUserById(id);

        if(userResp == null){
            // return 404
            httpServletResponse.setStatus(404);
            httpServletResponse.setContentType("application/json");

        }

        // (200 OK) return user;
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(userToJson(userResp));
    }

    @Override
    public void doPost(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws IOException {

        Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));
        String name = httpServletRequest.getParameter("name");
        String email = httpServletRequest.getParameter("email");
        String mobile = httpServletRequest.getParameter("mobile");

        if(id == null || name == null || email == null || mobile == null){
//            return null;
            httpServletResponse.setStatus(400);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Error Found\"\n" +
                            "}"
            );
        }

        User user = new User(id, name, email, mobile);
        User createdUser = userService.createUser(user);
//        return createdUser;
        httpServletResponse.setStatus(201);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User Added Successfully\"\n" +
                        "}"
        );

    }

    @Override
    public void doPut(HttpServletRequest httpServletRequest,
                      HttpServletResponse httpServletResponse) {

    }

    @Override
    public void doDelete(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse) {

    }

    private String userToJson(User user) {
        return "{\n" +
                "    \"id\" : " + user.getId() + ",\n" +
                "    \"name\" : " + user.getName() + ",\n" +
                "    \"email\" : " + user.getEmail() + " ,\n" +
                "    \"mobile\" : " + user.getEmail()+ "\n" +
                "}";
    }

    private String usesrToJson(List<User> users) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < users.size(); i++){
            stringBuilder.append(userToJson(users.get(i)));
            if(i < users.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        
        return stringBuilder.toString();
    }

}
