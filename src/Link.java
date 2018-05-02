public class Link {
    public String bookName;
    public int millionSold;
    public Link next;

    public Link(String bookName, int millionSold) {
        this.bookName = bookName;
        this.millionSold = millionSold;
    }
    public void display() {
        System.out.println(bookName + ": " + millionSold + ",000000");
    }
    public String toString() {
        return bookName;
    }
    public static void main(String[] args) {


    }
}

class LinkList {

    public Link firstlink;

    LinkList() {
        firstlink = null;
    }

    public boolean isEmpty() {
        return (firstlink == null);
    }

    public void insertFirstLink(String bookname, int millionSold) {
        Link newLink = new Link(bookname, millionSold);
        newLink.next = firstlink;
        firstlink = newLink;
    }

    public Link removeFirst() {
        Link linkReference = firstlink;
        if (!isEmpty()) {
            firstlink = firstlink.next;
        } else {
            System.out.println("Empty LinkedList");

        }
        return linkReference;
    }
    public void display() {
        Link theLink = firstlink;
        while (theLink != null) {
            theLink.display();
            System.out.println("Next Link" + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public Link find(String bookname) {
        Link thelink = firstlink;
        if (!isEmpty()) {
            while (thelink.bookName != bookname) {
                if (thelink.next == null) {
                    return null;

                } else {
                    thelink = thelink.next;
                }
            }
        } else {
            System.out.println("Empty LinkedList");

        }
        return thelink;
    }

    public Link removeLink(String bookName) {
        Link currentLink = firstlink;
        Link previousLink = firstlink;
        while (currentLink.bookName != bookName) {
            if (currentLink.next == null) {
                return null;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.next;

            }
        }
        if (currentLink == firstlink) {
            firstlink = firstlink.next;
        } else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }

}