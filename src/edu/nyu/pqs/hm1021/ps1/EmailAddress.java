package edu.nyu.pqs.hm1021.ps1;

/**
 * Constructs an object of EmailAddress to be stored in the ContactEntry to save
 * email id of the contact. <br>
 * This class also imposes restrictions on the structure of the email address.
 * Only allows valid email addresses.
 * 
 * @author Hiral Mehta
 * 
 */
public class EmailAddress {

    private String emailId = "";

    /**
     * Constructs an object of PhoneNumber. Imposes some restrictions on the
     * structure of the phone number.<br>
     * Throws IllegalArgumentException if the phone number is not in valid
     * format.
     * 
     * @param emailId
     */
    public EmailAddress(String emailId) {
        if (!EmailAddressValidator.isValid(emailId))
            throw new IllegalArgumentException("Invalid email address");
        else
            this.emailId = emailId;
    }

    /**
     * Return the email id for the EmailAddress
     * @return email id
     */
    public String getEmailId() {
        return emailId;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
        return result;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof EmailAddress)) {
            return false;
        }
        EmailAddress other = (EmailAddress) obj;
        return emailId.equalsIgnoreCase(other.getEmailId());
    }

    /**
     * Returns string representation of email address.
     */
    @Override
    public String toString() {
        return "EmailAddress [" + (emailId != null ? "emailId=" + emailId : "")
                + "]";
    }

}