package com.bariserta.northwind.core.utilites.results;

public class SuccessResult extends Result{

    public SuccessResult() {
        super(true);
    }

    public SuccessResult(boolean success, String message) {
        super(true, message);
    }
}
