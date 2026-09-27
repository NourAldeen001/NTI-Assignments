package streams;

import java.util.List;

// Exercise 3.6 — anyMatch / allMatch / noneMatch
//
// TODO 1: Is there any password longer than 7 characters?
// TODO 2: Do all passwords have at least 5 characters?
// TODO 3: Is there no password that equals exactly "admin"?

public class Exercise3_6_MatchOperations {

    public static void main(String[] args) {
        List<String> passwords = List.of("abc123", "password", "Xy9!zK2q", "12345");

        // TODO 1, 2, 3: implement and print all three checks
        boolean ques1 = passwords.stream().anyMatch(pass -> pass.length() > 7);
        boolean ques2 = passwords.stream().allMatch(pass -> pass.length() >= 5);
        boolean ques3 = passwords.stream().noneMatch(pass -> pass.equals("admin"));

        System.out.println("Ques 1: " + ques1);
        System.out.println("Ques 2: " + ques2);
        System.out.println("Ques 3: " + ques3);

    }
}
