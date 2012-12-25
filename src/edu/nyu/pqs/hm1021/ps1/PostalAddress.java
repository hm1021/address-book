package edu.nyu.pqs.hm1021.ps1;

/**
 * Constructs an object of PostalAddress. ContactEntry object requires object of
 * this class to save postal address of the contact. The required field is the
 * name of the country of the contact, and the optional fields are apartment,
 * street, city, state, zip code. The idea behind keeping just the country as
 * required fields is to give more flexibility to the users.
 * 
 * @author Hiral Mehta
 * 
 */
public class PostalAddress {

    private String street;
    private String apt;
    private String city;
    private String state;
    private String country;
    private String zip;

    /**
     * Builds the PostalAddress object in which there are few required fields
     * and few optional fields. Purpose of using Builder pattern is to provide
     * flexibility in adding fields.
     * 
     * @author Hiral Mehta
     * 
     */
    public static class Builder {
        // Required parameters
        private String country;

        // Optional parameters
        private String street = "";
        private String apt = "";
        private String city = "";
        private String state = "";
        private String zip = "";

        /**
         * Instantiates an object of PostalAddress with required fields as
         * country
         * 
         * @param country
         *            Country in which the contact lives
         */
        public Builder(String country) {
            this.country = country;
        }

        /**
         * Method to add optional field street to the contact object.
         * 
         * @param street
         *            street where the contact lives
         * @return Object of Builder() so as to allow invocation of other
         *         optional parameter methods.
         */
        public Builder street(String street) {
            this.street = street;
            return this;
        }

        /**
         * Method to add optional field apartment to the contact object.
         * 
         * @param apartment
         *            apartment of the contact
         * @return Object of Builder() so as to allow invocation of other
         *         optional parameter methods.
         */
        public Builder apt(String apt) {
            this.apt = apt;
            return this;
        }

        /**
         * Method to add optional field city to the contact object.
         * 
         * @param city
         *            city in which the contact lives
         * @return Object of Builder() so as to allow invocation of other
         *         optional parameter methods.
         */
        public Builder city(String city) {
            this.city = city;
            return this;
        }

        /**
         * Method to add optional field state to the contact object.
         * 
         * @param state
         *            state in which the contact lives
         * @return Object of Builder() so as to allow invocation of other
         *         optional parameter methods.
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

        /**
         * Method to add optional field zip to the contact object.
         * 
         * @param zip
         *            zip code
         * @return Object of Builder() so as to allow invocation of other
         *         optional parameter methods.
         */
        public Builder zip(String zip) {
            this.zip = zip;
            return this;
        }

        /**
         * Builds the actual PostalAddress object which is returned after
         * setting the required and optional fields of the PostalAddress object.
         * 
         * @return The actual PostalAddress object
         */
        public PostalAddress build() {
            return new PostalAddress(this);
        }
    }

    /*
     * This constructor kept private as it should not be invoked to create
     * objects. Only Builder can be used to do the same
     */
    private PostalAddress(Builder builder) {
        street = builder.street;
        apt = builder.apt;
        city = builder.city;
        state = builder.state;
        country = builder.country;
        zip = builder.zip;
    }

    /*
     * The getters are kept public as per the idea that the user of the API,
     * most likely an application developer, should be given access to fields
     * but not modify. The getters are returning either immutable objects or
     * defensive copies if required which makes the design more flexible.
     */

    /**
     * Returns zip code of the place where the contact lives
     * 
     * @return zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     * Returns the street where the contact lives
     * 
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Returns the apartment details of the contact
     * 
     * @return apartment
     */
    public String getApt() {
        return apt;
    }

    /**
     * Returns the city where contact lives
     * 
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the state in which contact lives
     * 
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Returns the country where contact belongs
     * 
     * @return country
     */
    public String getCountry() {
        return country;
    }

    @Override
    /**
     * {@inhertDoc}
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apt == null) ? 0 : apt.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        return result;
    }

    @Override
    /**
     * Two PostalAddresses are considered equal, if all their fields match.
     * {@inheritDoc}
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PostalAddress)) {
            return false;
        }
        PostalAddress other = (PostalAddress) obj;
        return (apt.equalsIgnoreCase(other.getApt())
                && street.equalsIgnoreCase(other.getStreet())
                && city.equalsIgnoreCase(other.getCity())
                && state.equalsIgnoreCase(other.getState()) && country
                    .equalsIgnoreCase(other.getCountry()));
    }

    @Override
    /**
     * Returns a string representation of the object.
     */
    public String toString() {
        return "PostalAddress ["
                + (street != null ? "street=" + street + ", " : "")
                + (apt != null ? "apt=" + apt + ", " : "")
                + (city != null ? "city=" + city + ", " : "")
                + (state != null ? "state=" + state + ", " : "")
                + (country != null ? "country=" + country : "") + "]";
    }

}