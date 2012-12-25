package edu.nyu.pqs.hm1021.ps1;

/**
 * Constructs an object of ContactEntry to save in the address book. The
 * ContactEntry object has two required fields, name and phone number, and few
 * optional fields like email address, postal address, note etc. An object of
 * the ContactEntry can be created by using Builder() method of Builder pattern.
 * 
 * @author Hiral Mehta
 * 
 */
public class ContactEntry {

    private ContactName name;
    private PostalAddress postalAddress;
    private PhoneNumber phoneNumber;
    private EmailAddress emailId;
    private String note;

    /**
     * Builds the ContactEntry object in which there are few required fields and
     * few optional fields. Purpose of using Builder pattern is to provide
     * flexibility in adding fields.
     * 
     * @author Hiral Mehta
     * 
     */
    public static class Builder {

        // Required parameters
        private ContactName name;
        private PhoneNumber contactPhone;

        // Optional parameters
        private PostalAddress postalAddress = new PostalAddress.Builder("")
                .build();
        private EmailAddress emailId = new EmailAddress("");
        private String note = "";

        /**
         * Instantiates an object of ContactEntry with required fields as name
         * and phone number.
         * 
         * @param name
         *            Object of FullName of the contact
         * @param num
         *            Object of PhoneNumber which is phone number of the contact
         */
        public Builder(ContactName name, PhoneNumber num) {
            this.name = name;
            this.contactPhone = num;
        }

        /**
         * Method to add optional field postal address to the contact object.
         * 
         * @param addr
         *            Object of PostalAddress
         * @return Object of Builder() so as to allow invocation of other
         *         optional parameter methods.
         */
        public Builder postalAddress(PostalAddress addr) {
            postalAddress = new PostalAddress.Builder(addr.getCountry())
                    .apt(addr.getApt()).city(addr.getCity())
                    .street(addr.getStreet()).state(addr.getState()).build();
            return this;
        }

        /**
         * Method to add optional field email address to the contact object.
         * 
         * @param email
         *            Object of EmailAddress
         * @return Object of Builder() so as to allow invocation of other
         *         optional parameter methods.
         * @throws IllegalArgumentException
         *             IF the email address is not in valid format
         */
        public Builder emailId(EmailAddress email) {
            this.emailId = email;
            return this;
        }

        /**
         * Method to add optional field note to the contact object.
         * 
         * @param note
         *            Note to add to the contact object
         * @return Method to add optional field email address to the contact
         *         object.
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }

        /**
         * Builds the actual ContactEntry object which is returned after setting
         * the required and optional fields of the ContactEntry object.
         * 
         * @return The actual ContactEntry object
         */
        public ContactEntry build() {
            return new ContactEntry(this);
        }
    }

    /*
     * This constructor kept private as it should not be invoked to create
     * objects. Only Builder can be used to do the same
     */
    private ContactEntry(Builder builder) {
        name = builder.name;
        postalAddress = builder.postalAddress;
        phoneNumber = builder.contactPhone;
        emailId = builder.emailId;
        note = builder.note;
    }

    /*
     * The getters are kept public as per the idea that the user of the API,
     * most likely an application developer, should be given access to fields
     * but not modify it. The getters are returning either immutable objects or
     * defensive copies (if required) which makes the API more robust and the
     * design more flexible.
     */
    /**
     * Returns ContactName object stored in the ContactEntry object
     * 
     * @return Name of the contact
     */
    public ContactName getName() {
        // returning name without making defensive copy
        // because ContactName class is immutable
        // since it uses Builder Pattern.
        return name;
    }

    /**
     * Returns PostalAddress object stored in the ContactEntry object
     * 
     * @return postal address of the contact
     */
    public PostalAddress getPostalAddress() {
        // returning postalAddress without making defensive copy
        // because PostalAddress class is immutable
        // since it implements Builder Pattern.
        return postalAddress;
    }

    /**
     * Returns PhoneNumber object stored in the ContactEntry object
     * 
     * @return phone number of the contact
     */
    public PhoneNumber getPhoneNumber() {
        return new PhoneNumber(phoneNumber.getPhoneNum());
    }

    /**
     * Returns EmailAddress object stored in the ContactEntry object
     * 
     * @return email id of the contact
     */
    public EmailAddress getEmailId() {
        return new EmailAddress(emailId.getEmailId());
    }

    /**
     * Returns note stored in the ContactEntry object
     * 
     * @return note stored for that contact
     */
    public String getNote() {
        return note;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result
                + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result
                + ((postalAddress == null) ? 0 : postalAddress.hashCode());
        return result;
    }

    /**
     * Two ContactEntry objects are considered equal, if all their fields match.
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ContactEntry)) {
            return false;
        }
        ContactEntry other = (ContactEntry) obj;
        return (name.equals(other.getName())
                && phoneNumber.equals(other.getPhoneNumber())
                && postalAddress.equals(other.getPostalAddress())
                && emailId.equals(other.getEmailId()) && note
                    .equalsIgnoreCase(other.getNote()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ContactEntry ["
                + (name != null ? "name=" + name + ", " : "")
                + (postalAddress != null ? "postalAddress=" + postalAddress
                        + ", " : "")
                + (phoneNumber != null ? "phoneNumber=" + phoneNumber + ", "
                        : "")
                + (emailId != null ? "emailId=" + emailId + ", " : "")
                + (note != null ? "note=" + note : "") + "]";
    }

}