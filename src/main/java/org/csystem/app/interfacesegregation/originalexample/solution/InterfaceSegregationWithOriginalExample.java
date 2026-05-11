package org.csystem.app.interfacesegregation.originalexample.solution;

public class InterfaceSegregationWithOriginalExample {
}

interface IDoor {
    void open();
    void close();
}

interface ITimedDoor extends IDoor {
    void timeout(int duration);
}


class TimedDoor implements ITimedDoor {

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
}
