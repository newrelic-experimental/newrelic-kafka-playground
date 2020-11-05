package newrelic.kafkaplayground.common.messages;

public class ApplicationMessage {
    
    public String userId;
    
    public String messageId;
    
    public ApplicationMessage(String userId, String messageId) {
        this.userId = userId;
        this.messageId = messageId;
    }
    
}