class Example
{
    String data = null;
    synchronized void insert(String s)
    {
        try {
            while (data != null)
            {
                // data already holds a string
                // wait for some other Thread
                //to remove it!
                // awaken one other waiting Thread
                notify();
                // release the monitor
                wait();
            }
        } catch (InterruptedException e) {}
        // data is now null
        data = s;
        notify();
    }

    synchronized String extract()
    {
        try {
            while (data == null)
            {
                // no data to extract
                // wait for some to arrive
                // awaken one other waiting Thread
                notify();
                // release the monitor and go to sleep
                wait();
            }
        } catch (InterruptedException e) {}

        // data is now not full
        String temp = data;
        data = null;
        notify();
        return temp;
    }
    // more methods
}