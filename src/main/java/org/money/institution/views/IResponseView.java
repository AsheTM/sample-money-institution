package org.money.institution.views;

import java.time.LocalDateTime;

public interface IResponseView {

    LocalDateTime now = LocalDateTime.now();

    default LocalDateTime getNow() {
        return this.now;
    }
	
}
