public class Test {
    public static void main(String[] args) {
        // Create a new MsgApp instance
        MsgApp msgApp = new MsgApp(10);

        // Test sending messages
        System.out.println("Sending messages:");
        msgApp.sendMessage(true, "Hello!", "Alice");
        msgApp.sendMessage(false, "Hi there!", "Bob");
        msgApp.sendMessage(true, "How are you?", "Alice");
        msgApp.sendMessage(false, "Good morning!", "Charlie");

        // Display all messages
        System.out.println("\nDisplaying all messages:");
        msgApp.displayMessages();

        // Test deleting a message
        System.out.println("Deleting Alice's first message:");
        boolean deleteResult = msgApp.deleteMessage("Alice", 0);
        System.out.println("Delete successful: " + deleteResult);

        // Display messages after deletion
        System.out.println("\nDisplaying messages after deletion:");
        msgApp.displayMessages();

        // Test deleting a non-existent message
        System.out.println("Trying to delete a non-existent message:");
        deleteResult = msgApp.deleteMessage("David", 0);
        System.out.println("Delete successful: " + deleteResult);

        // Test sending more messages after deletion
        System.out.println("\nSending more messages:");
        msgApp.sendMessage(true, "What's up?", "Bob");
        msgApp.sendMessage(false, "Good afternoon!", "Alice");

        // Display final state of messages
        System.out.println("\nFinal state of messages:");
        msgApp.displayMessages();
    }
}

//Console based application
//Messaging app :
//display(done)
//deleted;
//not read
//send messages(done)
//Systematic ID
// Conversations in a separate array per person
// read(categorized)
// delete messages
