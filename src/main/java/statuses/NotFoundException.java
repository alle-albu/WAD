package statuses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nothing found")
public class NotFoundException extends RuntimeException {
	public NotFoundException() {
		super();
	}
}
