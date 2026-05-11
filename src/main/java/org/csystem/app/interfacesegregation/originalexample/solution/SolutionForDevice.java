package org.csystem.app.interfacesegregation.originalexample.solution;

public class SolutionForDevice {
}

interface IPrint {
    void print();
}

interface IFax {
    void fax();
}

interface IScan {
    void scan();
}

interface ICompactDevice extends IPrint, IFax, IScan {
}

interface IPrintScan extends IPrint, IScan {
    void connect();
}

class Printer implements IPrint {
    @Override
    public void print()
    {

    }
}
