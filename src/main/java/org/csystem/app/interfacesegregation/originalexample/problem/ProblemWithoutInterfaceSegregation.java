package org.csystem.app.interfacesegregation.originalexample.problem;

public class ProblemWithoutInterfaceSegregation {
}



interface IDoor {
    void open();
    void close();
    void timeout(int duration);
}


class TimedDoor implements IDoor {

    @Override
    public void open()
    {

    }

    @Override
    public void close()
    {

    }

    @Override
    public void timeout(int duration)
    {

    }
}

class Door implements IDoor {

    @Override
    public void open()
    {

    }

    @Override
    public void close()
    {

    }

    @Override
    public void timeout(int duration)
    {
        // bu bu durumda mecburen override edilecek, kullanilmamasina ragmen.
        // bu sinifin timeout'u olamamasina ragmen, mecburen concrete olabilmek icin destekleyecek
        throw new UnsupportedOperationException("Not supported yet!");
    }
}
