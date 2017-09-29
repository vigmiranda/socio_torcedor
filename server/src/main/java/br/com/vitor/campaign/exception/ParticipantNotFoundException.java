package br.com.vitor.campaign.exception;

import br.com.vitor.core.validator.WithArguments;

import javax.persistence.EntityNotFoundException;

public class CampaignNotFoundException extends EntityNotFoundException implements WithArguments {

    private final Object[] args;

    public CampaignNotFoundException() {
        super("campaign.not.found.exception");
        this.args = new Object[0];
    }

    public CampaignNotFoundException(Integer id) {
        super("campaign.not.found.exception");
        this.args = new Object[]{id};
    }

    @Override
    public Object[] getArgs() {
        return this.args;
    }
}
