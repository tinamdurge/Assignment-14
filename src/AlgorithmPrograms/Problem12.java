package AlgorithmPrograms;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Problem12 {
    public static void main(String[] args) {
        String message = "Hello <<name>>, We have your full name as <<full name>> in our system. Your contact number is 91-xxxxxxxxxx. Please, let us know in case of any clarification. Thank you BridgeLabz 01/01/2016.";

        System.out.println("\nInput message: " + message);

        // replacing first name
        String firstName = "Chinmay";
        message = message.replaceAll("<<name>>", firstName);

        // replacing full name
        String fullName = "Chinmay Bhalodia";
        message = message.replaceAll("<<full name>>", fullName);

        // replace phone number
        String phone = "91-9313402393";
        message = message.replaceAll("91-\\d{10}", phone);

        // replace the date
        String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", currentDate);

        // printing updated message
        System.err.println("\nModified message: " + message);
    }
}
