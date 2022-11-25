package me.szkristof.szakibuszapi.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String message;

    public ErrorResponse(String message) {
        super();
        this.message = message;
    }
}
