import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@ManagedBean
@SessionScoped
public class LoginBean {

    @PersistenceContext
    private EntityManager entityManager;

    private String email;
    private String password;

    private Student loggedInStudent;

    public String login() {
        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.email = :email", Student.class);
        query.setParameter("email", email);

        try {
            Student student = query.getSingleResult();

            if (student.getPassword().equals(password)) {
                loggedInStudent = student;
                return "home?faces-redirect=true"; // Redirect to the home page on successful login
            } else {
                // Incorrect password
                return "login?faces-redirect=true&error=invalid-password";
            }
        } catch (NoResultException e) {
            // No student found with the given email
            return "login?faces-redirect=true&error=user-not-found";
        }
    }

    public String logout() {
        loggedInStudent = null;
        return "login?faces-redirect=true";
    }

    // Getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getLoggedInStudent() {
        return loggedInStudent;
    }

    public void setLoggedInStudent(Student loggedInStudent) {
        this.loggedInStudent = loggedInStudent;
    }
}


/*
<h:head>
    <!-- Other head elements -->
    <script src="https://apis.google.com/js/platform.js" async defer></script>
</h:head>
<h:form>
    <!-- Other form elements -->
    <p:commandButton value="Sign in with Google" action="#{googleSignInBean.processGoogleSignIn}" />
</h:form>
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class GoogleSignInBean {

    public void processGoogleSignIn() {
        String idToken = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id_token");

        // Verify the idToken using Google's API (e.g., Google's tokeninfo endpoint).
        // Handle the user information obtained from the idToken.
    }
}
<h:form>
    <!-- Other form elements -->
    <p:commandButton value="Sign in with Google" onclick="googleSignIn()" />
</h:form>

<script>
    function googleSignIn() {
        gapi.auth2.getAuthInstance().signIn().then(onSignIn);
    }

    function onSignIn(googleUser) {
        // Handle the sign-in process, e.g., send user information to the server.
    }
</script>

<h:form>
    <!-- Other form elements -->
    <p:outputPanel>
        <p:commandButton id="googleSignInButton" styleClass="google-sign-in-button"
                         onclick="googleSignIn()" icon="fa fa-google">
            Sign in with Google
        </p:commandButton>
    </p:outputPanel>
</h:form>

<script>
    function googleSignIn() {
        gapi.auth2.getAuthInstance().signIn().then(onSignIn);
    }

    function onSignIn(googleUser) {
        // Handle the sign-in process, e.g., send user information to the server.
    }
</script>
.google-sign-in-button {
    background-color: #4285F4; /* Google Blue */
    color: #fff;
            font-weight: bold;
            }

 */