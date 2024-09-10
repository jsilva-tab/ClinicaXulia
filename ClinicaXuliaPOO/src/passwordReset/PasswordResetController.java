package passwordReset;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/forgot-password")
public class PasswordResetController extends HttpServlet {

    private PasswordResetService passwordResetService = new PasswordResetService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        if (email != null && !email.isEmpty()) {
            passwordResetService.sendPasswordResetEmail(email);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Password reset email sent.");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Email parameter is missing.");
        }
    }
}