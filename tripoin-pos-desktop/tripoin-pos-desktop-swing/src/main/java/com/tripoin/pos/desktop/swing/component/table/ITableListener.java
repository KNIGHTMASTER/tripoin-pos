package com.tripoin.pos.desktop.swing.component.table;

import com.tripoin.pos.desktop.swing.component.table.view.AScaffoldingTable;
import com.tripoin.pos.shared.data.ResponseGenericPaginationDTO;

/**
 * Created on 5/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public interface ITableListener {

    ResponseGenericPaginationDTO refreshTable(int p_Size, int p_TargetPage, AScaffoldingTable.FindMode p_FindMode, String p_TextToSearch);

    ResponseGenericPaginationDTO refreshTableWithWorker(int p_Size, int p_TargetPage, AScaffoldingTable.FindMode p_FindMode, String p_TextToSearch);
}
