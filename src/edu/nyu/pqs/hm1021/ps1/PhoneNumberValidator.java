package edu.nyu.pqs.hm1021.ps1;

/*
 * This is a helper class that validates phone number for a particular
 * structure. The reason behind creating a new class for validation is to
 * separate the validation functionality from the other public classes and keep
 * it package-private.<br>
 * Imposes some restrictions on the structure of the number. A
 * valid phone number can only contain 0-9, +, *, #, -. There is not
 * restrictions on the length of the phone number. Also, there is no restriction
 * on the format in which user wants to store the phone number.
 * 
 * @author Hiral Mehta
 * 
 */
class PhoneNumberValidator {

    private static final String regex = "^[-0-9*#+]+$|^$";

    protected static boolean isValid(String phoneNum) {
        return (phoneNum.matches(regex));
    }
}
