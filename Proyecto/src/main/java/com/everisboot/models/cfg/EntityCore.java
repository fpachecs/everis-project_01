package com.everisboot.models.cfg;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
@Controller
public interface EntityCore<K extends Serializable> extends Serializable {
	K getId();
	void setId(K id);
}
