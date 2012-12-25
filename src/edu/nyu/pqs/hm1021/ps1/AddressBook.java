package edu.nyu.pqs.hm1021.ps1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * AddressBook provides a well defined API to an application developer to add a
 * contact to the address book, remove a contact from the address book, also
 * search for a contact by name, first name, last name, phone number, postal
 * address, email address, note or through a substring of these properties.
 * Also, two methods to save/load the address book to/from a file from/to the
 * main memory.
 * 
 * @author Hiral Mehta
 * 
 */
public class AddressBook {

    private List<ContactEntry> addressBook;

    private enum SearchByType {
        NAME, FIRSTNAME, LASTNAME, PHONENUMBER, POSTALADDRESS, EMAILID, NOTE, SUBSTRING
    };

    /**
     * Constructs a new address book
     */
    public AddressBook() {
        addressBook = new ArrayList<ContactEntry>();
    }

    /**
     * Adds an entry to the address book. If an entry with same parameters
     * exists, the address book will store duplicates of the same contact.
     * 
     * @param contact
     *            An object of ContactEntry to be added
     * @return true if the contact gets saved successfully <br>
     *         false if contact is null
     */
    public boolean addContactEntry(ContactEntry contact) {
        if (contact == null)
            return false;
        return addressBook.add(contact);
    }

    /**
     * Removes a contact entry from the address book. If two copies of the same
     * contact exist, removeContactEntry() will remove the first occurrence
     * only. The idea behind this design is that, user will first search for the
     * entry that they would like to remove and search method returns a list of
     * contacts that matched, and then user is allowed to select any one of them
     * and pass it to removeContactEntry().
     * 
     * @param contact
     *            An object of ContactEntry to be removed
     * @return true if the contact is removed successfully <br>
     *         false if contact is null
     */
    public boolean removeContactEntry(ContactEntry contact) {
        if (contact == null)
            return false;
        return addressBook.remove(contact);
    }

    /**
     * Searches through out the address book for the substring passed by the
     * user. Returns list of contacts whose any parameters matched the substring. <br>
     * e.g. "Joey Tribbiani" will match "Trib" but will not match
     * "Joey M. Tribbiani".
     * 
     * @param searchString
     *            Substring to be searched
     * @return A list of contacts whose parameters contains the input substring
     */
    public List<ContactEntry> searchBySubString(String searchString) {
        return searchContact(SearchByType.SUBSTRING, searchString);
    }

    /**
     * Searches throughout the address book for the contact whose full name
     * matches the full name given as input.
     * 
     * @param name
     *            Full name of the person to be searched
     * @return A list of contacts whose full name matched the given input name.
     */
    public List<ContactEntry> searchContactByFullName(ContactName name) {
        return searchContact(SearchByType.NAME, name);
    }

    /**
     * Searches through out the address book for the contact whose first name
     * matches the first name given as input. This method is provided to
     * add some more flexibility for the user of the API. To search for a part of the
     * first name, use searchBySubstring() method.
     * 
     * @param name
     *            First name of the person to be searched
     * @return A list of contacts whose first name matched the given input name.
     */
    public List<ContactEntry> searchContactByFirstName(ContactName name) {
        return searchContact(SearchByType.FIRSTNAME, name);
    }

    /**
     * Searches through out the address book for the contact whose last name
     * matches the last name given as input. To search for a part of the
     * last name, use searchBySubstring() method.
     * 
     * @param name
     *            Last name of the person to be searched
     * @return A list of contacts whose last name matched the given input name
     */
    public List<ContactEntry> searchContactByLastName(ContactName name) {
        return searchContact(SearchByType.LASTNAME, name);
    }

    /**
     * Searches through out the address book for the contact whose phone number
     * matches the phone number provided as input. To search for a part of the
     * phone number, use searchBySubstring() method.
     * 
     * @param number
     *            Phone number to be searched
     * @return A list of contacts whose phone number matched the given number
     */
    public List<ContactEntry> searchContactByPhoneNumber(PhoneNumber number) {
        return searchContact(SearchByType.PHONENUMBER, number);
    }

    /**
     * Searches through out the address book for the contact whose Postal
     * Address matches the address given as input. To search for only substring
     * of the address, use searchBySubstring().
     * 
     * @param name
     *            Complete postal address of the person to be searched
     * @return A list of contacts whose postal address matched the given input.
     */
    public List<ContactEntry> searchContactByPostalAddress(PostalAddress address) {
        return searchContact(SearchByType.POSTALADDRESS, address);
    }

    /**
     * Searches through out the address book for the contact whose email address
     * matches the email address given as input. To search for a part of the
     * email address, use searchBySubstring() method.
     * 
     * @param name
     *            Complete email address of the person to be searched
     * @return A list of contacts whose email address matched the given input
     */
    public List<ContactEntry> searchContactByEmailAddress(EmailAddress emailId) {
        return searchContact(SearchByType.EMAILID, emailId);
    }

    /**
     * Searches through out the address book for the contact whose saved note
     * matches the note given as input. To search for a part of the note, use
     * searchBySubstring() method.
     * 
     * @param name
     *            Note of the person to be searched
     * @return A list of contacts whose note matched the given input
     */
    public List<ContactEntry> searchContactByNote(String note) {
        return searchContact(SearchByType.NOTE, note);
    }

    /**
     * Saves the address book which is currently in memory, to a file in disk
     * storage. If the file specified by the user already exists the its
     * contents are first deleted and then contacts are written to a fresh file.
     * 
     * @param file
     *            File object representing file to be saved
     * @throws IOException
     *             If the file could not be written
     */
    public void save(File file) throws IOException {
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        FileOutputStream fileout = new FileOutputStream(file);
        OutputStreamWriter out = new OutputStreamWriter(fileout);

        for (ContactEntry contact : this.addressBook) {
            String tmp = ConversionHelper.buildStringFromContact(contact);
            out.write(tmp);

        }
        out.close();
    }

    /**
     * Reads address book from a file in disk storage to an object in memory. It
     * requires that the file exists.
     * 
     * @param file
     *            Name of the file which contains address book in raw format
     * @return A List of ContactEntry objects read from the file given as input
     * @throws FileNotFoundException
     *             If the file does not exist
     * @throws IOException
     *             If the file could not be read
     */
    public List<ContactEntry> read(File file) throws FileNotFoundException,
            IOException {
        FileInputStream filein = new FileInputStream(file);
        InputStreamReader in = new InputStreamReader(filein);
        
        Scanner scanner = new Scanner(in);

        List<ContactEntry> contacts = new ArrayList<ContactEntry>();

        while (scanner.hasNextLine()) {
            StringTokenizer tmp = new StringTokenizer(scanner.nextLine(), ";;");

            ContactEntry contact = ConversionHelper.buildContact(tmp);
            contacts.add(contact);

        }

        scanner.close();
        in.close();
        return contacts;

    }

    /*
     * This search method serves as a helper method to the public search
     * methods. It takes the common code out of the above functions to keep the
     * code DRY. It is again a design decision to provide more flexibility to
     * the user to let them search by any common parameter.
     */
    private <T> List<ContactEntry> searchContact(SearchByType type, T entry) {
        List<ContactEntry> output = new ArrayList<ContactEntry>();

        for (ContactEntry e : addressBook) {
            switch (type) {
            case NAME: {
                if (e.getName().equals(entry))
                    output.add(e);
                break;
            }
            case FIRSTNAME: {
                if (e.getName().getFirstName().equals(entry))
                    output.add(e);
                break;
            }
            case LASTNAME: {
                if (e.getName().getLastName().equals(entry))
                    output.add(e);
                break;
            }
            case PHONENUMBER: {
                if (e.getPhoneNumber().equals(entry))
                    output.add(e);
                break;
            }
            case POSTALADDRESS: {
                if (e.getPostalAddress().equals(entry))
                    output.add(e);
                break;
            }
            case EMAILID: {
                if (e.getEmailId().equals(entry))
                    output.add(e);
                break;
            }
            case NOTE: {
                if (e.getNote().equalsIgnoreCase((String) entry))
                    output.add(e);
                break;
            }
            case SUBSTRING: {
                String concatenatedContact = ConversionHelper
                        .buildStringFromContact(e);
                if (concatenatedContact.toLowerCase().contains(((String) entry).toLowerCase()))
                    output.add(e);
                break;
            }
            }
        }
        return output;
    }

    /**
     * Returns a summary of the address book.
     */
    @Override
    public String toString() {

        return "AddressBook ["
                + (addressBook != null ? "addressBook=" + addressBook.size()
                        + " contacts" : "") + "]";
    }

}