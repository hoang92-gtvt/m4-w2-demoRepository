package controller;

import model.Category;
import model.Student;
import model.StudentForm;
import org.apache.commons.io.FileUtils;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.category.ICategoryService;
import service.student.IStudentService;

import javax.validation.Valid;
import java.io.File;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICategoryService categoryService;

//    @Autowired
//    private Environment environment;

    @Value("${file-upload}")
    private String fileUpload;

//khai bao thuoc tinh luon mang theo cho cac reponse
    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAll();
    }


    @GetMapping("/home")
    public ModelAndView listCustomers() {
        List<Student> studentList = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", studentList);
        System.out.println(fileUpload);
        return modelAndView;
    }



    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new StudentForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@Validated @ModelAttribute("student") StudentForm studentForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return new ModelAndView("/student/create");
        }

        MultipartFile multipartFile = studentForm.getImg();
        String file_name = multipartFile.getOriginalFilename();
        String pathName = fileUpload+ file_name;
        try{
            FileCopyUtils.copy(multipartFile.getBytes(), new File(pathName));

        }catch(Exception e){
            e.printStackTrace();
        }
        Student student = new Student();
        student.setId(studentForm.getId()) ;
        student.setFirstName(studentForm.getFirstName());
        student.setLastName(studentForm.getLastName());
        student.setAge(studentForm.getAge());
        student.setEmail(studentForm.getEmail());
        student.setPhone(studentForm.getPhone());
        student.setCategory(studentForm.getCategory());
        student.setImg(file_name);

        studentService.save(student);

        //tra view xac nhan
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", studentForm);
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }




    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Student student= studentService.findById(id);
        if (student != null) {
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            modelAndView.addObject("student", student);
            modelAndView.addObject("studentForm", new StudentForm());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(StudentForm studentForm) {

        MultipartFile multipartFile = studentForm.getImg();
        String fileName = multipartFile.getOriginalFilename();
        String pathName = fileUpload+ fileName;
        try{
            FileCopyUtils.copy(multipartFile.getBytes(), new File(pathName));

        }catch(Exception e){
            e.printStackTrace();
        }

        Student student = new Student();

        student.setId(studentForm.getId());
        student.setFirstName(studentForm.getFirstName());
        student.setLastName(studentForm.getLastName());
        student.setCategory(studentForm.getCategory());
        student.setImg(fileName);

        studentService.save(student);

        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }



    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Student student = studentService.findById(id);
        if (student != null) {
            ModelAndView modelAndView = new ModelAndView("/student/delete");
            modelAndView.addObject("student", student);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("student") Student student1) {
        studentService.remove(student1.getId());
        return "redirect:/home";
    }




}
