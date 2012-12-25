package edu.nyu.pqs.hm1021.ps1;

/*
 * This is a helper class to validate the structure of the email address. The
 * reason behind creating a new class for validation is to separate the
 * validation functionality from the other public classes and keep it
 * package-private.
 * 
 * @author Hiral Mehta
 * 
 */
class EmailAddressValidator {

    private static final String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$|^$";

    protected static boolean isValid(String emailAddress) {
        return (emailAddress.matches(regex));
    }
}