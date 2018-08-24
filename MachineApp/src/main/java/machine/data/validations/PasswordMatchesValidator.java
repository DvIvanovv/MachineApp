package machine.data.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordMatchesValidator 
implements ConstraintValidator<PasswordMatches, Object> { 
   private String field;
   private String fieldMatch;
   
  @Override
  public void initialize(PasswordMatches constraintAnnotation) {      
	  this.field = constraintAnnotation.field();
	  this.fieldMatch = constraintAnnotation.fieldMatch();
  }
  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext context){   
 
	  	Object fieldValue = new BeanWrapperImpl(obj).getPropertyValue(field);
	  	Object fieldMatchValue = new BeanWrapperImpl(obj).getPropertyValue(fieldMatch);
	  	
	  	if (fieldValue == null && fieldMatchValue == null) {
	  		return true;
	  	}
	  	return fieldValue.equals(fieldMatchValue);
  }     
}