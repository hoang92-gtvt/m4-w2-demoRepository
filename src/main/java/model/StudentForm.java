package model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.ManyToOne;

public class StudentForm {
    private Long id;
    private String firstName;
    private String lastName;
    private Category category;
    private MultipartFile img;

    public StudentForm() {
    }

    public StudentForm(Long id, String firstName, String lastName, MultipartFile img) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
