package com.everisboot.models.cfg;

import java.io.Serializable;

public interface EntityCore<K extends Serializable> extends Serializable {
	K getId();
	void setId(K id);
}
