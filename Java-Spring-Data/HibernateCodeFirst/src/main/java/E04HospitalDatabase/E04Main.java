package E04HospitalDatabase;

import E04HospitalDatabase.entities.Patient;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Scanner;

import static E04HospitalDatabase.Strings.*;

public class E04Main {
    private static Scanner scanner = new Scanner(System.in);
    private static EntityManager em = Persistence
            .createEntityManagerFactory("HibernateCodeFirst")
            .createEntityManager();


    //I will finish this at some point in the future - https://github.com/haibusa1991/Java-Spring-Data/tree/main/HibernateCodeFirst
    public static void main(String[] args) {
        System.out.println(MAIN_MENU);

        int choice;
        choice = Integer.parseInt(scanner.nextLine());

        while (choice != 0) {
            switch (choice) {
                case 1 -> addPatient();
//                case 2 -> findPatient();
//                case 3 -> addDiagnose();
//                case 4 -> addMedicament();
//                case 5 -> addVisitation();
            }

            System.out.println(MAIN_MENU);
            choice = Integer.parseInt(scanner.nextLine());
        }
    }

    private static void addPatient() {
        System.out.println(ADD_PATIENT_HINT);

        String input = scanner.nextLine();
        String firstName = "";
        String lastName = "";
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        boolean isInsured = false;
        String address = "";

        while (!input.equals("0")) {
            String[] data = input.split("\\s+");
            boolean hasToExit = true;

            try {
                if (data.length != 5) {
                    throw new IllegalArgumentException(ERROR_INVALID_NUMBER_OF_ARGUMENTS);
                }

                firstName = data[0];
                if (isInvalidName(firstName)) throw new IllegalArgumentException(ERROR_FIRST_NAME_IS_INVALID);

                lastName = data[1];
                if (isInvalidName(lastName)) throw new IllegalArgumentException(ERROR_LAST_NAME_IS_INVALID);

                birthDate = getBirthday(data[2]);

                isInsured = getInsuredStatus(data[3]);

                address = data[4];

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(ADD_PATIENT_HINT);
                hasToExit = false;
            }

            if (hasToExit) {
                break;
            }

            input = scanner.nextLine();
        }

        if (input.equals("0")) return;

        if(getPatientByNameAndBirthdate(firstName, lastName, birthDate) != null){
            System.out.printf(ERROR_PATIENT_ALREADY_EXISTS,firstName,lastName,birthDate);
            return;
        }

        Patient patient = new Patient(firstName, lastName, birthDate, isInsured, address);
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();
        System.out.printf(PATIENT_ADDED_SUCCESSFULLY,firstName,lastName,birthDate);
    }

    private static boolean isInvalidName(String s) {
        for (char c : s.toLowerCase().toCharArray()) {
            if (c != 45 && c != 39 && (c < 97 || c > 122)) {
                return true;
            }
        }
        return false;
    }

    private static LocalDate getBirthday(String s) {
        int day;
        int month;
        int year;

        try {
            day = Integer.parseInt(s.split("\\.")[0]);
            month = Integer.parseInt(s.split("\\.")[1]);
            year = Integer.parseInt(s.split("\\.")[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_BIRTHDATE_IS_INVALID);
        }

        return LocalDate.of(year, month, day);
    }

    private static boolean getInsuredStatus(String s) {
        boolean result;

        switch (s.toLowerCase()) {
            case "yes" -> result = true;
            case "no" -> result = false;
            default -> throw new IllegalArgumentException(ERROR_INSURED_STATUS_INVALID);
        }
        return result;
    }

    private static Patient getPatientByNameAndBirthdate(String firstName, String lastName, LocalDate birthDate) {
        return em.createQuery("""
                        SELECT p
                        FROM e04_patients p
                        WHERE p.firstName = :fName AND p.lastName = :lName AND p.birthDate = :bDate
                        """, Patient.class)
                .setParameter("fName", firstName)
                .setParameter("lName", lastName)
                .setParameter("bDate", birthDate)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }
}
