package com.tripoin.pos.shared.data.dto.response.trx;

import com.tripoin.pos.shared.data.dto.response.master.EmployeeResponseDTO;
import com.tripoin.pos.shared.data.dto.response.master.PointOfSalesResponseDTO;
import com.tripoin.scaffolding.data.dto.response.BaseResponseDTO;

import java.math.BigDecimal;

/**
 * Created on 12/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class PosHeaderResponseDTO extends BaseResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 386805670428766440L;

    private CashierBalanceDetailResponseDTO cashierBalanceDetail;
    private PointOfSalesResponseDTO pointOfSales;
    private EmployeeResponseDTO employeeResponse;
    private BigDecimal debit;
    private BigDecimal credit;

    public CashierBalanceDetailResponseDTO getCashierBalanceDetail() {
        return cashierBalanceDetail;
    }

    public void setCashierBalanceDetail(CashierBalanceDetailResponseDTO cashierBalanceDetail) {
        this.cashierBalanceDetail = cashierBalanceDetail;
    }

    public PointOfSalesResponseDTO getPointOfSales() {
        return pointOfSales;
    }

    public void setPointOfSales(PointOfSalesResponseDTO pointOfSales) {
        this.pointOfSales = pointOfSales;
    }

    public EmployeeResponseDTO getEmployeeResponse() {
        return employeeResponse;
    }

    public void setEmployeeResponse(EmployeeResponseDTO employeeResponse) {
        this.employeeResponse = employeeResponse;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }
}
