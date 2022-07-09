package E04HospitalDatabase;

public class Strings {
    public static final String MAIN_MENU = """
            1. Add new patient
            2. Find patient id by name and birth date
            3. Add diagnose for a patient
            4. Add medicament for a patient
            5. Add visitation of patient
                            
            0. Exit""";

    public static final String ADD_PATIENT_HINT = """
            Please enter patient data in the following format:
            1. First name
            2. Last name
            3. Date of birth - DD.MM.YYYY
            4. Is insured - Yes/No
            5. Address

            eg.
            Ivan Ivanov 31.12.1999 No
            
            Type 0 to return to main menu""";


    private static final String NAME_IS_INVALID = " name is invalid. Names can contain latin letters, apostrophes (') and dashes (-) only!";

    public static final String ERROR_INVALID_NUMBER_OF_ARGUMENTS = "Data entered is incomplete or has extra information!";
    public static final String ERROR_FIRST_NAME_IS_INVALID = "First" + NAME_IS_INVALID;
    public static final String ERROR_LAST_NAME_IS_INVALID = "Last" + NAME_IS_INVALID;

    public static final String ERROR_BIRTHDATE_IS_INVALID = "Invalid birth date. Format should be DD.MM.YYYY separated by a dot (.)";
    public static final String ERROR_INSURED_STATUS_INVALID = "Invalid insured status. Should be \"yes\" or \"no\"";
    public static final String ERROR_PATIENT_ALREADY_EXISTS = "Patient by the name %s %s born on %s already exist in the database!%n";

    public static final String PATIENT_ADDED_SUCCESSFULLY = "Patient by the name %s %s born on %s successfully added to the database!%n";

}
