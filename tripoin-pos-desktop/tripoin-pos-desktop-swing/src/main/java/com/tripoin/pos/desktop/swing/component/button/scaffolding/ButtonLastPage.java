package com.tripoin.pos.desktop.swing.component.button.scaffolding;

import com.tripoin.pos.desktop.swing.component.button.base.SimpleIconButton;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created on 11/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ButtonLastPage extends SimpleIconButton {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4372896591359211351L;

    @Value("${button.lastpage.imageurl}")
    private String nextPageImageUrl;

    @Override
    public String getImagePath() {
        return nextPageImageUrl;
    }
}
