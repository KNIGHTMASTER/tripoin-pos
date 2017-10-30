package com.tripoin.pos.desktop.swing.component.base;

import java.util.ResourceBundle;

/**
 * Created on 5/29/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IResourceBundleLocator {

    ResourceBundle getResourceBundle(String p_I18N);

    String getValue(String p_Key);
}
