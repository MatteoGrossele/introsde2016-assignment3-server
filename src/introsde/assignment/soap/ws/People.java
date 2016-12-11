package introsde.assignment.soap.ws;

import introsde.assignment.soap.model.Measure;
import introsde.assignment.soap.model.Person;
import introsde.assignment.soap.model.MeasureTypes;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface People {
    // Method #1
    @WebMethod(operationName="getPeopleList")
    @WebResult(name="people") 
    public List<Person> getPeopleList();

    // Method #2
    @WebMethod(operationName="readPerson")
    @WebResult(name="person") 
    public Person readPerson(@WebParam(name="personId") int id);

    // Method #3
    @WebMethod(operationName="updatePerson")
    @WebResult(name="personId") 
    public int updatePerson(@WebParam(name="person") Person person);
  
    // Method #4
    @WebMethod(operationName="createPerson")
    @WebResult(name="personId") 
    public int createPerson(@WebParam(name="person") Person person);
   
    // Method #5
    @WebMethod(operationName="deletePerson")
    @WebResult(name="result") 
    public int deletePerson(@WebParam(name="personId") int id);

    // Method #6
    @WebMethod(operationName="readPersonHistory")
    @WebResult(name="healthProfile-history") 
    public List<Measure> readPersonHistory(@WebParam(name="personId") int id, @WebParam(name="measureType") String measureType);
    
    // Method #7
    @WebMethod(operationName="readMeasureTypes")
    @WebResult(name="measures") 
    public List<Measure> readMeasureTypes();

    // Method #8
    @WebMethod(operationName="readPersonMeasure")
    @WebResult(name="measureId") 
    public List<Measure> readPersonMeasure(@WebParam(name="personId") int id, @WebParam(name="measureType") String measureType, @WebParam(name="mid") int mid);

    // Method #9
    @WebMethod(operationName="savePersonMeasure")
    @WebResult(name="measureId") 
    public int savePersonMeasure(@WebParam(name="personId") int id, @WebParam(name="m") Measure m);

    // Method #10
    @WebMethod(operationName="updatePersonMeasure")
    @WebResult(name="measureId") 
    public int updatePersonMeasure(@WebParam(name="personId") int id, @WebParam(name="m") Measure m);

    @WebMethod(operationName="deleteMeasure")
    @WebResult(name="result") 
    public int deleteMeasure(@WebParam(name="measureId") int id);
    /*@WebMethod(operationName="updatePersonHealthProfile")
    @WebResult(name="hpId") 
    public int updatePersonHP(@WebParam(name="personId") int id, @WebParam(name="healthProfile") LifeStatus hp);
    */
}