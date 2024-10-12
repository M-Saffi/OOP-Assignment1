import java.time.LocalDateTime;

public class Message {

   String Reciever;
   String Sender;
   LocalDateTime date;
   String message;
   Boolean status;
    public Message(){

    }

    public Message(Boolean status, String message, String sender) {
        this.status = status;
        this.message = message;
        Sender = sender;
        date=LocalDateTime.now();

    }

    public String getReciever() {
        return Reciever;
    }

    public String getSender() {
        return Sender;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Reciever='" + Reciever + '\'' +
                ", Sender='" + Sender + '\'' +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
