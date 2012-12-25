package edu.nyu.pqs.hm1021.ps1;

import java.util.StringTokenizer;

/*
 * This is a helper class to convert a ContactEntry to a string and convert it
 * back to ContactEntry. Provides static methods (not the design
 * pattern). This is not part of the API.
 * 
 * @author Hiral Mehta
 * 
 */
class ConversionHelper {

    /*
     * Convert the ContactEntry object to a String representation
     */
    protected static String buildStringFromContact(ContactEntry contact) {
        String out = contact.getName().getFirstName() + " ;;"
                + contact.getName().getLastName() + " ;;"
                + contact.getName().getMiddleName() + " ;;"
                + contact.getPhoneNumber().getPhoneNum() + " ;;"
                + contact.getPostalAddress().getApt() + " ;;"
                + contact.getPostalAddress().getStreet() + " ;;"
                + contact.getPostalAddress().getCity() + " ;;"
                + contact.getPostalAddress().getState() + " ;;"
                + contact.getPostalAddress().getZip() + " ;;"
                + contact.getPostalAddress().getCountry() + " ;;"
                + contact.getEmailId().getEmailId() + " ;;" + contact.getNote()
                + " ;;\n";

        return out;
    }

    /*
     * Convert the String object to a build a ContactEntry object
     */
    protected static ContactEntry buildContact(StringTokenizer contactDetails) {

        String firstName = contactDetails.nextToken().trim();
        String lastName = contactDetails.nextToken().trim();
        String middleName = contactDetails.nextToken().trim();
        String phone = contactDetails.nextToken().trim();
        String apt = contactDetails.nextToken().trim();
        String street = contactDetails.nextToken().trim();
        String city = contactDetails.nextToken().trim();
        String state = contactDetails.nextToken().trim();
        String zip = contactDetails.nextToken().trim();
        String country = contactDetails.nextToken().trim();
        String emailId = contactDetails.nextToken().trim();
        String note = contactDetails.nextToken().trim();

        ContactName name = buildName(firstName, lastName, middleName);
        PhoneNumber phoneNum = new PhoneNumber(phone);
        PostalAddress addr = buildPostalAddress(apt, street, city, state, zip,
                country);
        EmailAddress email = new EmailAddress(emailId);

        ContactEntry contact = new ContactEntry.Builder(name, phoneNum)
                .postalAddress(addr).emailId(email).note(note).build();
        return contact;
    }

    private static PostalAddress buildPostalAddress(String apt, String street,
            String city, String state, String zip, String country) {

        return new PostalAddress.Builder(country).apt(apt).street(street)
                .city(city).state(state).zip(zip).build();
    }

    private static ContactName buildName(String firstName, String lastName,
            String middleName) {
        return new ContactName.Builder(firstName).lastName(lastName)
                .middleName(middleName).build();
    }
}
