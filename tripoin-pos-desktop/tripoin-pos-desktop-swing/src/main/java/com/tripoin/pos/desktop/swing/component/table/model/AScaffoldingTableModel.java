package com.tripoin.pos.desktop.swing.component.table.model;

import com.tripoin.pos.desktop.swing.component.table.ITableModelListener;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created on 11/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public abstract class AScaffoldingTableModel<DATA> extends AbstractTableModel implements ITableModelListener<DATA> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5474186864381027679L;

    protected List<DATA> dataList = new ArrayList<>();

    public abstract String [] getColumnNames();

    public void setDataList(List<DATA> p_DATAList) {
        this.dataList = p_DATAList;
        fireTableDataChanged();
    }

    @Override
    public boolean add(DATA p_Object) {
        try{
            return dataList.add(p_Object);
        }finally{
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    @Override
    public DATA get(int p_Index) {
        return dataList.get(p_Index);
    }

    @Override
    public DATA set(int p_Index, DATA p_Element) {
        try{
            return dataList.set(p_Index, p_Element);
        }finally{
            fireTableRowsUpdated(p_Index, p_Index);
        }
    }

    @Override
    public boolean removeAll(Collection<DATA> p_CollectionObjects) {
        try{
            return dataList.removeAll(p_CollectionObjects);
        }finally{
            fireTableDataChanged();
        }
    }

    @Override
    public DATA remove(int p_Index) {
        try{
            return dataList.remove(p_Index);
        }finally{
            fireTableRowsDeleted(p_Index, p_Index);
        }
    }

    @Override
    public int getRowCount() {
        try {
            return dataList.size();
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return getColumnNames().length;
    }

    @Override
    public String getColumnName(int column) {
        return getColumnNames()[column];
    }
}
