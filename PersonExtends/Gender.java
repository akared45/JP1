package PersonExtends;

public enum Gender {
    Male("Male"),
    Female("Female"),
    Other("Other");

    private String genderLabel;
    Gender(String gender) {
        this.genderLabel = gender;
    }

    public String getGender() {
        return genderLabel;
    }

    public void setGender(String genderLabel) {
        this.genderLabel = genderLabel;
    }
}
