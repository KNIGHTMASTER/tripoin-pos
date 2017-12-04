package com.tripoin.pos.shared.data.dto.response;

import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ProductStockResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1352950534802043612L;

    private int warehouseStock;
    private int displayStock;
    private ProductUnitResponseDTO unit;

    public int getWarehouseStock() {
        return warehouseStock;
    }

    public void setWarehouseStock(int warehouseStock) {
        this.warehouseStock = warehouseStock;
    }

    public int getDisplayStock() {
        return displayStock;
    }

    public void setDisplayStock(int displayStock) {
        this.displayStock = displayStock;
    }

    public ProductUnitResponseDTO getUnit() {
        return unit;
    }

    public void setUnit(ProductUnitResponseDTO unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ProductStockResponseDTO{" +
                "warehouseStock=" + warehouseStock +
                ", displayStock=" + displayStock +
                ", unit=" + unit +
                '}';
    }
}
