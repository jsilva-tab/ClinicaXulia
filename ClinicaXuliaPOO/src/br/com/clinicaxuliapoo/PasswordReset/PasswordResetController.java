import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/password-reset")
public class PasswordResetController extends HttpServlet {

    private PasswordResetService passwordResetService;

    @Override
    public void init() throws ServletException {
        passwordResetService = new PasswordResetService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        if (email != null && !email.isEmpty()) {
            try {
                passwordResetService.sendPasswordResetEmail(email);
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("Password reset email sent.");
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("Error sending password reset email: " + e.getMessage());
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Email parameter is missing.");
        }
    }
}