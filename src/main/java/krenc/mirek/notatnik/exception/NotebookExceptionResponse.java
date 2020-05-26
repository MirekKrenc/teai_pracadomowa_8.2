package krenc.mirek.notatnik.exception;

import java.util.Date;

public class NotebookExceptionResponse {

    private Date date;
    private String message;
    private String description;

    public NotebookExceptionResponse(Date date, String message, String description) {
        this.date = date;
        this.message = message;
        this.description = description;
    }

    public NotebookExceptionResponse() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "date=" + date +
                ", message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
