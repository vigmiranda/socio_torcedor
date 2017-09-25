package br.com.vitor.campaign.exception;

import br.com.vitor.core.validator.WithArguments;

import javax.persistence.EntityNotFoundException;

public class PersonNotFoundException extends EntityNotFoundException implements WithArguments {

    private final Object[] args;

    public PersonNotFoundException() {
        super("person.not.found.exception");
        this.args = new Object[0];
    }

    public PersonNotFoundException(Integer id) {
        super("person.not.found.exception");
        this.args = new Object[]{id};
    }

    @Override
    public Object[] getArgs() {
        return this.args;
    }
}
