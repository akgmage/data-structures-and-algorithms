import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAtMid(int data, int position) {
        if (position <= 0) {
            insertAtStart(data);
        } else if (position >= size()) {
            insertAtEnd(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            int count = 0;
            while (count < position - 1) {
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next.prev = newNode;
            newNode.prev = current;
            current.next = newNode;
        }
    }

    public void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deleteAtMid(int position) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
        } else if (position <= 0) {
            deleteAtStart();
        } else if (position >= size() - 1) {
            deleteAtEnd();
        } else {
            Node current = head;
            int count = 0;
            while (count < position) {
                current = current.next;
                count++;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class doubly_linked_list {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);

        int choice, data, position;

        while (true) {
            System.out.println("\nDoubly Linked List Operations:");
            System.out.println("1. Insert at the start");
            System.out.println("2. Insert at the end");
            System.out.println("3. Insert at a specific position");
            System.out.println("4. Delete from the start");
            System.out.println("5. Delete from the end");
            System.out.println("6. Delete from a specific position");
            System.out.println("7. Traverse the list");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            if (choice == 8) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the data to be inserted: ");
                    data = scanner.nextInt();
                    dll.insertAtStart(data);
                    System.out.println("Node inserted at the start.");
                    break;
                case 2:
                    System.out.print("Enter the data to be inserted: ");
                    data = scanner.nextInt();
                    dll.insertAtEnd(data);
                    System.out.println("Node inserted at the end.");
                    break;
                case 3:
                    System.out.print("Enter the data to be inserted: ");
                    data = scanner.nextInt();
                    System.out.print("Enter the position to insert at: ");
                    position = scanner.nextInt();
                    dll.insertAtMid(data, position);
                    System.out.println("Node inserted at position " + position + ".");
                    break;
                case 4:
                    dll.deleteAtStart();
                    System.out.println("Node deleted from the start.");
                    break;
                case 5:
                    dll.deleteAtEnd();
                    System.out.println("Node deleted from the end.");
                    break;
                case 6:
                    System.out.print("Enter the position to delete from: ");
                    position = scanner.nextInt();
                    dll.deleteAtMid(position);
                    System.out.println("Node deleted from position " + position + ".");
                    break;
                case 7:
                    System.out.print("Doubly Linked List: ");
                    dll.traverse();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Exiting the program.");
    }
}
