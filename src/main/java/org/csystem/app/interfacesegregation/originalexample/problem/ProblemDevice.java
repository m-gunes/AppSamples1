package org.csystem.app.interfacesegregation.originalexample.problem;

public class ProblemDevice {
}


interface IDevice {
    void print();
    void fax();
    void scan();
}


class Printer implements IDevice {
    @Override
    public void print()
    {

    }

    @Override
    public void fax()
    {
        throw new UnsupportedOperationException("Not supported"); // problem
    }

    @Override
    public void scan()
    {
        throw new UnsupportedOperationException("Not supported"); // problem
    }
}
