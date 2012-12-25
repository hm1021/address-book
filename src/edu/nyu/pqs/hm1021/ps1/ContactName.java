package edu.nyu.pqs.hm1021.ps1;

/**
 * Constructs an object of ContactName. ContactEntry object requires object of
 * this class to save name of the contact. The required field is first name of
 * the contact, last name and middle name are optional.
 * 
 * @author Hiral Mehta
 * 
 */
public class ContactName {

    private String firstName;
    private String lastName;
    private String middleName;

    public static class Builder {
        // Required parameters
        private String firstName;

        // Optional parameters
        private String lastName = "";
        private String middleName = "";

        /**
         * Builds an object of ContactName with a compulsory field as first name.
         * 
         * @param firstname First name of the contact
         */
        public Builder(String firstname) {
            this.firstName = firstname;
        }

        /**
         * Adds last name to the ContactName object
         * @param lastname Last name of the contact
         * @return Object of Builder() so as to allow invocation of other
         *         optional parameter methods.
         */
        public Builder lastName(String lastname) {
            this.lastName = lastname;
            return this;
        }

        /**
         * Adds middle name to the ContactName object
         * @param middlename Middle name of the contact
         * @return Object of Builder() so as to allow invocation of other
         *         optional parameter methods.
         */
        public Builder middleName(String middlename) {
            this.middleName = middlename;
            return this;
        }

        /**
         * Builds the actual ContactEntry object which is returned after setting
         * the required and optional fields of the ContactEntry object.
         * 
         * @return The actual ContactEntry object
         */
        public ContactName build() {
            return new ContactName(this);
        }
    }
    
    /*
     * This constructor kept private as it should not be invoked to create
     * objects. Only Builder can be used to do the same
     */
    private ContactName(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        middleName = builder.middleName;
    }

    /**
     * Returns first name of the contact
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns last name of the contact
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns middle name of the contact
     * @return  middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result
                + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result
                + ((middleName == null) ? 0 : middleName.hashCode());
        return result;
    }

    /**
     * Two ContactNames are considered equal if all their fields match.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ContactName)) {
            return false;
        }
        ContactName other = (ContactName) obj;
        return (firstName.equalsIgnoreCase(other.getFirstName())
                && lastName.equalsIgnoreCase(other.getLastName()) && middleName
                    .equalsIgnoreCase(other.getMiddleName()));
    }

    /**
     * String format of the ContactName object
     */
    @Override
    public String toString() {
        return "ContactName ["
                + (firstName != null ? "firstName=" + firstName + ", " : "")
                + (lastName != null ? "lastName=" + lastName + ", " : "")
                + (middleName != null ? "middleName=" + middleName : "") + "]";
    }

}