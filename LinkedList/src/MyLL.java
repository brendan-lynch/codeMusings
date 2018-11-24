public class MyLL {
    private Node head;
    private Node tail;

    public MyLL()
    {
        head = null;
        tail = null;
    }

    public void insert(int value)
    {
        Node insert = new Node(value);

        if(head == null)
        {
            head = insert;
            tail = insert;
        }
        else
        {
            tail.setNext(insert);
            tail = tail.next();
        }
    }

    public void insertHead(int value)
    {
        Node insert = new Node(value);
        insert.setNext(head);
        head = insert;
        if(insert.next() == null)
        {
            tail = insert;
        }
    }

    public void delete(int value)
    {
        Node remove = null;
        if(head.value() == value)
        {
            remove = head;
            head = head.next();
            if(head == null)
            {
                tail = null;
            }
        }
        else
        {

            Node runner = head;
            while(runner.next() != null)
            {
                if(runner.next().value() == value)
                {
                    remove = runner.next();
                    if(remove == tail)
                    {
                        tail = runner;
                    }

                    runner.setNext(runner.next().next());
                    break;
                }

                runner = runner.next();
            }
        }

        if(remove != null)
        {
            remove.setNext(null);
        }
    }

    public boolean contains(int value)
    {
        Node runner = head;
        while(runner != null)
        {
            if(runner.value() == value)
            {
                return true;
            }

            runner = runner.next();
        }

        return false;
    }
}
