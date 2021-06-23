//package validator;
//
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//public class CheckEmail implements Validator {
//    private String email;
//
//    public CheckEmail() {
//    }
//
//    public CheckEmail(String email) {
//        this.email = email;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return CheckEmail.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        CheckEmail checkEmail = (CheckEmail) target;
//        String email = checkEmail.getEmail();
//        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
//
//        if (!email.matches("(^[a-z][?]*$)")){
//            errors.rejectValue("email", "email.start");
//        }
//
//        if (!email.matches("(^?[0-9a-zA-z/.]*@[/.a-zA-Z ]{2,5}$)")){
//            errors.rejectValue("email", "email.matches");
//        }
//    }
//}
