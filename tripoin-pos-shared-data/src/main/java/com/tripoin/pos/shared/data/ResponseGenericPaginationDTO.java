package com.tripoin.pos.shared.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 11/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public class ResponseGenericPaginationDTO<DATA> implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3722728438615546975L;

    private Boolean first;
    private Integer numberOfElements;
    private Integer size;
    private Integer number;
    private Boolean last;
    private Integer totalElements;
    private Integer totalPages;
    private List<ResponseSortingPaginationDTO> sort;
    private List<DATA> content;

    @JsonProperty("first")
    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    @JsonProperty("numberOfElements")
    public Integer getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(Integer numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @JsonProperty("last")
    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }

    @JsonProperty("totalElements")
    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    @JsonProperty("totalPages")
    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("sort")
    public List<ResponseSortingPaginationDTO> getSort() {
        return sort;
    }

    public void setSort(List<ResponseSortingPaginationDTO> sort) {
        this.sort = sort;
    }

    @JsonProperty("content")
    public List<DATA> getContent() {
        return content;
    }

    public void setContent(List<DATA> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponseGenericPaginationDTO{" +
                "first=" + first +
                ", numberOfElements=" + numberOfElements +
                ", size=" + size +
                ", number=" + number +
                ", last=" + last +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", sort=" + sort +
                ", content=" + content +
                '}';
    }
}
