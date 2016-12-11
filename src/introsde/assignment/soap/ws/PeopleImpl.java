package introsde.assignment.soap.ws;

import introsde.assignment.soap.model.Measure;
import introsde.assignment.soap.model.Person;
import introsde.assignment.soap.model.MeasureTypes;

import java.util.List;

import javax.jws.WebService;

//Service Implementation

@WebService(endpointInterface = "introsde.assignment.soap.ws.People",
    serviceName="PeopleService")
public class PeopleImpl implements People {

    // Method #1
    @Override
    public List<Person> getPeopleList() {
        return Person.getAll();
    }

    // Method #2
    @Override
    public Person readPerson(int id) {
        System.out.println("---> Reading Person by id = "+id);
        Person p = Person.getPersonById(id);
        return p;
    }

    // Method #3
    @Override
    public int updatePerson(Person person) {
        Person.updatePerson(person);
        return person.getIdPerson();
    }

    // Method #4
    @Override
    public int createPerson(Person person) {
        Person.savePerson(person);
        return person.getIdPerson();
    }

    // Method #5
    @Override
    public int deletePerson(int id) {
        Person p = Person.getPersonById(id);
        if (p!=null) {
            Person.removePerson(p);
            return 1;
        } else {
            return 0;
        }
    }

    // Method #6
    @Override
    public List<Measure> readPersonHistory(int id,String measureType) {
        return Measure.getMeasureHistorybyPersonIdType(id,measureType);
    }

    // Method #7
    @Override
    public List<Measure> readMeasureTypes() {
        return Measure.getAll();
    }

    // Method #8
    @Override
    public List<Measure> readPersonMeasure(int id, String measureType, int mid) {
        return Measure.getMeasureHistorybyPersonIdTypeMid(id,measureType,mid);
    }

    // Method #9
    @Override
    public int savePersonMeasure(int id, Measure m) {
        Person p = Person.getPersonById(id);
        m.setPerson(p);
        Measure.saveMeasure(m);
        return m.getIdMeasure();
    }

    // Method #10
    @Override
    public int updatePersonMeasure(int id, Measure m) {
        Person p = Person.getPersonById(id);
        m.setPerson(p);
        Measure.updateMeasure(m);
        return m.getIdMeasure();
    }

    @Override
    public int deleteMeasure(int id){
        Measure m = Measure.getMeasureById(id);
        if (m!=null) {
            Measure.removeMeasure(m);
            return 1;
        } else {
            return 0;
        }
    }

/*
    @Override
    public int updatePersonHP(int id, LifeStatus hp) {
        LifeStatus ls = LifeStatus.getLifeStatusById(hp.getIdMeasure());
        if (ls.getPerson().getIdPerson() == id) {
            LifeStatus.updateLifeStatus(hp);
            return hp.getIdMeasure();
        } else {
            return -1;
        }
    }
    */

}