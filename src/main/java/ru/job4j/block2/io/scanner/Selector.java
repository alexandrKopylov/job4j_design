package ru.job4j.block2.io.scanner;

public class Selector {
    private boolean name;
    private boolean age;
    private boolean birthDate;
    private boolean education;
    private boolean children;

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }

    public boolean isAge() {
        return age;
    }

    public void setAge(boolean age) {
        this.age = age;
    }

    public boolean isBirthDate() {
        return birthDate;
    }

    public void setBirthDate(boolean birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isEducation() {
        return education;
    }

    public void setEducation(boolean education) {
        this.education = education;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }
}
