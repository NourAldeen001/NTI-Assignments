package records;// Exercise 5.10 — Capstone: DTO Conversion with Validation
//
// TODO 1: Define record CreateUserRequest(String username, String email) with
//         a compact constructor that:
//         - throws IllegalArgumentException if username is blank
//         - throws IllegalArgumentException if email doesn't contain "@"
// TODO 2: Implement processSignup(request) to print a welcome message using accessors.
// TODO 3: Test with one valid and one invalid request (catch the exception).

// TODO 1: define CreateUserRequest
record CreateUserRequest(String username, String email) {
    CreateUserRequest {
        if(username == null || username.isBlank()) throw new IllegalArgumentException("username must not be blank or empty");
        if(!email.contains("@")) throw new IllegalArgumentException("email must contains @");
    }
}

public class Exercise5_10_SignupCapstone {

    static void processSignup(CreateUserRequest request) {
        // TODO 2: print a welcome message using request's accessors
        System.out.println("Welcome, " + request.username() + " with Email: " + request.email());
    }

    public static void main(String[] args) {
        // TODO 3: test with a valid request, then an invalid one (catch and print the error)
        CreateUserRequest valid = new CreateUserRequest("Nour", "Nour@gmail.com");
        CreateUserRequest invalid = new CreateUserRequest("No", "Nourgmail.com");

        processSignup(valid);
        processSignup(invalid);

    }
}
