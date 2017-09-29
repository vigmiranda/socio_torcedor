package br.com.vitor.campaign.exception;

import br.com.vitor.core.validator.WithArguments;

import javax.persistence.EntityNotFoundException;

public class ParticipantNotFoundException extends EntityNotFoundException implements WithArguments {

    private final Object[] args;

    public ParticipantNotFoundException() {
        super("participant.not.found.exception");
        this.args = new Object[0];
    }

    public ParticipantNotFoundException(Integer id) {
        super("participant.not.found.exception");
        this.args = new Object[]{id};
    }

    @Override
    public Object[] getArgs() {
        return this.args;
    }
}
