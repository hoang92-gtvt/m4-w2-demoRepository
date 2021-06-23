package model;

import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class StudentForm {
    private Long id;

    @NonNull
    @Size(min=3, max =50 )
    private String firstName;
    @NonNull
    @Size(min=3, max =50)
    private String lastName;

    @Min(18)
    private Long age;

    @Pattern(regexp = "(^[a-z][?]*$)", message = "bat dau bang chu thuong")
    @Pattern(regexp = "(^?[0-9a-zA-z/.]*@[/.a-zA-Z ]{2,5}$)", message = "phai co @")
    private String email;

    @Pattern(regexp = "(^0[0-9]{9,10}$)")
    private String phone;

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

    public StudentForm(Long id, @NonNull @Size(min = 3, max = 50) String firstName, @NonNull @Size(min = 3, max = 50) String lastName, @Min(18) Long age, @Pattern(regexp = "(^[a-z][?]*$)", message = "bat dau bang chu thuong") @Pattern(regexp = "(^?[0-9a-zA-z/.]*@[/.a-zA-Z ]{2,5}$)", message = "phai co @") String email, String phone, Category category, MultipartFile img) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.category = category;
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
