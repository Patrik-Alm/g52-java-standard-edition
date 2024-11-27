package se.lexicon.stream_api.service;

import se.lexicon.stream_api.model.Person;

import java.util.List;

public interface People {

    People INSTANCE = PeopleImpl.getInstance();

    List<Person> getPeople();
}
