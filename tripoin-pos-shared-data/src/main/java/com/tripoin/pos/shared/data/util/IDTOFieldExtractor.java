package com.tripoin.pos.shared.data.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created on 11/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IDTOFieldExtractor {
    @JsonIgnore
    String [] extractValues();
}
