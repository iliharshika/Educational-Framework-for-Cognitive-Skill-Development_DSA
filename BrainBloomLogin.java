import java.util.*;

class OTPService {

    static int generateOTP() {

        Random r = new Random();
        return 1000 + r.nextInt(9000);

    }
}
public class BrainBloomLogin {

    static Scanner sc = new Scanner(System.in);

    static void login() {

        System.out.println("===== BrainBloom Login =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        int otp = OTPService.generateOTP();

        System.out.println("\nOTP sent to your phone: " + otp);

        System.out.print("Enter OTP: ");
        int userOTP = sc.nextInt();

        if (userOTP == otp) {

            System.out.println("\nLogin Successful!");
            dashboard();

        } else {

            System.out.println("Invalid OTP. Login Failed.");

        }
    }

    static void dashboard() {

        while (true) {

            System.out.println("\n===== BrainBloom Dashboard =====");

            System.out.println("1. LogicLens");
            System.out.println("2. DecisionDash");
            System.out.println("3. MathSprint");
            System.out.println("4. WordRush");
            System.out.println("5. RecallRush");
            System.out.println("6. SpeedSolve");
            System.out.println("7. Exit");

            System.out.print("Select Option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    LogicLens.main(null);
                    break;

                case 2:
                    DecisionDash.main(null);
                    break;

                case 3:
                    MathSprint.main(null);
                    break;

                case 4:
                    WordRush.main(null);
                    break;

                case 5:
                    RecallRush.main(null);
                    break;

                case 6:
                    SpeedSolve.main(null);
                    break;

                case 7:
                    System.out.println("Exiting BrainBloom...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
    }

    public static void main(String[] args) {

        login();

    }
}