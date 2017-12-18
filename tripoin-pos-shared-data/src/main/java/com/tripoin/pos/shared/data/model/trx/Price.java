package com.tripoin.pos.shared.data.model.trx;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tripoin.pos.shared.data.model.master.Product;
import com.tripoin.pos.shared.data.model.master.Promo;
import com.tripoin.scaffolding.data.AAuditTrail;

import javax.persistence.*;

/**
 * Created on 11/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "trx_price")
public class Price extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8673214380296140999L;

    private IncomePrice incomePrice;
    private ExpensePrice expensePrice;
    private Promo promo;

    private Product product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "income_price_id")
    public IncomePrice getIncomePrice() {
        return incomePrice;
    }

    public void setIncomePrice(IncomePrice incomePrice) {
        this.incomePrice = incomePrice;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expense_price_id")
    public ExpensePrice getExpensePrice() {
        return expensePrice;
    }

    public void setExpensePrice(ExpensePrice expensePrice) {
        this.expensePrice = expensePrice;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promo_id")
    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    @OneToOne(mappedBy = "price")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String tableName() {
        return "trx_price";
    }
}
