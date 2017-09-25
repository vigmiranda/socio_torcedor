package br.com.vitor.campaign.service;


import br.com.vitor.campaign.domain.Person;
import br.com.vitor.campaign.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void merge(Person person) {
        personRepository.save(person);}

    public void remove(Person person) {
        personRepository.delete(person.getId());}

    public List<Person> list() {return (List<Person>) personRepository.findAll();}
}
