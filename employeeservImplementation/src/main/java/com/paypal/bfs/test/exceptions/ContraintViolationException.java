package com.paypal.bfs.test.exceptions;

import java.util.List;

public class ContraintViolationException extends RuntimeException{

    private List<String> violations;

    public ContraintViolationException(){
        super();
    }

    public ContraintViolationException(final Exception ex){
        super(ex);
    }

    public ContraintViolationException(final List<String> violations){
        super();
        this.violations = violations;
    }

    public List<String> getViolations() {
        return violations;
    }

    public void setViolations(List<String> violations) {
        this.violations = violations;
    }
}
