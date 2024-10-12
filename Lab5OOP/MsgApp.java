public class MsgApp {

    private Message[][] messages;
    private int senderCount = 0;

    public MsgApp(int size) {
        this.messages = new Message[size][];
    }

    public void sendMessage(Boolean status, String messageContent, String sender) {
        // Check if new sender encountered
        if (isUniqueSender(sender)) {
            messages[senderCount] = new Message[]{new Message(status, messageContent, sender)}; // Initialize with single message
            senderCount++;
        }

        // Get message list for the sender
        int senderIndex = findSenderIndex(sender);

        // Add message to sender's list
        Message[] senderMessages = messages[senderIndex];
        Message[] newMessages = new Message[senderMessages.length + 1];
        System.arraycopy(senderMessages, 0, newMessages, 0, senderMessages.length);
        newMessages[newMessages.length - 1] = new Message(status, messageContent, sender);
        messages[senderIndex] = newMessages;
    }

    private boolean isUniqueSender(String sender) {
        for (int i = 0; i < senderCount; i++) {
            if (messages[i] != null && messages[i][0].getSender().equals(sender)) {
                return false; // Existing sender found
            }
        }
        return true;
    }

    private int findSenderIndex(String sender) {
        for (int i = 0; i < senderCount; i++) {
            if (messages[i] != null && messages[i][0].getSender().equals(sender)) {
                return i; // Sender index found
            }
        }
        return -1; // Sender not found
    }

    public void displayMessages() {
        for (int i = 0; i < senderCount; i++) {
            if (messages[i] != null) {
                System.out.println("Sender: " + messages[i][0].getSender()); // Print sender name
                for (int j = 0; j < messages[i].length; j++) {
                    System.out.println("- " + messages[i][j].getMessage()); // Print messages
                }
                System.out.println(); // Add a newline between senders
            }
        }
    }
    public boolean deleteMessage(String sender, int messageIndex) {
        int senderIndex = findSenderIndex(sender);
        if (senderIndex == -1 || messageIndex < 0 || messageIndex >= messages[senderIndex].length) {
            return false; // Sender not found or invalid message index
        }

        Message[] senderMessages = messages[senderIndex];
        Message[] newMessages = new Message[senderMessages.length - 1];

        // Copy messages before the deleted one
        System.arraycopy(senderMessages, 0, newMessages, 0, messageIndex);
        // Copy messages after the deleted one
        System.arraycopy(senderMessages, messageIndex + 1, newMessages, messageIndex, senderMessages.length - messageIndex - 1);

        messages[senderIndex] = newMessages;

        // If all messages from a sender are deleted, remove the sender
        if (newMessages.length == 0) {
            messages[senderIndex] = null;
            // Compact the messages array
            for (int i = senderIndex; i < senderCount - 1; i++) {
                messages[i] = messages[i + 1];
            }
            senderCount--;
        }

        return true;
    }
}