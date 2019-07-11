
package com.example.computer.model.response;

import java.io.Serializable;


public class SResponse implements Serializable {

    @Override
    public String toString() {
        return "SResponse{" + "status=" + status + ", messages=" + messages + '}';
    }

    public SResponse() {
    }
     private boolean status;
 
    private String messages;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
