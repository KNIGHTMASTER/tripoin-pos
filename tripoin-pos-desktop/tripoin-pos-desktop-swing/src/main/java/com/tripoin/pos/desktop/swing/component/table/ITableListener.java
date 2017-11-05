package com.tripoin.pos.desktop.swing.component.table;

/**
 * Created on 5/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public interface ITableListener {

    void refreshTable() /*throws ETCServiceException*/;

    void refreshTableWithWorker();
}
