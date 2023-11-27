package model;

import util.IDGenerator;

public class Volunteer {
        private int id;
        private String name;
        private  String contactNumber;
        private String emailAddress;

        public Volunteer( String name, String contactNumber, String emailAddress) {
            this.id = IDGenerator.getNextIdCounter();
            this.name = name;
            this.contactNumber = contactNumber;
            this.emailAddress = emailAddress;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        @Override
        public String toString() {
            return "Volunteer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", contactNumber='" + contactNumber + '\'' +
                    ", emailAddress='" + emailAddress + '\'' +
                    '}';
        }
    }
