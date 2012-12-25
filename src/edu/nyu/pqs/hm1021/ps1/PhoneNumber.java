package edu.nyu.pqs.hm1021.ps1;

/**
 * Constructs an object of PhoneNumber to be stored in the ContactEntry to save
 * phone number of the contact. <br>
 * This class also imposes some restrictions on the structure of the number. A
 * valid phone number can only contain 0-9, +, *, #, -. There is no
 * restrictions on the length of the phone number. Also, there is no restriction
 * on the format in which user wants to store the phone number.
 * 
 * @author Hiral Mehta
 * 
 */
public class PhoneNumber {

    private String phoneNum;

    /**
     * Constructs an object of PhoneNumber. Imposes some restrictions on the
     * structure of the phone number.<br>
     * Throws IllegalArgumentException if the phone number is not in valid
     * format.
     * 
     * @param phoneNum Phone number of the contact
     */
    public PhoneNumber(String phoneNum) {
        if (!PhoneNumberValidator.isValid(phoneNum))
            throw new IllegalArgumentException("Invalid phone number");
        else
            this.phoneNum = phoneNum;
    }
    
    /**
     * Returns the phone number for this object
     * @return phoneNum for this PhoneNumber object
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((phoneNum == null) ? 0 : phoneNum.hashCode());
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
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber other = (PhoneNumber) obj;
        return phoneNum.equals(other.getPhoneNum());
    }

    @Override
    /**
     * Returns string representation of the phone number.
     */
    public String toString() {
        return "PhoneNumber ["
                + (phoneNum != null ? "phoneNum=" + phoneNum : "") + "]";
    }

}
