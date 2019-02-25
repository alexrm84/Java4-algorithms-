package alexrm84.iterator;

public class LinkIteratorApp {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        list.display();
        System.out.println("----------------------------");
        Link t = new Link("Sergey", 10);
        itr.reset();
        while (!itr.atEnd()){
            if (itr.getCurrent().equals(t)){
                itr.insertAfter("Nikolay", 33);
            }
            itr.nextLink();
        }
        list.display();

    }

}
